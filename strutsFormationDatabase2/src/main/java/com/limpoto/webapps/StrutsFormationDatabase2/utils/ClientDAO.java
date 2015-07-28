package com.limpoto.webapps.StrutsFormationDatabase2.utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.limpoto.webapps.StrutsFormationDatabase2.beans.Client;

public class ClientDAO {
	public static final String FIND_ALL_SQL = "select * from `client`";
	public static final String FIND_BY_ID_SQL = "select * from `client` where `id`=?";
	public static final String UPDATE_ONE_SQL = "update `client` set `nom`=?, `email`=?, `solde`=? where `id`=?";
	public static final String INSERT_ONE_SQL = "insert into `client` (`nom`, `email`, `solde`) values (?,?,?)";
	public static final String DELETE_ONE_SQL = "delete from `client` where `id`=?";
	
	private PreparedStatement findAllStatement;
	private PreparedStatement findByIDStatement;
	private PreparedStatement updateOneStatement;
	private PreparedStatement insertOneStatement;
	private PreparedStatement deleteOneStatement;
	
	private Connection base;
	
	public ClientDAO(Connection base) {
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
	
	
	
	
	public int save(Client c) {
		if (c.getId() > 0) {
			// c'est un update
			try {
				updateOneStatement.clearParameters();
				updateOneStatement.setString(1, c.getNom());
				updateOneStatement.setString(2, c.getEmail());
				updateOneStatement.setDouble(3, c.getSolde());
				updateOneStatement.setInt(4, c.getId());
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
				insertOneStatement.setString(1, c.getNom());
				insertOneStatement.setString(2, c.getEmail());
				insertOneStatement.setDouble(3, c.getSolde());
				return insertOneStatement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	
	
	public Client findByID(int id) {
		Client c = null;
		try {
			findByIDStatement.clearParameters();
			// je remplace le premier point d'interogation par l'id que j'ai en parametre
			findByIDStatement.setInt(1, id);
			
			ResultSet rs = findByIDStatement.executeQuery();
			if (rs.next()) {
				c = new Client(rs.getInt("id"),
						rs.getString("nom"),
						rs.getString("email"),
						rs.getDouble("solde"));
			}
			rs.close();
		} catch (SQLException e) {	e.printStackTrace();}
		return c;
	}
	
	
	
	public List<Client> findAll() {
		ArrayList<Client> data = new ArrayList<Client>();
		ResultSet rs = null;
		try {
			// je nettoie les parametres pr�c�dents
			findAllStatement.clearParameters();
			// j'execute la requette
			rs = findAllStatement.executeQuery();
			while (rs.next()) {
				data.add(new Client(rs.getInt("id"),
									rs.getString("nom"),
									rs.getString("email"),
									rs.getDouble("solde")));
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
