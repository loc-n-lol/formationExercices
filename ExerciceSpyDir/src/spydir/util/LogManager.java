package spydir.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogManager {

	private File logfile;
	private PrintWriter pw;
	
	private static DateFormat dateformat;
	
	static {
		
		dateformat = new SimpleDateFormat("dd/MM/yy [HH:mm:ss]");
		
	}
	
	public LogManager(String filename)
	{
		logfile = new File(filename);
		
		try {
			
			if (!logfile.exists())
				logfile.createNewFile();
			
			pw = new PrintWriter(logfile);
		} 
		catch (FileNotFoundException e) {e.printStackTrace();} 
		catch (IOException e) {e.printStackTrace();}
	}
	
	//Peut être appelé par plusieurs threads en même temps
	public synchronized void log(String trace)
	{
		System.out.println(dateformat.format(new Date()) + " " + logfile.getAbsolutePath()+" -> "+trace);
		pw.println(dateformat.format(new Date()) + " " + trace);
		pw.checkError();
	}
	
	public void close()
	{
		pw.close();
	}
	
}
