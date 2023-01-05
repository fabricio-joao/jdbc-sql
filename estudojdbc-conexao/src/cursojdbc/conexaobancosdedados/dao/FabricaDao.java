package cursojdbc.conexaobancosdedados.dao;

import cursojdbc.conexaobancosdedados.ConexaoBancoDados;
import cursojdbc.conexaobancosdedados.dao.impl.DepartamentosDaoJDBC;
import cursojdbc.conexaobancosdedados.dao.impl.VendedoresDaoJDBC;

public class FabricaDao {
	
	public static DepartamentosDao criarDepartametos() {
	return	new DepartamentosDaoJDBC(ConexaoBancoDados.retornaConexao());
	}

	public static VendedoresDao criarVendedores() {
		return new VendedoresDaoJDBC(ConexaoBancoDados.retornaConexao());
	}
}
