package com.limpoto.webapps.myBlog.util;

import java.lang.reflect.Method;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class DAOInterceptor implements Interceptor {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		ActionContext actx = invocation.getInvocationContext();
		
		//Je récupère une Map contenant tous les attributs du servletContext
		//càd, ce qui aura été initialisé par notre databasemanager
		Map<String, Object> webAppCtx = actx.getApplication();
		
		//Je récupère l'action qui sera appelée au final
		Object action = invocation.getAction();
		
		Class cls = action.getClass();
		Method[] methods = cls.getMethods();
		
		for (Method m : methods)
		{
			if (m.getName().startsWith("set") && m.getName().endsWith("DAO") && m.getParameterCount() == 1)
			{
				//Je suis sur une méthode qui a un nom set*DAO et qui prend 1 paramètre
				String daoName = m.getName().substring(3, 4).toLowerCase() + m.getName().substring(4);
				
				System.out.println("setter de DAO détecté -> " + daoName);
				
				if (webAppCtx.containsKey(daoName))
				{
					System.out.println("DAO avec bon nom détécté -> "+daoName);
					
					Object dao = webAppCtx.get(daoName);
					
					//Je vérifie si je peut passer l'objet en paramètre à mon setter
					if (dao.getClass().isAssignableFrom(m.getParameterTypes()[0]) )
					{
						//J'appelle le setter
						System.out.println("appel du setter de "+daoName);
						m.invoke(action, dao);
					}
					
					
				}

			}
		}
		
		//je passe à l'intercepteur suivant
		String result = invocation.invoke();
		
		return result;
	}

}
