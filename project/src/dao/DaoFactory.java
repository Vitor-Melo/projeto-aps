package dao;

import bd.BD;
import implementacao.RelatorioDaoJDBC;
import implementacao.UsuarioDaoJDBC;

public class DaoFactory {
	
	public static UsuarioDao createUsuarioDao() {
		return new UsuarioDaoJDBC(BD.getConnection());
	}

	public static RelatorioDao createRelatorioDao() {
		return new RelatorioDaoJDBC(BD.getConnection());
	}

}
