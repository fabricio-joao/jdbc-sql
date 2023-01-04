package cursojdbc.conexaobancosdedados.dao;

import cursojdbc.conexaobancosdedados.ConexaoBancoDados;
import cursojdbc.conexaobancosdedados.dao.impl.DepartamentosDaoJDBC;

public class FabricaDao {
	
	public static DepartamentosDao criarDepartametos() {
	return	new DepartamentosDaoJDBC(ConexaoBancoDados.retornaConexao());
	}

}
