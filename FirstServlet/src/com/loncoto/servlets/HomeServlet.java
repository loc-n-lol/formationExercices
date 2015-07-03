package com.loncoto.servlets;

import java.io.*;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HomeServlet
 */
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        System.out.println("Construction de la servlet home");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		System.out.println("appel de la méthode get de home");
		
		response.setContentType("text/html");
		
		PrintWriter pw = response.getWriter();
		pw.println("<html><head><title>bonjour!</title></head>");
		pw.println("<body><h2>Bonjour nous sommes le " + new Date() + "</h2></body></html>");
		
		pw.close();
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("appel de la méthode post de home");
		
		//getParameter est en provenace des formu
		String nom = request.getParameter("nom");
		String mdp = request.getParameter("mdp");
		
		System.out.println("J'ai reçu le login = "+nom+" avec le mdp = "+mdp);
		
		if (mdp.length() < 4) //MDP trop court
		{
			//configuration
			getServletContext().
				//object qui permet de passer le controle à cete page
				getRequestDispatcher("/erreur.jsp").
					//envoyer
					forward(request, response);
		}
		else
		{
			String message = "Bienvenue " + nom;
			
			//Les attributs permettent de communiquer entre servlet et jsp
			//on peut ici mettre un objet quelconque, contrairement au parameter
			//c'est strictement interne au serveur
			request.setAttribute("message", message);
			
			getServletContext().getRequestDispatcher("/bienvenue.jsp").forward(request, response);
		}
		
	}

}
