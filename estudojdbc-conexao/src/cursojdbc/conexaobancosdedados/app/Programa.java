package cursojdbc.conexaobancosdedados.app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import cursojdbc.conexaobancosdedados.ConexaoBancoDados;
import cursojdbc.conexaobancosdedados.ExcecaoBancoDados;

public class Programa {

	public static void main(String[] args) throws SQLException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Connection conexao = null;
		PreparedStatement ps = null;

		try {
			conexao = ConexaoBancoDados.retornaConexao();
			
			ps = conexao.prepareStatement(
					"insert into Vendedores"
				  + "(Nome, Email, Nascimento, Salario, DepartamentosId ) " 
			      + "values "
			      + "(?, ?, ?, ?, ?)");
			
			ps.setString(1, "Maria");
			ps.setString(2, "maria@gmail.com");
			ps.setDate(3, new java.sql.Date(sdf.parse("08-10-1990").getTime()));
			ps.setDouble(4, 4000);
			ps.setInt(5, 4);
			
			int linha = ps.executeUpdate();
			System.out.println("Executado! Total de linhas alteradas: " + linha);
		
		} 
		catch (SQLException e) {
			throw new ExcecaoBancoDados(e.getMessage());
		}
		catch (ParseException e) {
			throw new ExcecaoBancoDados(e.getMessage());
		}
		finally {
			ConexaoBancoDados.fecharStatement(ps);
			ConexaoBancoDados.fecharConexao();
		}
	}
}
