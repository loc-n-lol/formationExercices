package com.loncoto.webfirstjdbc.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.loncoto.webfirstjdbc.beans.Client;
import com.loncoto.webfirstjdbc.utils.ClientDAO;

/**
 * Servlet implementation class ClientServlet
 */
public class ClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ClientDAO clientDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		clientDAO = (ClientDAO)(getServletContext().getAttribute("clientDAO"));
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Client> clients = clientDAO.findAll();
		request.setAttribute("clients", clients);
		
		getServletContext().getRequestDispatcher("/list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		

		switch (action)
		{
			case "editer": 
			{
				int id = Integer.parseInt(request.getParameter("id"));
				Client c = clientDAO.findById(id);
				request.setAttribute("client", c);
	
				getServletContext().getRequestDispatcher("/edit.jsp").forward(
						request, response);
			}
			break;
	
			case "sauver": 
			{
				int id = Integer.parseInt(request.getParameter("id"));
				String nom = request.getParameter("nom");
				String email = request.getParameter("email");
				double solde = Double.parseDouble(request.getParameter("solde"));
	
				Client c = new Client(id, nom, email, solde);
				
				clientDAO.save(c);
				
				response.sendRedirect("ClientServlet");
			}
			break;
			
			case "creer":
			{
				Client c = new Client ();
				
				request.setAttribute("client", c);
				
				getServletContext().getRequestDispatcher("/edit.jsp").forward(
						request, response);
			}
			break;
	
			case "supprimer": 
			{
				int id = Integer.parseInt(request.getParameter("id"));
				
				clientDAO.delete(id);
				
				response.sendRedirect("ClientServlet");
			}
			break;

		}
	}

}
