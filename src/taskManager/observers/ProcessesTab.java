package taskManager.observers;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.Formatter;

import taskManager.display.DisplayFile;
import taskManager.subject.Subject;
import taskManager.util.FileProcessor;
import taskManager.util.MyLogger;

import java.util.List;

public class ProcessesTab implements Observer,DisplayFile{

	private Subject sub =null;
	private List<String> processeslist  = null; 
	private String s[];
	private BufferedWriter output=null;
	private ProcessesTabFilterImpl processfltrimpl = null;
	FileProcessor fp = null;
	
	public ProcessesTab (){
		MyLogger.printToStdout(2,"Processes Constructor is called");
		processeslist = new ArrayList<String>();
		processfltrimpl = new ProcessesTabFilterImpl();
		
	}
	
	/*
	 * To Update local string  
	 */
	public void update(String souter[],BufferedWriter output,String str[]){
		MyLogger.printToStdout(3,"Update Method is called");
		for(int i =0;i<souter.length ; i++)
			processeslist.add(souter[i]);
		this.output = output;
		this.s = str;
		if(s.length != 1){
			Display();
		}	
	}
	/*
	 * 
	 * @Desc: To Display Processes Tab
	 */
	public void DisplayTab(int flag,BufferedWriter output)
	{
		MyLogger.printToStdout(3,"DisplayTab Method is called");
		this.output = output;
		processfltrimpl.TabDisplay(flag, output);
	}
	
	/*
	 * To Display input string 
	 */
	
	public void Display()
	{
		MyLogger.printToStdout(1,"Display Method is called");
		try	{
			output.write("---PROCESSES---");
			output.newLine();
			output.flush();
			output.write("  PID ");
			output.write("COMMAND         ");
			output.write("USER     ");
			output.write("%CPU ");
			output.write("%MEM");
			output.flush();
			output.newLine();
			
			for(int i=1;i<s.length;i++){
				if(i%5==4){
					output.write(String.format("%4s",s[i]));
						output.flush();
					
				}
				else if(i%5==3){
					output.write(String.format("%-9s",s[i]));
					output.flush();
				}
				else if(i%5==2){
					output.write(String.format("%-16s",s[i]));
					//output.write("     ");
					output.flush();			
				}
				else if(i%5==1){
					if(s[i].length() == 4){
						output.write(String.format("%5s",s[i]));
					}
					else{
						output.write(s[i]);
					}
					//output.write(s[i]);
					output.write(" ");
					output.flush();
				}
				else{
					output.write(String.format("%5s",s[i]));
					output.newLine();
					output.flush();
				}
				if(i==s.length-1)
				{	output.newLine();
				}
					
			}
		}catch(Exception E){
			E.printStackTrace();
			System.out.println("Exception: file operation");			
		}	
		finally{
			
		}
	}
}