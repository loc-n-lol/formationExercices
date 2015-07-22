package spydir.util;

import java.io.File;
import java.util.ArrayList;

public class SpyDir implements Runnable {

	private File dir;
	private LogManager log;
	
	ArrayList<File> fileList;
	
	private boolean mustStop;
	
	public void setMustStop(boolean mustStop) {
		this.mustStop = mustStop;
	}
	
	public SpyDir(String dir) {
		this.dir=new File(dir);
		
		if (!this.dir.exists())
			this.dir.mkdir();
		
		fileList = new ArrayList<File>();
	}


	@Override
	public void run() {
		
		getLogManager().log("Beginning scan of "+dir.getAbsolutePath());
		
		//1er parse
		for(File f: dir.listFiles())
		{
			fileList.add(f);
			getLogManager().log(dir.getName() + " : " + (f.isDirectory() ? "Directory" : "File") + " found : "+f.getAbsolutePath());
		}
		
		while(!mustStop)
		{
			
			ArrayList<File> newFileList = new ArrayList<File>();
			
			for(File f: dir.listFiles())
			{
				newFileList.add(f);
				
				if (fileList.contains(f))
				{
					//Fichier connu	
					fileList.remove(f);
				}
				else
				{
					//Nouveau fichier
					getLogManager().log(dir.getName() + " : " + (f.isDirectory() ? "Directory" : "File") + " added : "+f.getAbsolutePath());
				}	
			}
			
			for(File f: fileList)
			{
				//Fichier disparu
				getLogManager().log(dir.getName() + " : " + (f.isDirectory() ? "Directory" : "File") + " removed : "+f.getAbsolutePath());
			}	
			
			fileList = newFileList;
			
			
			try 
			{
				Thread.sleep((long) (2000 *(Math.random()+1)));
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
				return;
			}
			
		}
	
		
	}

	public LogManager getLogManager() {
		if (log != null)
			return log;

		log = new LogManager(dir+".log");
		
		return log;
	}

	public void setLogManager(LogManager log) {
		this.log = log;
	}

}
