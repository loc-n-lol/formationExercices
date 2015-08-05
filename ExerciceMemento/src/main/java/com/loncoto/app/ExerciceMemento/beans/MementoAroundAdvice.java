package com.loncoto.app.ExerciceMemento.beans;

import java.util.HashMap;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MementoAroundAdvice implements MethodInterceptor {

	private HashMap<String, HashMap<String, Object>> hmap_method;
	
	@Override
	public Object invoke(MethodInvocation mi) throws Throwable 
	{
		Object[] args = mi.getArguments();
		String methodName = mi.getThis().getClass().getName()+"."+ mi.getMethod().getName();
		
		if (args.length == 1 && args[0].getClass() == String.class)
		{
		
			System.out.println("Interception de " +methodName + "(" +args[0]+ ")");

		
			HashMap<String, Object> hmap_results = null;
			
			
			if (hmap_method == null)		
				hmap_method = new HashMap<String, HashMap<String, Object>>();
			
			if (hmap_method.containsKey(methodName))
				hmap_results = hmap_method.get(methodName);
			
			if (hmap_results == null)		
			{
				hmap_results = new HashMap<String, Object>();
				hmap_method.put(methodName, hmap_results);
			}
			
			if (hmap_results.containsKey(args[0]))
				return hmap_results.get(args[0]);
			
			Object ret = mi.proceed();
			
			hmap_results.put((String)args[0], ret);	
			
			return ret;
		
		}
		else
		{
			System.out.println("ERREUR: MementoAroundAdvice appelé avec un paramètre autre que String");
			return mi.proceed();
		}
	}

}
