package spydir.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import spydir.util.LogManager;
import spydir.util.SpyDir;

public class Program {

	public static void main(String[] args) {

		
		ExecutorService srv = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		
		
		
		
		File f = new File("repertoires.xml");
		
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(f);
			
			
			NodeList nl = doc.getElementsByTagName("rep");
			
			LogManager lm = new LogManager("common.log");
			
			for (int i = 0; i < nl.getLength(); i++) {
				Element el = (Element)nl.item(i);
				String text = el.getTextContent();
				
				//System.out.println(text);
				
				SpyDir sd = new SpyDir(text);
				sd.setLogManager(lm);
				
				srv.execute(sd);
			}
			
			
			srv.shutdown();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
