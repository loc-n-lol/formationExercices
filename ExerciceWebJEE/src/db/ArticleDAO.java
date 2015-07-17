package db;

import java.sql.*;
import java.util.Vector;

import beans.Article;

public class ArticleDAO {

	public static final String FIND_ALL_SQL = "SELECT * from `articles`";
	private PreparedStatement findAllStatement;
	public static final int ORDER_BY_DEFAULT = 0;

	public static final String FIND_ALL_ORDERED_PRIX_SQL = "SELECT * from `articles` ORDER BY `prix`";
	private PreparedStatement findAllOrderedPrixStatement;
	public static final int ORDER_BY_PRIX = 1;
	
	public static final String FIND_ALL_ORDERED_POIDS_SQL = "SELECT * from `articles` ORDER BY `poids`";
	private PreparedStatement findAllOrderedPoidsStatement;
	public static final int ORDER_BY_POIDS = 2;
	
	public static final String FIND_BY_ID_SQL = "SELECT * from `articles` WHERE `id` = ?";
	private PreparedStatement findByIdStatement;
		
	public static final String UPDATE_ONE_SQL = "UPDATE `articles` set `libelle`=?, `prix`=?, `poids`=? WHERE `id`=?";
	private PreparedStatement updateOneStatement;
	
	public static final String INSERT_ONE_SQL = "INSERT into `articles` (`libelle`, `prix`, `poids`) VALUES (?,?,?)";
	private PreparedStatement insertOneStatement;
	
	public static final String DELETE_ONE_SQL = "DELETE from `articles` WHERE `id` = ?";
	private PreparedStatement deleteOneStatement;
	
	public ArticleDAO(Connection base) {
		try {
			findAllStatement 	= base.prepareStatement(FIND_ALL_SQL);
			findAllOrderedPrixStatement 	= base.prepareStatement(FIND_ALL_ORDERED_PRIX_SQL);
			findAllOrderedPoidsStatement 	= base.prepareStatement(FIND_ALL_ORDERED_POIDS_SQL);
			findByIdStatement 	= base.prepareStatement(FIND_BY_ID_SQL);
			updateOneStatement 	= base.prepareStatement(UPDATE_ONE_SQL);
			insertOneStatement 	= base.prepareStatement(INSERT_ONE_SQL);
			deleteOneStatement 	= base.prepareStatement(DELETE_ONE_SQL);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public Vector<Article> findAll() 
	{
		return findAll(ORDER_BY_DEFAULT);
	}
	
	public Vector<Article> findAll(int order) 
	{
		
		Vector<Article> vec = new Vector<Article>();
		ResultSet rs;
		
		try {
	
			PreparedStatement statement = null;

			switch(order)
			{
				default:
				case ORDER_BY_DEFAULT:
					findAllStatement.clearParameters();
					statement = findAllStatement; 
					break;
					
				case ORDER_BY_POIDS:
					findAllOrderedPoidsStatement.clearParameters();
					statement = findAllOrderedPoidsStatement; 
					break;
					
				case ORDER_BY_PRIX:
					findAllOrderedPrixStatement.clearParameters();
					statement = findAllOrderedPrixStatement; 	
					break;
			
			}
			
			
			rs = statement.executeQuery();

			while (rs.next()) {
				
				vec.add(
						new Article(
								rs.getInt("id"), 
								rs.getString("libelle"),
								rs.getDouble("prix"), 
								rs.getDouble("poids")
								)
						);

			}
			
			return vec;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}

		return null;
	}
	

	public Article findByID(int id) 
	{
		try {
			findByIdStatement.clearParameters();
			
			findByIdStatement.setInt(1, id);
			
			ResultSet rs = findByIdStatement.executeQuery();
			
			if (rs.next())
			{
				return 	new Article(
								id, 
								rs.getString("libelle"),
								rs.getDouble("prix"), 
								rs.getDouble("poids")
								);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	public int save(Article article) 
	{
		
		try {
			
			if (article.getId() == 0)
			{
				
				insertOneStatement.clearParameters();
				
				insertOneStatement.setString(1, article.getLibelle());
				insertOneStatement.setDouble(2, article.getPrix());
				insertOneStatement.setDouble(3, article.getPoids());
				
				return insertOneStatement.executeUpdate();
			}
			else
			{
				updateOneStatement.clearParameters();
				
				updateOneStatement.setString(1, article.getLibelle());
				updateOneStatement.setDouble(2, article.getPrix());
				updateOneStatement.setDouble(3, article.getPoids());
				
				updateOneStatement.setInt(4, article.getId());
				
				return updateOneStatement.executeUpdate();
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
