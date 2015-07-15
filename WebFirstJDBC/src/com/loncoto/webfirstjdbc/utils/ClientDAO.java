package com.loncoto.webfirstjdbc.utils;

import java.sql.*;
import java.util.*;

import com.loncoto.webfirstjdbc.beans.*;

//Data Access Object
public class ClientDAO {

	public static final String FIND_ALL_SQL = "select * from `client`";
	private PreparedStatement findAllStatement;
	
	public static final String FIND_BY_ID_SQL = "select * from `client` WHERE `id` = ?";
	private PreparedStatement findByIdStatement;
	
	private Connection base;
	
	public ClientDAO(Connection base)
	{
		this.base = base;
		
		try {
			findAllStatement = base.prepareStatement(FIND_ALL_SQL);
			findByIdStatement = base.prepareStatement(FIND_BY_ID_SQL);
			
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
	
	
	
}
