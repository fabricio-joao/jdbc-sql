package cursojdbc.conexaobancosdedados.app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import cursojdbc.conexaobancosdedados.ConexaoBancoDados;

public class Programa {

	public static void main(String[] args) throws SQLException {
	
		Connection conexao = ConexaoBancoDados.retornaConexao();
		ConexaoBancoDados.fecharConexao();
	}
}
