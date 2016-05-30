package taskManager.observers;

import java.io.BufferedWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import taskManager.filter.DashboardFilter;
import taskManager.util.MyLogger;

public class ProcessesTabFilterImpl implements DashboardFilter{

	private BufferedWriter output = null;
	private String strinner[] =null;
	private String strmiddle[] = null;
	private String appendstrinner=null;
	private String appendstrmiddle=null;

	public void TabDisplay(int flag, BufferedWriter output ){
		MyLogger.printToStdout(3,"TabDisplay is called");
		this.output =output;
		try{
			if(flag  == 1){
				output.write("---TAB(s) BEGIN---");
				}
			else if(flag  == 0){
			output.write("---TAB(s) END---");}
			output.newLine();
			output.flush();
		}
		catch(Exception e)
		{e.printStackTrace();}
		finally{}
	}
	

	/**
	 * @Description: To match Strings
	 */
	public boolean check(DashboardFilter strchk,int h,String strouter[]){
		MyLogger.printToStdout(3,"Check is called");
		strmiddle = strouter[h].split("-");
		appendstrinner = strmiddle[0]; 
		int p=0;
		for(p = 1;p < strmiddle.length;p++)	{
			appendstrinner = appendstrinner + ":" +strmiddle[p];
		}
		strinner = appendstrinner.split(":");
		if(strinner[0]!=""){
			if(containsIgnoreCase( strchk.toString(),strinner[0]) )
			return true;
		else 
			return false;
		}
		else
			return false;
	}
	
	/**
	 * @Description: To compare two strings
	 * 
	 */
	public boolean containsIgnoreCase( String Container, String content ) {
		MyLogger.printToStdout(3,"TabIgnorecase is called");
		 if(content .equals(""))
		    return true;
		  if(Container== null || content == null || Container.equals(""))
		    return false; 

		  Pattern p = Pattern.compile(content ,Pattern.CASE_INSENSITIVE+Pattern.LITERAL);
		  Matcher m = p.matcher(Container);
		  return m.find();
	}


	public String[] getString()
	{
		return strinner;
	}	
}
