package com.loncoto.secondweb.servlets;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DessineServlet
 */
public class DessineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private String cssFilename;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DessineServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Enumeration<String> names = request.getParameterNames();
		while (names.hasMoreElements())
		{
			String name = names.nextElement();
			System.out.println(name + " -> " + request.getParameter(name));
		}
		
		String taille = request.getParameter("taille");
		
		int t = Integer.parseInt(taille);
		
		if (t<=0) {
			getServletContext().getRequestDispatcher("/erreurtaille.jsp").forward(request, response);
		}
		else
		{
			request.setAttribute("dimension", t);
			request.setAttribute("style", cssFilename);
			getServletContext().getRequestDispatcher("/triangle.jsp").forward(request, response);
		}
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		cssFilename = getServletConfig().getInitParameter("feuilleStyle");
	}

}
