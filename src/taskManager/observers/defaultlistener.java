package taskManager.observers;

import java.io.BufferedWriter;

public class defaultlistener {

	
	private BufferedWriter output = null;
	
	public defaultlistener(BufferedWriter output ) {
			this.output = output;
	}
	
	public void TabDisplay(int flag){
		try{
			if(flag  == 1){
	//			System.out.println("inside flag1 default");
				output.write("---TAB(s) BEGIN---");
				}
			else if(flag  == 0){
		//		System.out.println("inside flag0 default");
				output.write("---TAB(s) END---");}
			output.newLine();
			output.flush();
		}
		catch(Exception e)
		{e.printStackTrace();}
		finally{}
	}
		
}
	
