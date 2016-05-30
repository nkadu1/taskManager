package taskManager.subject;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import taskManager.display.DisplayFile;
import taskManager.filter.DashboardFilter;
import taskManager.observers.Observer;
import taskManager.observers.defaultlistener;
import taskManager.util.FileProcessor;
import taskManager.util.MyLogger;

public class DashboardSubject implements Subject{
	private String s = null;
	private String strinner[] =null;
	private String strouter[] =null;
	public BufferedWriter output = null;
	public Map <Observer,DashboardFilter> listofobservers=null; 
	String outfilename;
	/**
	 * @Description: To Initialise FileWriter 
	 */
	public DashboardSubject(){
		MyLogger.printToStdout(2,"Dashboard Subject constructor is called");
		listofobservers = new LinkedHashMap<Observer,DashboardFilter>();;
	}

	/**
	 * @Description: To match Strings 
	 */
	public void notifyallobservers()
	{	
		MyLogger.printToStdout(3,"notifyall method is called");
			defaultlistener df = new defaultlistener(output);
			if(s != null  && !s.isEmpty()){
				splitouter();
				for(int h=0;h<strouter.length;h++){
					for (Observer key : listofobservers.keySet()) {  // "for each key in the map's key set"
						if((listofobservers.get(key).check(listofobservers.get(key),h,strouter))){
							if(h==0){
								key.DisplayTab(1, output);
							}
							strinner = listofobservers.get(key).getString();
							key.update(strouter,output,strinner);
							
							if(h == strouter.length-1)
								key.DisplayTab(0, output);
					    }					
					}
				}			
		}
		else
		{
			df.TabDisplay(1);
			df.TabDisplay(0);	
		}
	}
	
	public void StartProcessing(){
		notifyallobservers();	
		
	}
	
	public void set(String outputfilename)
	{
		try {
			output = new BufferedWriter(new FileWriter(outputfilename));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	/**
	 * @Description: Used to split the incoming String
	 * 
	 */
	public void splitouter()
	{
		MyLogger.printToStdout(3,"splitouter method is called");
		strouter = s.split("\\*");
	}
	
	/**
	 * @Description: To Register Observers
	 */
	public void registerobserver(Observer o,DashboardFilter f) {
		if(!listofobservers.containsKey(o))
			listofobservers.put(o ,f);
	}

	/**
	 * @Description: To remove Observer
	 */
	public void removeobserver(Observer o) {
		if(!listofobservers.containsKey(o))
			listofobservers.remove(o);
	}
	
	/**
	 * @Description: To Set input String
	 */
	public void setMeasurements(String s) {
		this.s = s;
		StartProcessing();
	}
	
}
