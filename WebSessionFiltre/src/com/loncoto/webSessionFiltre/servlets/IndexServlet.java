package com.loncoto.webSessionFiltre.servlets;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;


/**
 * Servlet implementation class IndexServlet
 */
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		int compteur = 0;
		
		if (session.getAttribute("compteur") == null)
		{
			System.out.println("creation du compteur dans la session par la servlet");
			compteur = 1;
		}
		else
		{
			System.out.println("incrémentation du compteur dans la session par la servlet");
			compteur = (int)session.getAttribute("compteur");
			compteur++;
		}
		
		session.setAttribute("compteur", compteur);
		
		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		switch (action)
		{
			case "reinitialiser":
			{
				request.getSession().invalidate();
				response.sendRedirect("IndexServlet");
			}
			break;
		}
	}

}
