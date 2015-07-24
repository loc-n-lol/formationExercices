package com.loncoto.InterfaceBuilder.windows;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public abstract class BaseWindow extends JFrame {

	private HashMap<String, JComponent> hmap;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BaseWindow(String name)
	{
		super(name);
		hmap = new HashMap<String, JComponent>();
	}
	
	public void buildWindow(Element window) 
	{
		NodeList nl = window.getChildNodes();

		for (int i = 0; i < nl.getLength(); i++) 
		{
			if (nl.item(i) instanceof Element) 
			{
				Element e = (Element) nl.item(i);
				add(e);
			}
		}
	}
	
	public void add(Element e)
	{
		JComponent component = null;
		

		try {
			Class componentClass = Class.forName("javax.swing."+e.getTagName());
			
			if (!e.getAttribute("text").equals(""))
			{
				Constructor stringConstructor = componentClass.getConstructor(String.class);
				
				component = (JComponent) stringConstructor.newInstance(e.getAttribute("text"));
			}
			else if (!e.getAttribute("column").equals(""))
			{
				Constructor intConstructor = componentClass.getConstructor(int.class);
				
				component = (JComponent) intConstructor.newInstance(Integer.parseInt(e.getAttribute("column")));
			}

		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | 
				IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e1) {
			e1.printStackTrace();
		}

		
/*
		switch (e.getTagName()) 
		{
		case "JTextField":
			component = new JTextField(Integer.parseInt(e.getAttribute("column")));
			break;
		case "JButton":
			component = new JButton(e.getAttribute("text"));
			break;
		case "JLabel":
			component = new JLabel(e.getAttribute("text"));	
			break;
		}
*/
		
		
		if (component == null)
		{
			System.out.println("Composant inconnu : " + e.getTagName());
			return;
		}
		
		hmap.put(e.getAttribute("name"), component);
		add(component, e.getAttribute("pos"));
	}
	
	public JComponent getComponentByName(String name)
	{
		return hmap.get(name);
	}


	
}
