package cursojdbc.conexaobancosdedados.dao;

import java.util.List;

import cursojdbc.conexaobancosdedados.entidades.Departamentos;

public interface DepartamentosDao {

	void inserir(Departamentos obj);
	void atualizar(Departamentos obj);
	void deletar(Departamentos obj);
	Departamentos buscarPorId(Integer id);
    List<Departamentos> buscarTodos();
}
