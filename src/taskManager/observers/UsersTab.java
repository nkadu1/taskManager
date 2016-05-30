package taskManager.observers;
import java.io.BufferedWriter;

import taskManager.display.DisplayFile;
import taskManager.util.MyLogger;

import java.util.ArrayList;
import java.util.List;

public class UsersTab implements Observer ,DisplayFile{
	private static String  s[];
	private BufferedWriter output = null;
	private UsersTabFilterImpl userflyrimpl =null;
	private List<String> userslist  = null; 

	/**
	 * @Description: To initialise filter and sub object
	 */
	public UsersTab (){
		MyLogger.printToStdout(2,"Usertab constructor is called");
		userslist = new ArrayList<String>();
		userflyrimpl  = new UsersTabFilterImpl();
	}
	
	/**
	 * To Display Tab related to Users
	 */
	public void DisplayTab(int flag,BufferedWriter output)
	{
		MyLogger.printToStdout(3,"DisplayTab is called");
		this.output = output;
		userflyrimpl.TabDisplay(flag, output);
	}
	
	/**
	 * @Description: 
	 */
	public void update(String souter[],BufferedWriter output,String str[]){
		MyLogger.printToStdout(3,"DisplayTab is called");
		for(int i=0;i<souter.length ;i++)
			userslist.add(souter[i]);

		this.output = output;
		this.s = str;
		if(s.length != 1){
			Display();
		}	
	}

	/**
	 * @Desc: To Display the updates
	 * @see taskManager.display.DisplayFile#Display()
	 */
	public void Display()
	{
		MyLogger.printToStdout(1,"Display is called");
		try	{
			output.write("---USERS---");
			output.newLine();
			output.flush();
			for(int i=1;i<s.length;i++){
				if(i%2!=0){
					output.write("User: ");
					output.write(s[i]);
					output.write("  ");
					output.flush();
				}
				else{
					output.write("Status: ");
					output.write(s[i]);
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
