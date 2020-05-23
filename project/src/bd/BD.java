package bd;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class BD {
	
private static Connection conn = null;
	
	public static Connection getConnection() {
		/*
		 * Respons�vel por fazer a conex�o com o banco de dados
		 */
		
		if (conn == null) {
			try {
				Properties props = loadProperties();
				String url = props.getProperty("dburl");
				conn = DriverManager.getConnection(url, props);
			}
			catch (SQLException e) {
				throw new BdException(e.getMessage());
			}
		}
		return conn;
	}
	
	public static void closeConnection() {
		/*
		 * Respons�vel por fechar a conex�o com o Banco de dados.
		 * 
		 */
		
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new BdException(e.getMessage());
			}
		}
	}
	
	private static Properties loadProperties() {
		/*
		 * Respons�vel por capturar as propriedades do banco de dados.
		 * 
		 */
		
		try (FileInputStream fs = new FileInputStream("db.properties")) {
			Properties props = new Properties();
			props.load(fs);
			return props;
		}
		catch (IOException e) {
			throw new BdException(e.getMessage());
		}
	}
	
	public static void closeStatement(Statement st) {
		/*
		 * Fechar a declara��o Statement
		 */
		
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				throw new BdException(e.getMessage());
			}
		}
	}

	public static void closeResultSet(ResultSet rs) {
		/*
		 * Fechar a declara��o ResultSet
		 */
		
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				throw new BdException(e.getMessage());
			}
		}
	}
}

