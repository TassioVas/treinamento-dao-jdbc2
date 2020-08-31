package model.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
import db.DbException;
import model.dao.CidadeDao;
import model.entites.Cidade;
import model.entites.Estado;

public class CidadeDaoJDBC implements CidadeDao{
	
	private Connection conn;
	
	public CidadeDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Cidade obj) {
		PreparedStatement st =null;
		try{
			st = conn.prepareStatement(
						"INSERT INTO CIDADE " 
						+ "(ID, NOME, ID_ESTADO, DATE_CRIACAO) "
						+ "VALUES "
						+ "(?, ?, ?, ?)");
		   st.setInt(1, obj.getId());
		   st.setString(2, obj.getNome());
		   st.setInt(3, obj.getId_estado());
		   st.setDate(4, new java.sql.Date(obj.getDate_criacao().getTime()));
		   
		   int rowsAffected = st.executeUpdate();
		   if(rowsAffected > 0) {
			   ResultSet rs;
			   } 
		else {
			   throw new DbException("Erro:  nehuma linha alterada. sem inserçao");	
		}
		}	 
		catch (SQLException e) {
			   throw new DbException(e.getMessage());
		   }
		   finally {
			   DB.closeStatement(st);
			   
		   }
	}		   


	@Override
	public void update(Cidade obj) {
		PreparedStatement st =null;
		try{
			st = conn.prepareStatement(
					"UPDATE CIDADE "
					+ "SET  NOME = NOME "
					+ "+ '- BA' WHERE  = ?");
						
		   st.setInt(1, obj.getId());
		   st.setString(2, obj.getNome());
		   st.setInt(3, obj.getId_estado());
		   st.setDate(4, new java.sql.Date(obj.getDate_criacao().getTime()));
		   
          st.executeUpdate();
		}	 
		catch (SQLException e) {
			   throw new DbException(e.getMessage());
		   }
		   finally {
			   DB.closeStatement(st);
			   
		   }
		
	}

	@Override
	public void deleteById(Integer id) {

		
	}

	@Override
	public Cidade findBySigla(String sigla) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT CI.ID ,CI.NOME, ES.SIGLA, CI.ID_ESTADO "
					+ "FROM CIDADE CI INNER JOIN ESTADO ES " 
					+ "ON ci.id_estado = es.id "
					+ "WHERE SIGLA = ?"
					);
			st.setString(1, sigla);
			rs = st.executeQuery();
			if (rs.next()) {
				Estado est = instanciateEstado(rs);
				Cidade obj = instanciateCidade(rs, est);
				return obj; 
			}return null; 
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	private Cidade instanciateCidade(ResultSet rs, Estado est) throws SQLException {
	
		Cidade obj = new Cidade();
		obj.setId(rs.getInt("id"));
		obj.setNome(rs.getString("nome"));
		obj.setId_estado(rs.getInt("ID_ESTADO"));
		// obj.setDate_criacao(rs.getDate("date_criacao"));
		obj.setEstado(est);
		return obj;
	}

	private Estado instanciateEstado(ResultSet rs) throws SQLException {
		Estado est = new Estado();
		est.setId(rs.getInt("id"));
		est.setNome(rs.getString("nome"));
		return est;
	}

	@Override
	public List<Cidade> findSP(String sigla) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT CI.ID ,CI.NOME, ES.SIGLA, CI.ID_ESTADO "
							+ "FROM CIDADE CI INNER JOIN ESTADO ES " 
							+ "ON ci.id_estado = es.id "
							+ "WHERE SIGLA = ?"
							);
			st.setString(1, sigla);
			rs = st.executeQuery();
			
			List<Cidade> list = new ArrayList<>();
			Map<Integer, Estado> map = new HashMap<>();
			
			while (rs.next()) {
				
				Estado dep = map.get(rs.getInt("id_estado"));
				
				if (dep == null) {
					dep = instanciateEstado(rs);
					map.put(rs.getInt("id_estado"), dep);
				}
				
				Cidade obj = instanciateCidade(rs, dep);
				list.add(obj);
			}
			return list;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public List<Cidade> findByEstado(Estado estado) {
		
		return null;
	}

	@Override
	public List<Cidade> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cidade> findSPExists(String sigla) {
		// TODO Auto-generated method stub
		return null;
	}

	/*  @Override
	public List<Cidade> findSPExists(String sigla) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT CI.NOME FROM CIDADE CI " 
					+ "WHERE EXISTS "
					+ "( SELECT 1 FROM ESTADO ES " 
							+"WHERE ci.id_estado = es.id and "
							+"SIGLA = 'SP');"
							);
			
			rs = st.executeQuery();
			
			List<Cidade> list1 = new ArrayList<>();
			Map<Integer, Estado> map = new HashMap<>();
			
			while (rs.next()) {
				
				Estado dep = map.get(rs.getInt("id_estado"));
				
				if (dep == null) {
					dep = instanciateEstado(rs);
					map.put(rs.getInt("id_estado"), dep);
				}
				
				Cidade obj = instanciateCidade(rs, dep);
				list1.add(obj);
			}
			return list1;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs); 
		}*/
	
}
