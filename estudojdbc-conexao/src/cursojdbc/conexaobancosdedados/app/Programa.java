package cursojdbc.conexaobancosdedados.app;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import cursojdbc.conexaobancosdedados.dao.DepartamentosDao;
import cursojdbc.conexaobancosdedados.dao.FabricaDao;
import cursojdbc.conexaobancosdedados.dao.VendedoresDao;
import cursojdbc.conexaobancosdedados.entidades.Departamentos;
import cursojdbc.conexaobancosdedados.entidades.Vendedores;

public class Programa {

	public static void main(String[] args) throws SQLException, ParseException {

	/*//Buscar Dep por id;
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
    
   /* System.out.println("\n#### Inserir Departamentos #### ");
	DepartamentosDao inserirDep = FabricaDao.criarDepartametos();
    Departamentos departamentos = new Departamentos();
    departamentos.setId(5);
    departamentos.setSetores("Telefonia");
    inserirDep.inserir(departamentos);
    
    System.out.println();
    
    System.out.println("\n#### Atualizar Departamentos #### ");
    DepartamentosDao atualizarDep = FabricaDao.criarDepartametos();
    Departamentos departamentos2 = new Departamentos(7, "Tabacaria");
    atualizarDep.atualizar(departamentos2);
    
   System.out.println();
    
    System.out.println("\n#### Deletar Departamentos #### ");
    DepartamentosDao deletarDep = FabricaDao.criarDepartametos();
    Departamentos departamentos3 = new Departamentos();
    departamentos3.setSetores("Perfumaria");
    deletarDep.deletar(departamentos3);
    
  //Buscar Dep por id;
  	System.out.println("#### Buscar vendedor por id #### ");
  	VendedoresDao deoBuscarPorId = FabricaDao.criarVendedores();
    Vendedores v = deoBuscarPorId.buscarPorId(12);
    System.out.println(v);
		
	System.out.println();
		    
	System.out.println("\n#### Buscar todos Vendedores #### ");
	VendedoresDao deoBuscaTodos = FabricaDao.criarVendedores();
	List<Vendedores> obj1 = deoBuscaTodos.buscarTodos();
	for(Vendedores x: obj1) {
	System.out.println(x);
	}
	
	System.out.println("#### Buscar vendedor por id #### ");
  	VendedoresDao daoVendedores = FabricaDao.criarVendedores();
    Departamentos departamentos2 = new Departamentos(1, null);
    List<Vendedores> vendedores = daoVendedores.buscarPorIdDepartamento(departamentos2);
	
    for(Vendedores x: vendedores) {
    	System.out.println(x);
    }
    
	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    System.out.println();
    System.out.println("\n#### Inserir Vendedores #### ");
    
    VendedoresDao vdao = FabricaDao.criarVendedores();
    
    Departamentos departamentos = new Departamentos();
    departamentos.setId(1);
    departamentos.setSetores("Compuiters");
    
    Vendedores vendedores = new Vendedores();
    vendedores.setNome("Vanilde Ferreira");
    vendedores.setEmail("vanilde@gmal.com");
    vendedores.setNascimento(new java.sql.Date(sdf.parse("23-12-2006").getTime()));
    vendedores.setSalario(1000.0);
    vendedores.setDepartamentos(departamentos);
    
    vdao.inserir(vendedores);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	    System.out.println();
	    System.out.println("\n#### Atualizar Vendedores #### ");
	    
	    VendedoresDao vdaoAtualizar = FabricaDao.criarVendedores();
	    
	    Departamentos departamentos = new Departamentos();
	    departamentos.setId(1);
	    departamentos.setSetores("Compuiters");
	    
	    Vendedores vendedores = new Vendedores();
	    vendedores.setNome("Sidnei Ferreira");
	    vendedores.setEmail("sidnei@gmal.com");
	    vendedores.setNascimento(new java.sql.Date(sdf.parse("20-12-2006").getTime()));
	    vendedores.setSalario(1000.0);
	    vendedores.setDepartamentos(departamentos);
	    vendedores.setId(3);
	    vdaoAtualizar.atualizar(vendedores);*/
		
		System.out.println();
	    System.out.println("\n#### Deleta Vendedores #### ");
	    
	    VendedoresDao vdaoDelete = FabricaDao.criarVendedores();
	    Vendedores vendedores = new Vendedores();
	    vendedores.setId(14);
	    vdaoDelete.deletar(vendedores);
  }
}
