package taskManager.driver;
import taskManager.filter.DashboardFilter;
import taskManager.observers.*;
import taskManager.subject.DashboardSubject;
import taskManager.subject.Subject;
import taskManager.util.FileProcessor;
import taskManager.util.MyLogger;

public class Driver {

     	public static void main(String[] args) {
     		MyLogger d  = MyLogger.getInstance();
     		
     		try{
     			if(args.length != 3) {
     				System.err.println("Less than Required length input, please enter three parameters for logger level,input file,output file\n");
     				System.exit(1);
     			}
     			if(Integer.parseInt(args[0])>3 ||Integer.parseInt(args[0])<0)
     			{
     				System.err.println("Invalid Value");
     				System.exit(1);
     			}
     			d.set(Integer.parseInt(args[0]),args[2]);
		     	
     			Subject sub = new DashboardSubject(); 
     			sub.set(args[2]);
		     	DashboardFilter filter = null;
		     	
		     	Observer Performance = new PerformanceTab();
		     	sub.registerobserver(Performance, (filter=new PerformanceTabFilterImpl()));
				
		     	Observer user = new UsersTab();
				sub.registerobserver(user,(filter = new UsersTabFilterImpl()));
				
				Observer processes = new ProcessesTab();
				sub.registerobserver(processes, (filter = new ProcessesTabFilterImpl()));
				
				FileProcessor fp=new FileProcessor(sub,args[1],args[2]);
				fp.ReadfromFile();
     		}
     		catch(Exception e){
     			System.out.println(e);
     		}
     		finally{}
	}
}
