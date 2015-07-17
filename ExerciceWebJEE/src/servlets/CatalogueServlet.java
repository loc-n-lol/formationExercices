package servlets;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

import beans.Article;
import db.ArticleDAO;

/**
 * Servlet implementation class CatalogueServlet
 */
public class CatalogueServlet extends HttpServlet {
	
	private ArticleDAO articleDAO;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		articleDAO = (ArticleDAO) getServletContext().getAttribute("articleDAO");
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		
		articleDAO = (ArticleDAO) getServletContext().getAttribute("articleDAO");
	}

	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CatalogueServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("articles", articleDAO.findAll());
		
		getServletContext().getRequestDispatcher("/liste.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		switch (request.getParameter("action"))
		{
			case "ajouter":
			{
				request.setAttribute("article", new Article());
				
				getServletContext().getRequestDispatcher("/modif.jsp").forward(request, response);
			}	
			break;
			
			case "supprimer":
			{
				int id = Integer.parseInt(request.getParameter("id"));
				
				articleDAO.delete(id);
				
				doGet(request, response);
			}
			break;
			
			case "modifier":
			{
				int id = Integer.parseInt(request.getParameter("id"));
				
				Article article = articleDAO.findByID(id);
				
				request.setAttribute("article", article);	
				
				getServletContext().getRequestDispatcher("/modif.jsp").forward(request, response);
			}
			break;
			
			case "enregistrer":
			{
				Article article = new Article(
						Integer.parseInt(request.getParameter("id")),
						request.getParameter("libelle"),
						Double.parseDouble(request.getParameter("prix")),
						Double.parseDouble(request.getParameter("poids"))
						);
				
				articleDAO.save(article);
				
				doGet(request, response);
			}
			break;			
			
		}
		
	}

}
