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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(Departamentos obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletarPorId(Departamentos obj) {
		// TODO Auto-generated method stub
		
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
			ConexaoBancoDados.fecharConexao();
		}
}
}
