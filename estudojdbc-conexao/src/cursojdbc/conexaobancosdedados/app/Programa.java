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
					"delete from Vendedores "
				  //+ "set Nome = ?, Email = ?, Nascimento = ?, Salario = ?, DepartamentosId = ? " 
			      + "where "
			      + "Nome = ?");
			
			ps.setString(1, "Dilma");
			/*ps.setString(2, "joana@gmail.com");
			ps.setDate(3, new java.sql.Date(sdf.parse("20-11-2012").getTime()));
			ps.setDouble(4, 3000);
			ps.setInt(5, 3);
			ps.setInt(6, 3);*/
			
			int linha = ps.executeUpdate();
			System.out.println("Executado! Total de linhas alteradas: " + linha);
			
		} 
		
		catch (SQLException e) {
			throw new ExcecaoBancoDados(e.getMessage());
		}
		
		/*catch (ParseException e) {
			throw new ExcecaoBancoDados(e.getMessage());
		}*/
		
		finally {
			ConexaoBancoDados.fecharStatement(ps);
			ConexaoBancoDados.fecharConexao();
		}
	}
}
