package db;

import java.sql.*;

import javax.servlet.*;


public class DBManager implements ServletContextListener {

	private  Connection base;
	
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {

		try {
			base.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		
		System.out.println("Démarrage de "+this.getClass().getSimpleName());
        
        String driverclass = arg0.getServletContext().getInitParameter("driverclass");
        String databaseurl = arg0.getServletContext().getInitParameter("databaseurl");
        String login = arg0.getServletContext().getInitParameter("login");
        String password = arg0.getServletContext().getInitParameter("password");
        
        //Chargement du driver sql
        
        try {
			Class.forName(driverclass);
			base = DriverManager.getConnection(databaseurl, login, password);
			
			System.out.println("Connecté à la base");
			
			//Creation du client DAO
			ArticleDAO articleDAO = new ArticleDAO(base);
			
			//Mise à disposition du DAO pour les servlets
			arg0.getServletContext().setAttribute("articleDAO", articleDAO);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
