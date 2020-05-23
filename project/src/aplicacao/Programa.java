package aplicacao;

import java.util.List;

import dao.DaoFactory;
import dao.UsuarioDao;
import model.Usuario;

public class Programa {

	public static void main(String[] args) {
		
		UsuarioDao usuarioDao = DaoFactory.createUsuarioDao();
		
		/*
		 * Inserir usuário no Banco de Dados
		 *
		Usuario novoUsuario = new Usuario("Tomas", "3324324", 18, "Shelby@example.com");
		usuarioDao.inserir(novoUsuario);
		System.out.println("Inserido! Id do novo cadastro = " + novoUsuario.getId());
		*/
		
		
		/*
		 * Atualizar usuário
		 * 
		Usuario usuario = usuarioDao.encontrarPorId(1);
		usuario.setNome("Shelby");
		usuarioDao.atualizar(usuario);
		System.out.println("Atualizado com sucesso!");
		*/
		
		
		/*
		 * Deletar o usuario no Banco de Dados
		 * 
		usuarioDao.deletarPorId(2);
		System.out.println("Deletado com sucesso!");
		*/
		
		
		/*
		 * Encontrar por id do usuario
		 * 
		Usuario seller = usuarioDao.encontrarPorId(1);
		System.out.println(seller);
		*/
		
		/*
		 * Consulta todos usuario
		 * 
		List<Usuario> lista = usuarioDao.todosUsuarios();
		for (Usuario obj : lista) {
			System.out.println(obj);
		}
		*/
	}
}
