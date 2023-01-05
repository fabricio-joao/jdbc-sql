package cursojdbc.conexaobancosdedados.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cursojdbc.conexaobancosdedados.ConexaoBancoDados;
import cursojdbc.conexaobancosdedados.ExcecaoBancoDados;
import cursojdbc.conexaobancosdedados.dao.VendedoresDao;
import cursojdbc.conexaobancosdedados.entidades.Departamentos;
import cursojdbc.conexaobancosdedados.entidades.Vendedores;

public class VendedoresDaoJDBC implements VendedoresDao {

	private Connection conexao;

	public VendedoresDaoJDBC(Connection conexao) {
		this.conexao = conexao;
	}

	@Override
	public void inserir(Vendedores obj) {
		
		PreparedStatement ps = null;
		try {
			ps = conexao.prepareStatement(
					"insert into Vendedores "
					+"(Nome, Email, Nascimento, Salario, DepartamentosId) "
					+"values "
					+"(?, ?, ?, ?, ?) ");
			ps.setString(1, obj.getNome());
			ps.setString(2, obj.getEmail());
			ps.setDate(3, obj.getNascimento());
			ps.setDouble(4, obj.getSalario());
			ps.setInt(5, obj.getDepartamentos().getId());
			
			int linha = ps.executeUpdate();
			if(linha > 0) {
				System.out.println("Vendedor cadastrado!" + linha);
			} else {
				System.out.println("Vendedor não cadastrado!");
			}
		}
		catch (SQLException e) {
			throw new ExcecaoBancoDados(e.getMessage());
		} 
		finally {
			ConexaoBancoDados.fecharStatement(ps);
	    }
	}

	@Override
	public void atualizar(Vendedores obj) {
		
		PreparedStatement ps = null;
		try {
			ps = conexao.prepareStatement(
					"update Vendedores "
				  + "set Nome = ?, Email = ?, Nascimento = ?, Salario = ?, DepartamentosId = ? "
				  + "where Vendedores.Id = ? ");
			
			ps.setString(1, obj.getNome());
			ps.setString(2, obj.getEmail());
			ps.setDate(3, obj.getNascimento());
			ps.setDouble(4, obj.getSalario());
			ps.setInt(5, obj.getDepartamentos().getId());
			ps.setInt(6, obj.getId());
			
			int linha = ps.executeUpdate();
			if(linha > 0) {
				System.out.println("Cadastro atualizado! " + linha);
			} else {
				System.out.println("Cadastro não atualizado!");
			}
		}
		catch (SQLException e) {
			throw new ExcecaoBancoDados(e.getMessage());
		} 
		finally {
			ConexaoBancoDados.fecharStatement(ps);
	    }
	}

	@Override
	public void deletar(Vendedores obj) {
		
		PreparedStatement ps = null;
		try {
			ps = conexao.prepareStatement(
					"delete from Vendedores "
				  + "where Vendedores.Id = ?");
			ps.setInt(1, obj.getId());
			
			int linha = ps.executeUpdate();
			
			if(linha > 0) {
				System.out.println("Vendedor deletado! " + linha);
			} else {
				System.out.println("Vendedor no sistema!");
			}
		}
		catch (SQLException e) {
			throw new ExcecaoBancoDados(e.getMessage());
		} 
		finally {
			ConexaoBancoDados.fecharStatement(ps);
	    }
	}

	@Override
	public Vendedores buscarPorId(Integer id) {

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = conexao.prepareStatement("SELECT Vendedores.*,Departamentos.Setores as DepSetores "
					+ "FROM Vendedores INNER JOIN Departamentos " + "ON Vendedores.DepartamentosId = Departamentos.Id "
					+ "WHERE Vendedores.Id = ? ");

			ps.setInt(1, id);

			rs = ps.executeQuery();

			if (rs.next()) {

				Departamentos departamentos = new Departamentos();
				departamentos.setId(rs.getInt("DepartamentosId"));
				departamentos.setSetores(rs.getString("DepSetores"));

				Vendedores vendedores = new Vendedores();
				vendedores.setId(rs.getInt("id"));
				vendedores.setNome(rs.getString("Nome"));
				vendedores.setEmail(rs.getString("Email"));
				vendedores.setNascimento(rs.getDate("Nascimento"));
				vendedores.setSalario(rs.getDouble("Salario"));
				vendedores.setDepartamentos(departamentos);
				return vendedores;
			}
			return null;
		} catch (SQLException e) {
			throw new ExcecaoBancoDados(e.getMessage());
		} finally {
			ConexaoBancoDados.fecharStatement(ps);
			ConexaoBancoDados.fecharConexaoResultSet(rs);
		}
	}

	@Override
	public List<Vendedores> buscarTodos() {
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = conexao.prepareStatement("SELECT Vendedores.*,Departamentos.Setores as DepSetores "
					+ "FROM Vendedores INNER JOIN Departamentos "
					+ "ON Vendedores.DepartamentosId = Departamentos.Id ");
			rs = ps.executeQuery();

			List<Vendedores> lista = new ArrayList<>();
			
			while (rs.next()) {
				Departamentos departamentos = new Departamentos();
				departamentos.setId(rs.getInt("DepartamentosId"));
				departamentos.setSetores(rs.getString("DepSetores"));

				Vendedores vendedores = new Vendedores();
				vendedores.setId(rs.getInt("id"));
				vendedores.setNome(rs.getString("Nome"));
				vendedores.setEmail(rs.getString("Email"));
				vendedores.setNascimento(rs.getDate("Nascimento"));
				vendedores.setSalario(rs.getDouble("Salario"));
				vendedores.setDepartamentos(departamentos);
				lista.add(vendedores);
			}
			
			return lista;
		
		} catch (SQLException e) {
			throw new ExcecaoBancoDados(e.getMessage());
		} finally {
			ConexaoBancoDados.fecharStatement(ps);
			ConexaoBancoDados.fecharConexaoResultSet(rs);
		}
	}

	public List<Vendedores> buscarPorIdDepartamento(Departamentos departamentos) {
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = conexao.prepareStatement("SELECT Vendedores.*,Departamentos.Setores as DepSetores "
					+ "FROM Vendedores INNER JOIN Departamentos " + "ON Vendedores.DepartamentosId = Departamentos.Id "
					+ "WHERE DepartamentosId = ? " + "ORDER BY Nome ");

			ps.setInt(1, departamentos.getId());

			rs = ps.executeQuery();

			List<Vendedores> lista = new ArrayList<>();
			Map<Integer, Departamentos> map = new HashMap<>();

			while (rs.next()) {

				Departamentos dep = map.get(rs.getInt("DepartamentosId"));

				if (dep == null) {
					dep = instanciarDepartamento(rs);
					map.put(rs.getInt("DepartamentosId"), dep);
				}

				Vendedores vendedores = instanciarVendedores(rs, dep);
				lista.add(vendedores);
			}
			
			return lista;
		} 
		
		catch (SQLException e) {
			
			throw new ExcecaoBancoDados(e.getMessage());
		} 
		
		finally {
			ConexaoBancoDados.fecharStatement(ps);
			ConexaoBancoDados.fecharConexaoResultSet(rs);
		}
	}

	private Departamentos instanciarDepartamento(ResultSet rs) throws SQLException {
		Departamentos dep = new Departamentos();
		dep.setId(rs.getInt("DepartamentosId"));
		dep.setSetores(rs.getString("DepSetores"));
		
		return dep;
	}

	private Vendedores instanciarVendedores(ResultSet rs, Departamentos dep) throws SQLException {

		Vendedores vendedores = new Vendedores();
		vendedores.setId(rs.getInt("id"));
		vendedores.setNome(rs.getString("Nome"));
		vendedores.setEmail(rs.getString("Email"));
		vendedores.setNascimento(rs.getDate("Nascimento"));
		vendedores.setSalario(rs.getDouble("Salario"));
		vendedores.setDepartamentos(dep);
		return vendedores;
	}
}
