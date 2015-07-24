package com.limpoto.webapps.StrutsFormationFormulaires.actions;

import com.limpoto.webapps.StrutsFormationFormulaires.beans.Article;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ArticleAction extends ActionSupport implements ModelDriven<Article>
{

	private Article model;
	
	@Override
	public Article getModel() {
		
		if (model == null)
			model = new Article();
		
		return model;
	}
	
	public String edit()
	{
		getModel().setId(1);
		getModel().setLibelle("chaise longue");
		getModel().setPoids(45.5);
		getModel().setPrix(15.5);
		return SUCCESS;
	}

}
