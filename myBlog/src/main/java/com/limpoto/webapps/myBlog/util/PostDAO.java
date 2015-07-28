package com.limpoto.webapps.myBlog.util;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.limpoto.webapps.myBlog.beans.Post;

public class PostDAO {

	private Connection base;

	public static final String FIND_ALL_SQL = "select * from `posts`";
	public static final String FIND_BY_ID_SQL = "select * from `posts` where `id`=?";
	public static final String UPDATE_ONE_SQL = "update `posts` set `titre`=?, `corps`=? where `id`=?";
	public static final String INSERT_ONE_SQL = "insert into `posts` (`titre`, `corps`, `date_creation`) values (?,?,?)";
	public static final String DELETE_ONE_SQL = "delete from `posts` where `id`=?";

	private PreparedStatement findAllStatement;
	private PreparedStatement findByIDStatement;
	private PreparedStatement updateOneStatement;
	private PreparedStatement insertOneStatement;
	private PreparedStatement deleteOneStatement;
	
	public PostDAO(Connection base) {
		this.base = base;
		
		try {
			findAllStatement = base.prepareStatement(FIND_ALL_SQL);
			findByIDStatement = base.prepareStatement(FIND_BY_ID_SQL);
			updateOneStatement = base.prepareStatement(UPDATE_ONE_SQL);
			insertOneStatement = base.prepareStatement(INSERT_ONE_SQL);
			deleteOneStatement = base.prepareStatement(DELETE_ONE_SQL);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	

	public int delete(int id) {
		try {
			deleteOneStatement.clearParameters();
			deleteOneStatement.setInt(1, id);
			return deleteOneStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	
	
	
	public int save(Post p) {
		if (p.getId() > 0) {
			// c'est un update
			try {
				updateOneStatement.clearParameters();
				updateOneStatement.setString(1, p.getTitre());
				updateOneStatement.setString(2, p.getCorps());
				//updateOneStatement.setDate(3, new java.sql.Date(p.getDateCreation().getTime()));
				updateOneStatement.setInt(3, p.getId());
				return updateOneStatement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			// c'est une insert
			try {
				insertOneStatement.clearParameters();
				insertOneStatement.setString(1, p.getTitre());
				insertOneStatement.setString(2, p.getCorps());				
				java.util.Date d =  new java.util.Date();
				insertOneStatement.setDate(3, new java.sql.Date(d.getTime()));
				return insertOneStatement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	
	
	public Post findByID(int id) {
		Post p = null;
		try {
			findByIDStatement.clearParameters();
			// je remplace le premier point d'interogation par l'id que j'ai en parametre
			findByIDStatement.setInt(1, id);
			
			ResultSet rs = findByIDStatement.executeQuery();
			if (rs.next()) {
				p = new Post(rs.getInt("id"),
						rs.getString("titre"),
						rs.getString("corps"),
						rs.getDate("date_creation"));
			}
			rs.close();
		} catch (SQLException e) {	e.printStackTrace();}
		return p;
	}
	
	
	
	public List<Post> findAll() {
		ArrayList<Post> data = new ArrayList<Post>();
		ResultSet rs = null;
		try {
			// je nettoie les parametres pr�c�dents
			findAllStatement.clearParameters();
			// j'execute la requette
			rs = findAllStatement.executeQuery();
			while (rs.next()) {
				data.add(new Post(rs.getInt("id"),
									rs.getString("titre"),
									rs.getString("Corps"),
									rs.getDate("date_creation")));
			}
		} catch (SQLException e) {e.printStackTrace();}
		finally {
			// nous avons finit, nous fermons le resultset
			if (rs != null)
				try {rs.close();} catch (SQLException e) {e.printStackTrace();}
		}
		// on renvoie la liste des clients
		return data;
	}
		
	
	
}
