package dao;

import java.util.List;

import model.Relatorio;

public interface RelatorioDao {
	
	void inserir(Relatorio obj, Integer id);
	void atualizar(Relatorio obj);
	void deletarPorId(Integer id);
	Relatorio encontrarPorId(Integer id);
	List<Relatorio> todosRelatorios();

}
