package dao;

import java.util.List;

import model.Relatorio;
import model.Usuario;

public interface UsuarioDao {

	void inserir(Usuario obj);
	void atualizar(Usuario obj);
	void deletarPorId(Integer id);
	Usuario encontrarPorId(Integer id);
	List<Usuario> todosUsuarios();
	List<Relatorio> todosRelatorios(Relatorio relatorio);
}
