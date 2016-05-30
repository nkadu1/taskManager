package taskManager.util;

import java.io.FileReader;
import java.util.Scanner;

public class MyLogger {
	private volatile static MyLogger uniqueInstance;
	private static int loggerValue;
	private static  String outputfilename=null;

	private MyLogger() 
	{
	}
	
	public static MyLogger getInstance() 
	{
		if(uniqueInstance == null)
		{
			synchronized (MyLogger.class) 
			{
				if(uniqueInstance == null)
				{
					uniqueInstance = new MyLogger();
				}
			}
		}
		
		return uniqueInstance;
	}
	
	public  void set(int value,String outputfilename1)
	{
		loggerValue= value;
		this.outputfilename = outputfilename1;
	}
	
	public int get()
	{
		return loggerValue;
	}
	
	public static void printToStdout(int level, String debugMessage)
	{
		
		if(level == loggerValue)
		{
			if(loggerValue == 1){
				 Scanner br=null;
				 FileReader reader=null;	
				try{
					reader=new FileReader(outputfilename);
					br = new Scanner(reader);
					while(br.hasNextLine()){
						System.out.println(br.nextLine());
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
			else{
				System.out.print(level);
				System.out.println(","+debugMessage);
			}
		}	
	}

}
