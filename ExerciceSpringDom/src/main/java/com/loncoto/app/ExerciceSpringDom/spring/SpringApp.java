package com.loncoto.app.ExerciceSpringDom.spring;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.validation.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.w3c.dom.*;
import org.xml.sax.SAXException;


public class SpringApp {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
			
	try {

//		DocumentBuilderFactory dbf = (DocumentBuilderFactory)ctx.getBean("dbf");		
//		
//		File fschema = new File("baseexport.xsd");
//		SchemaFactory sfactory = SchemaFactory
//				.newInstance("http://www.w3.org/2001/XMLSchema");
//		Schema schema = sfactory.newSchema(fschema);
//		
//
//		dbf.setSchema(schema);
//	
//		DocumentBuilder db = dbf.newDocumentBuilder();
//		File f = new File("baseexport.xml");
//		Document doc = db.parse(f);
		
		System.out.println("---");
		
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		Document doc = ctx.getBean("doc", Document.class);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		NodeList ln = doc.getElementsByTagName("column");
		for (int i = 0; i < ln.getLength(); i++)
		{
			// je reconverti(cast) le noeud en element
			// pour acceder a ses caracteristiques plus détaillées
			Element e = (Element)ln.item(i);
			System.out.println(e.getAttribute("name")
					+ " -> " + e.getAttribute("type"));
			// ajout d'un attribut a la balise column
			e.setAttribute("bob", "i:" + i);
		}
		
		// sauvegardons nos modifications
		DOMSource domSource = new DOMSource(doc);
		TransformerFactory tfactory =
				TransformerFactory.newInstance();
		Transformer tf = tfactory.newTransformer();
		StreamResult result = new StreamResult(
				new File("baseexport2.xml"));
		
		// ecriture du xml resultat
		tf.transform(domSource, result);
		
		
	} 
/*
	catch (ParserConfigurationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SAXException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
*/
	catch (TransformerConfigurationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (TransformerException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

       

		System.out.println("done...");
	}





}
