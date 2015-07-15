package com.loncoto.webfirstjdbc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Application Lifecycle Listener implementation class DatabaseManager
 *
 */
public class DatabaseManager implements ServletContextListener {

	private  Connection base;
	
    /**
     * Default constructor. 
     */
    public DatabaseManager() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 

    	try {
			base.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
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
			ClientDAO clientDAO = new ClientDAO(base);
			
			//Mise à disposition du clientDAO pour les servlets
			arg0.getServletContext().setAttribute("clientDAO", clientDAO);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
    }
	
}
