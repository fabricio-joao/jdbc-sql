package cursojdbc.conexaobancosdedados.app;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import cursojdbc.conexaobancosdedados.ConexaoBancoDados;
import cursojdbc.conexaobancosdedados.ExcecaoBancoDados;

public class Programa {

	public static void main(String[] args) throws SQLException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Connection conexao = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			conexao = ConexaoBancoDados.retornaConexao();
			st = conexao.createStatement();
			rs = st.executeQuery("select * from Vendedores "
					+ "order by Nome");
			
			while(rs.next()) {
				System.out.println(rs.getInt("Id") + ", " + rs.getString("Nome") + ", " + rs.getString("Email") + ", " + rs.getDate("Nascimento") + ", R$" + rs.getDouble("Salario") + ", " + rs.getInt("DepartamentosId"));
			}
		} 
		
		catch (SQLException e) {
			throw new ExcecaoBancoDados(e.getMessage());
		}
		
		finally {
			ConexaoBancoDados.fecharStatement(st);
			ConexaoBancoDados.fecharConexaoResultSet(rs);
			ConexaoBancoDados.fecharConexao();
		}
	}
}
