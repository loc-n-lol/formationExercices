package com.loncoto.webfirstjdbc.utils;

import java.sql.*;
import java.util.*;

import com.loncoto.webfirstjdbc.beans.*;

//Data Access Object
public class ClientDAO {

	public static final String FIND_ALL_SQL = "SELECT * from `client`";
	private PreparedStatement findAllStatement;
	
	public static final String FIND_BY_ID_SQL = "SELECT * from `client` WHERE `id` = ?";
	private PreparedStatement findByIdStatement;
		
	public static final String UPDATE_ONE_SQL = "UPDATE `client` set `nom`=?, `email`=?, `solde`=? WHERE `id`=?";
	private PreparedStatement updateOneStatement;
	
	public static final String INSERT_ONE_SQL = "INSERT into `client` (`nom`, `email`, `solde`) VALUES (?,?,?)";
	private PreparedStatement insertOneStatement;
	
	public static final String DELETE_ONE_SQL = "DELETE from `client` WHERE `id` = ?";
	private PreparedStatement deleteOneStatement;
	
	
	private Connection base;
	
	public ClientDAO(Connection base)
	{
		this.base = base;
		
		try {
			findAllStatement = base.prepareStatement(FIND_ALL_SQL);
			findByIdStatement = base.prepareStatement(FIND_BY_ID_SQL);
			updateOneStatement = base.prepareStatement(UPDATE_ONE_SQL);
			insertOneStatement = base.prepareStatement(INSERT_ONE_SQL);
			deleteOneStatement = base.prepareStatement(DELETE_ONE_SQL);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Client> findAll() {
		
		ArrayList<Client> data = new ArrayList<Client>();
		
		try {
			findAllStatement.clearParameters();
			
			ResultSet rs = findAllStatement.executeQuery();
			
			while (rs.next())
			{
				data.add(new Client(rs.getInt("id"), rs.getString("nom"), rs.getString("email"), rs.getDouble("solde")));
			}
			
			rs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return data;
	}
	
	public Client findById(int id) {
		Client c = null;
		
		try {
			findByIdStatement.clearParameters();
			findByIdStatement.setInt(1, id);
			
			ResultSet rs = findByIdStatement.executeQuery();
			
			if (rs.next())
			{
				c = new Client(rs.getInt("id"), rs.getString("nom"), rs.getString("email"), rs.getDouble("solde"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return c;
	}

	
	
	public int save(Client client) {
		
		if (client.getId() > 0) // update
		{

			try {
				updateOneStatement.clearParameters();
				updateOneStatement.setString(1, client.getNom());
				updateOneStatement.setString(2, client.getEmail());
				updateOneStatement.setDouble(3, client.getSolde());
				updateOneStatement.setInt(4, client.getId());
				
				return updateOneStatement.executeUpdate();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			
		} 
		else // insert
		{
			try {
				insertOneStatement.clearParameters();
				insertOneStatement.setString(1, client.getNom());
				insertOneStatement.setString(2, client.getEmail());
				insertOneStatement.setDouble(3, client.getSolde());
				
				return insertOneStatement.executeUpdate();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
		}
		
		return 0;
	}
	
	public int delete(int id)
	{
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
	
	
	
}
