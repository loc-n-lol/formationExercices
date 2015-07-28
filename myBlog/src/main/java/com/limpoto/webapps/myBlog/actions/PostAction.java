package com.limpoto.webapps.myBlog.actions;

import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.struts2.util.ServletContextAware;

import com.limpoto.webapps.myBlog.beans.*;
import com.limpoto.webapps.myBlog.util.*;
import com.opensymphony.xwork2.ActionSupport;

public class PostAction extends ActionSupport implements ServletContextAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private PostDAO postDAO; 
	private List<Post> posts;

	private Post post;

	private int id;
	private String titre;
	private String corps;
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
//		GET/SET	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getCorps() {
		return corps;
	}

	public void setCorps(String corps) {
		this.corps = corps;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	
	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}	
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
//		ACTIONS
/////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	public String lister() 
	{
		System.out.println("lister()");
		
		posts = postDAO.findAll();
		
		return SUCCESS;
	}

	public String editer()
	{
		System.out.println("editer()");
		
		post = postDAO.findByID(getId());
		
		if (post == null)
		{
			return "notfound";
		}
		
		setTitre(post.getTitre());
		setCorps(post.getCorps());
		
		return SUCCESS;
	}
	
	public String creer()
	{
		System.out.println("creer()");
		
		setId(0);
		setTitre("");
		setCorps("");
		
		
		return SUCCESS;
	}
	
	public String sauver()
	{
		System.out.println("sauver()");
		
		post = new Post(getId(), getTitre(), getCorps(), null);
		
		postDAO.save(post);
		
		return SUCCESS;
	}	

	@Override
	public void setServletContext(ServletContext context) {
		postDAO = (PostDAO) context.getAttribute("postDAO");
		
		if (postDAO == null)
			System.out.println("postDAO == null");
	}

}
