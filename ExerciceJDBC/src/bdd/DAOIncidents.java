package bdd;

import java.sql.*;
import java.util.ArrayList;

import donnees.Incident;

public class DAOIncidents {

	private static final String SQL_SELECT_ALL = "select * from `incident` ORDER BY `urgence` DESC";
	private static final String SQL_INSERT_INCIDENT = "INSERT into `incident` (`id`, `description`, `date`, `urgence`, `categorie`) VALUES (NULL, ?, ?, ?, ?)";
	private static final String SQL_UPDATE_INCIDENT = "UPDATE `incident` SET `description` = ?, `date` = ?, `urgence` = ?, `categorie` = ? WHERE `id` = ?";
	private static final String SQL_DELETE_INCIDENT = "DELETE FROM `incident` WHERE `id` = ?";

	
	private Connection base;
	
	public DAOIncidents() {
		// chargement/initialisation du driver MYSQL
		try {
			Class.forName("com.mysql.jdbc.Driver");			

			// Connection est l'interface décrivant un objet permettant de se connecter
			// a une base de donnée
			// le DriverManager renvoie un objet implémentant cette interface
			// qui est capable de gérer l'url qu'on lui a fournie
			base = DriverManager.getConnection("jdbc:mysql://localhost:3306/incidents",
							"root",
							"");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
/////////////////////////////////////////////////////////////////////////////////////////////////////////
	public ArrayList<Incident> getAllIncidents() {
		
		ArrayList<Incident> listRet = new ArrayList<Incident>();
		
		try {

		    //  je creer mon objet permettant de requetter la base
		    Statement request = base.createStatement();
		    
		    // execution d'une requette select
		    // elle nous renvoie un resultset qui nous permet
		    // de parcourir les lignes renvoyée
		    ResultSet rs = request.executeQuery(SQL_SELECT_ALL);
		    
		    // parcourir les lignes
		    while (rs.next()){
		    	// récupérer les colonnes qui nous intéressent
		    	// sur la ligne courante
		    	Incident i = new Incident(
		    			rs.getInt("id"),
		    			rs.getString("description"),
		    			rs.getDate("date"),
		    			rs.getInt("urgence"),
		    			rs.getString("categorie")		    			
		    			);
		    	
		    	listRet.add(i);
		    }
		    
		    // attention a bien libérer les ressources
		    rs.close();
		}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listRet;
		
	}
	
	
	


/////////////////////////////////////////////////////////////////////////////////////////////////////////	
	public int enregistrerIncident(Incident i)
	{
		
		try 
		{
		    //  je crée mon objet permettant de requetter la base
			PreparedStatement request = base.prepareStatement(SQL_INSERT_INCIDENT);

			request.setString	(1, i.getDescription());
			request.setDate		(2, new java.sql.Date(i.getDate().getTime()));
			request.setInt		(3, i.getUrgence());
			request.setString	(4, i.getCategorie());
			
			return request.executeUpdate();

		}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
			
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////	
	public int modifierIncident(Incident i)
	{

		try 
		{
			//  je crée mon objet permettant de requetter la base
			PreparedStatement request = base.prepareStatement(SQL_UPDATE_INCIDENT);
			
			request.setString	(1, i.getDescription());
			request.setDate		(2, new java.sql.Date(i.getDate().getTime()));
			request.setInt		(3, i.getUrgence());
			request.setString	(4, i.getCategorie());
			
			request.setInt		(5, i.getId());

			return request.executeUpdate();

		}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;

	}	
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////	
	public int effacerIncident(Incident i)
	{

		try 
		{
			//  je crée mon objet permettant de requetter la base
			PreparedStatement request = base.prepareStatement(SQL_DELETE_INCIDENT);

			request.setInt		(1, i.getId());

			return request.executeUpdate();

		}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;

	}		
	
	
}
