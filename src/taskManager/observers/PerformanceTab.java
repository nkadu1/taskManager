package taskManager.observers;

import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.List;

import taskManager.display.DisplayFile;
import taskManager.filter.DashboardFilter;
import taskManager.util.MyLogger;

public class PerformanceTab implements Observer,DisplayFile{
	public static String  s[];
	public BufferedWriter output = null;
	private PerformanceTabFilterImpl perftabimpl = null;
	private DashboardFilter PerformanceTabfilter = null;
	private List<String> performancelist  = null; 

	/*
	 * Constructor to create new list
	 */
	public PerformanceTab() {
		MyLogger.printToStdout(2,"Performance Constructor is called");
		performancelist = new ArrayList<String>();
		perftabimpl  = new PerformanceTabFilterImpl();
	} 
	
	/*
	 * To update local string
	 */
	public void update(String souter[],BufferedWriter output,String str[]){
		for(int i=0;i<souter.length ;i++)
			performancelist.add(souter[i]);
		this.output = output;
		this.s = str;
		if(s.length != 1){
			Display();
		}	
	}
	
	/*
	 * To Display Tab
	 */
	public void DisplayTab(int flag,BufferedWriter output)
	{
		MyLogger.printToStdout(1,"DisplayTab Method is called");
		this.output = output;
		perftabimpl.TabDisplay(flag, output);
	}
	
	/*
	 * To Display contents of input string
	 */
    
	public void Display()
	{
		MyLogger.printToStdout(3,"Display Method is called");
    	try	{
			output.write("---PERFORMANCE---");
			output.newLine();
			output.flush();
		
			for(int i=1;i<s.length;i++){
				if(i%7==1){
					output.write("Memory Total: ");
					output.write(s[i]);
					output.write("  ");
					output.flush();
				}
				else if(i%7==2){
					output.write("Memory Used: ");
					output.write(s[i]);
					output.write("  ");
					output.flush();
				}
				else if(i%7==3){
					output.write("Memory  Free: ");
					output.write(s[i]);
					output.write("  ");
					output.flush();
				}
				else if(i%7==4){
					output.write("Memory  Cached: ");
					output.write(s[i]);
					output.newLine();
					output.flush();
				}
				else if(i%7==5){
					output.write("CPU Idle: ");
					output.write(s[i]);
					output.write("  ");
					output.flush();
				}
				else if(i%7==6){
					output.write("CPU User Level: ");
					output.write(s[i]);
					output.write("  ");
					output.flush();
				}
				else {//if(i%7!=7){
					output.write("CPU System Level: ");
					output.write(s[i]);
					output.newLine();
					output.newLine();
					output.flush();
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
