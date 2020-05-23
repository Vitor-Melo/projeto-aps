package implementacao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bd.BD;
import bd.BdException;
import dao.RelatorioDao;
import model.Relatorio;

public class RelatorioDaoJDBC implements RelatorioDao {

	private Connection conn;

	public RelatorioDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void inserir(Relatorio obj, Integer id) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
				"INSERT INTO relatorio (titulo, endereco, cep, descricao, momento, usuarioId) "
				+ "VALUES (?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

			st.setString(1, obj.getTitulo());
			st.setString(2, obj.getEndereco());
			st.setString(3, obj.getCEP());
			st.setString(4, obj.getDescricao());
			st.setDate(5, new java.sql.Date(obj.getData().getTime()));
			st.setInt(6, id);

			int rowsAffected = st.executeUpdate();
			
			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int idrelatorio = rs.getInt(1);
					obj.setId(idrelatorio);
				}
			}
			else {
				throw new BdException("Erro inesperado! Zero linhas afetadas!");
			}
		}
		catch (SQLException e) {
			throw new BdException(e.getMessage());
		} 
		finally {
			BD.closeStatement(st);
		}
	}

	@Override
	public void atualizar(Relatorio obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
				"UPDATE relatorio SET endereco = ?, cep = ?, "
				+ "titulo = ?, descricao = ?, momento = ? " 
				+ "WHERE Id = ?");

			st.setString(1, obj.getEndereco());
			st.setString(2, obj.getCEP());
			st.setString(3, obj.getTitulo());
			st.setString(4, obj.getDescricao());
			st.setDate(5, new java.sql.Date(obj.getData().getTime()));
			st.setInt(6, obj.getId());
			

			st.executeUpdate();
		}
		catch (SQLException e) {
			throw new BdException(e.getMessage());
		} 
		finally {
			BD.closeStatement(st);
		}

	}

	@Override
	public void deletarPorId(Integer id) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("DELETE FROM relatorio WHERE id = ?");
			
			st.setInt(1, id);
			
			st.executeUpdate();
		}
		catch (SQLException e) {
			throw new BdException(e.getMessage());
		}
		finally {
			BD.closeStatement(st);
		}

	}

	@Override
	public Relatorio encontrarPorId(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
				"SELECT * FROM relatorio WHERE id = ?");
			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				Relatorio obj = new Relatorio();
				obj.setId(rs.getInt("id"));
				obj.setEndereco(rs.getString("endereco"));
				obj.setCEP(rs.getString("cep"));
				obj.setTitulo(rs.getString("titulo"));
				obj.setDescricao(rs.getString("descricao"));
				obj.setData(rs.getDate("momento"));
				return obj;
			}
			return null;
		}
		catch (SQLException e) {
			throw new BdException(e.getMessage());
		}
		finally {
			BD.closeStatement(st);
			BD.closeResultSet(rs);
		}
		
	}

	@Override
	public List<Relatorio> todosRelatorios() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
				"SELECT * FROM relatorio");
			rs = st.executeQuery();

			List<Relatorio> list = new ArrayList<>();

			while (rs.next()) {
				Relatorio obj = new Relatorio();
				obj.setId(rs.getInt("Id"));
				obj.setTitulo(rs.getString("titulo"));
				obj.setCEP(rs.getString("cep"));
				obj.setDescricao(rs.getString("descricao"));
				obj.setEndereco(rs.getString("endereco"));
				obj.setData(rs.getDate("momento"));
				
				list.add(obj);
			}
			return list;
		}
		catch (SQLException e) {
			throw new BdException(e.getMessage());
		}
		finally {
			BD.closeStatement(st);
			BD.closeResultSet(rs);
		}
	}
}
