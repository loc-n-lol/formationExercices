package com.loncoto.InterfaceBuilder.factory;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.loncoto.InterfaceBuilder.windows.BaseWindow;
import com.loncoto.InterfaceBuilder.windows.BorderWindow;
import com.loncoto.InterfaceBuilder.windows.FlowWindow;
import com.loncoto.InterfaceBuilder.windows.GridWindow;

public class WindowFactory 
{
	private Document doc;
	
	
	public WindowFactory(String configFile) {
		File f = new File(configFile);
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			doc = db.parse(f);
	
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public JFrame buildWindow(String windowName) {
		
		
		NodeList nl = doc.getElementsByTagName("window");
		
		Element window = null;
		
		for (int i = 0; i < nl.getLength(); i++) {
			window = (Element)nl.item(i);
			
			if (window.getAttribute("name").equals( windowName ) )
			{
				break; //Trouvé
			}
			
		}
		
		if (window == null)
		{
			System.out.println("Nom de fenêtre pas trouvé dans le fichier de configuration : " + windowName);
			return null;
		}
		
		BaseWindow returnFrame = null;
		
		switch(window.getAttribute("type"))
		{
		case "BorderWindow":
			returnFrame = new BorderWindow(windowName);
			break;
		case "FlowWindow":
			returnFrame = new FlowWindow(windowName);
			break;
		case "GridWindow":
			returnFrame = new GridWindow(windowName, Integer.parseInt(window.getAttribute("cols")), 
					Integer.parseInt(window.getAttribute("rows")));
			break;
		}
		
		if (returnFrame == null)
		{
			System.out.println("Type de fenêtre non reconnu / non implémenté : " + window.getAttribute("type"));
			return null;
		}
		
		returnFrame.buildWindow(window);
		
		returnFrame.pack();
		returnFrame.setLocationRelativeTo(null);
		
		return returnFrame;
	}
}
