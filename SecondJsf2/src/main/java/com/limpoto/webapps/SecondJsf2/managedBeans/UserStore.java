package com.limpoto.webapps.SecondJsf2.managedBeans;

import java.util.HashMap;
import java.util.Map;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name="userStore")
@ApplicationScoped
public class UserStore {

	private Map<String, String> users;
	
	public UserStore() {
		System.out.println("construction de UserStore");
		users = new HashMap<String, String>();
		users.put("vincent", "123654");
		users.put("thierry", "azerty");
		users.put("franck", "javaforever");
	}
	
	public boolean verifyLogin(String login, String password)
	{
		return users.containsKey(login) && password.equals(users.get(login));
	}
	
}
