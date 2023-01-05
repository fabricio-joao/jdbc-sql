package cursojdbc.conexaobancosdedados.dao;

import java.util.List;

import cursojdbc.conexaobancosdedados.entidades.Departamentos;
import cursojdbc.conexaobancosdedados.entidades.Vendedores;

public interface VendedoresDao {

	void inserir(Vendedores obj);
	void atualizar(Vendedores obj);
	void deletar(Vendedores obj);
	Vendedores buscarPorId(Integer id);
    List<Vendedores> buscarTodos();
    List<Vendedores> buscarPorIdDepartamento(Departamentos departamentos);
}
