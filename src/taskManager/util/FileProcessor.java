package taskManager.util;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

import taskManager.subject.DashboardSubject;
import taskManager.subject.Subject;

public class FileProcessor {
	private Subject sub;
	//DashboardSubject s = new DashboardSubject();
	private BufferedWriter output=null;
	private String inputfilename;
	private String outputfilename;
	
	public FileProcessor(Subject sub,String inputfilename,String outfilename)
	{
		MyLogger.printToStdout(2,"Fileprocessor constructor is called");
		this.inputfilename = inputfilename; 		
		this.outputfilename = outfilename;
		this.sub =  sub;
	}

	
	/*
	 * To read from file
	 */
	
	public void ReadfromFile()
	{
		MyLogger.printToStdout(3,"Readfromfile method is called");
		File f = new File(this.inputfilename);
		if(f.length()==0)
		{
			System.out.println("File is empty");
		}
		else
		{
		Scanner br=null;
    	FileReader reader=null;	
		try{
			reader=new FileReader(f);
			br = new Scanner(reader);
			String textLine = "";
			while(br.hasNextLine()){
				textLine = br.nextLine();
				sub.setMeasurements(textLine);
					
			}
		}catch(Exception E){
				E.printStackTrace();
				System.out.println("Exception: file operation");
			}
		   finally
		   {
			   br.close();
		   }
		}
		
	}

}
