package aplicacao;

import java.util.Date;
import java.util.List;

import dao.DaoFactory;
import dao.RelatorioDao;
import model.Relatorio;

public class Programa2 {

	public static void main(String[] args) {
		
		RelatorioDao relatorioDao = DaoFactory.createRelatorioDao();

		/*
		 * Inserir relatorio no Banco de Dados
		 * 
		Relatorio novoRelatorio = new Relatorio("Rua em algum lugar", "32414432", "vem com pai", "fadsjnfjkdsbbfk�dsffnsda�fd", 1, new Date());
		relatorioDao.inserir(novoRelatorio, 1);
		System.out.println("Inserido! Novo Id: " + novoRelatorio.getId());
		*/
		
		/*
		 * Atualizar relatorio no banco de dados
		 * 
		Relatorio relatorio = relatorioDao.encontrarPorId(1);
		System.out.println(relatorio);
		relatorio.setTitulo("Agora um titulo");
		relatorioDao.atualizar(relatorio);
		System.out.println("Atualizado com sucesso!");
		*/
		
		/*
		 * Deletar relatorio do Banco de dados
		 * 
		relatorioDao.deletarPorId(3);
		System.out.println("Deletado com sucesso!");
		*/
		
		List<Relatorio> lista = relatorioDao.todosRelatorios();
		for (Relatorio rel : lista) {
			System.out.println(rel);
		}
		
	}
}
