package cursojdbc.conexaobancosdedados.app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cursojdbc.conexaobancosdedados.ConexaoBancoDados;
import cursojdbc.conexaobancosdedados.ExcecaoBancoDados;

public class Programa {

	public static void main(String[] args) throws SQLException {

		Connection conexao = null;
		PreparedStatement ps = null;

		try {
			conexao = ConexaoBancoDados.retornaConexao();
			
			ps = conexao.prepareStatement(
					"insert into Departamentos"
				  + "(Id, Setores) " 
			      + "values "
			      + "(?, ?)");
			ps.setInt(1, 2);
			ps.setString(2, "Eletronicos");
			
			int linha = ps.executeUpdate();
			System.out.println("Executado! Total de linhas alteradas: " + linha);
		
		} catch (SQLException e) {
			throw new ExcecaoBancoDados(e.getMessage());
		} finally {
			ConexaoBancoDados.fecharStatement(ps);
			ConexaoBancoDados.fecharConexao();
		}
	}
}
