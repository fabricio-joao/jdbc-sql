package cursojdbc.conexaobancosdedados.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cursojdbc.conexaobancosdedados.ConexaoBancoDados;
import cursojdbc.conexaobancosdedados.ExcecaoBancoDados;
import cursojdbc.conexaobancosdedados.dao.DepartamentosDao;
import cursojdbc.conexaobancosdedados.entidades.Departamentos;

public class DepartamentosDaoJDBC implements DepartamentosDao{

	private Connection conexao;

	public DepartamentosDaoJDBC(Connection conexao) {
		this.conexao = conexao;
	}

	@Override
	public void inserir(Departamentos obj) {
		
		PreparedStatement ps = null;
		try {
			ps = conexao.prepareStatement(
					"insert into Departamentos "
					+ "(Id, Setores) "
				    +"values "
					+ "(?, ?) ");
			ps.setInt(1, obj.getId());
			ps.setString(2, obj.getSetores());
			
			int linha = ps.executeUpdate();
			System.out.println("Total de linhas alterada(s):  " + linha);
		}
		catch(SQLException e) {
			throw new ExcecaoBancoDados(e.getMessage());
		}
		finally {
			ConexaoBancoDados.fecharStatement(ps);
		}
		
	}

	@Override
	public void atualizar(Departamentos obj) {
		
		PreparedStatement ps = null;
		try {
			ps = conexao.prepareStatement(
					"update Departamentos "
				  + "set Id = ?, Setores = ?"
				  + "where Departamentos.Id = ?");
			ps.setInt(1,obj.getId());
			ps.setString(2, obj.getSetores());
			ps.setInt(3, 7);
		
			int linha = ps.executeUpdate();
			System.out.println("Total de linhas alterada(s):  " + linha);
			
		}
		catch(SQLException e) {
			throw new ExcecaoBancoDados(e.getMessage());
		}
		finally {
			ConexaoBancoDados.fecharStatement(ps);
		}
	}


	@Override
	public Departamentos buscarPorId(Integer id) {
	
		PreparedStatement ps= null;
		ResultSet rs = null;
		
		try {
			ps = conexao.prepareStatement(
					"select * from Departamentos "
					+ "WHERE Departamentos.Id = ?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			
			if(rs.next()) {
				Departamentos d = new Departamentos();
				d.setId(rs.getInt("Id"));
				d.setSetores(rs.getString("Setores"));
				return d;
			}
			return null;
		}
		catch(SQLException e) {
			throw new ExcecaoBancoDados(e.getMessage());
		}
		finally {
			ConexaoBancoDados.fecharStatement(ps);
			ConexaoBancoDados.fecharConexaoResultSet(rs);
		}
	}

	@Override
	public List<Departamentos> buscarTodos() {
	
		PreparedStatement ps= null;
		ResultSet rs = null;
		
		try {
			ps = conexao.prepareStatement("select * from Departamentos ");
			
			rs = ps.executeQuery();
			
			List<Departamentos> lista = new ArrayList<>();
			while(rs.next()) {
				Departamentos d = new Departamentos();
				d.setId(rs.getInt("Id"));
				d.setSetores(rs.getString("Setores"));
				lista.add(d);
			}
			return lista;
		}
		catch(SQLException e) {
			throw new ExcecaoBancoDados(e.getMessage());
		}
		finally {
			ConexaoBancoDados.fecharStatement(ps);
			ConexaoBancoDados.fecharConexaoResultSet(rs);
		}
}

	@Override
	public void deletar(Departamentos obj) {
	
		PreparedStatement ps = null;
		
		try {
			ps = conexao.prepareStatement(
					"delete from Departamentos "
				  + "where Setores = ?");
			ps.setString(1, obj.getSetores());
			
			int linha = ps.executeUpdate();
			System.out.println("Total de linhas alterada(s):  " + linha);
		}
		catch(SQLException e) {
			throw new ExcecaoBancoDados(e.getMessage());
		}
		finally {
			ConexaoBancoDados.fecharStatement(ps);
		    ConexaoBancoDados.fecharConexao();
		}
	}
}
