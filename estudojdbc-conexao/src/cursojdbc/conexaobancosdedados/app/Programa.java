package cursojdbc.conexaobancosdedados.app;

import java.sql.SQLException;
import java.util.List;

import cursojdbc.conexaobancosdedados.dao.DepartamentosDao;
import cursojdbc.conexaobancosdedados.dao.FabricaDao;
import cursojdbc.conexaobancosdedados.entidades.Departamentos;

public class Programa {

	public static void main(String[] args) throws SQLException {

	//Buscar Dep por id;
	System.out.println("#### Buscar departamentos por id #### ");
	DepartamentosDao deoBuscarPorId = FabricaDao.criarDepartametos();
    Departamentos dep = deoBuscarPorId.buscarPorId(2);
    System.out.print("Id: " + dep.getId() + " - " + "Setor: " + dep.getSetores());
    
    System.out.println();
    
    System.out.println("\n#### Buscar todos Departamentos #### ");
	DepartamentosDao deoBuscaTodos = FabricaDao.criarDepartametos();
    List<Departamentos> obj = deoBuscaTodos.buscarTodos();
    for(Departamentos x: obj) {
    	 System.out.println("Id: " + x.getId() + " - " + "Setor: " + x.getSetores());
    }
    
    System.out.println();
    
    System.out.println("\n#### Inserir Departamentos #### ");
	DepartamentosDao inserirDep = FabricaDao.criarDepartametos();
    Departamentos departamentos = new Departamentos();
    departamentos.setId(5);
    departamentos.setSetores("Telefonia");
    inserirDep.inserir(departamentos);
	}
}
