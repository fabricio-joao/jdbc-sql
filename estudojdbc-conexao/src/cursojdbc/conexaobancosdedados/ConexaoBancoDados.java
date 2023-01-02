package cursojdbc.conexaobancosdedados;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ConexaoBancoDados {

	private static Connection conexao = null;

	public static Connection retornaConexao() {
		if (conexao == null) {
			try {
				Properties properties = retornoDadosConexao();
				String url = properties.getProperty("dburl");
				conexao = DriverManager.getConnection(url, properties);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return conexao;
	}

	//fecha conexao
	public static void fecharConexao() {
		if (conexao != null) {
			try {
				conexao.close();
			} catch (SQLException e) {
				throw new ExcecaoBancoDados(e.getMessage());
			}
		}
	}

	//fecha Statement
	public static void fecharStatement(Statement st) {
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				throw new ExcecaoBancoDados(e.getMessage());
			}
		}
	}

	//fecha ResultSet
	public static void fecharConexaoResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				throw new ExcecaoBancoDados(e.getMessage());
			}
		}
	}

	private static Properties retornoDadosConexao() {
		try (FileInputStream fs = new FileInputStream("bancodados.propriedades")) {
			Properties props = new Properties();
			props.load(fs);
			return props;
		} catch (IOException e) {
			throw new ExcecaoBancoDados(e.getMessage());
		}
	}
}
