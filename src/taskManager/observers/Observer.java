package taskManager.observers;

import java.io.BufferedWriter;

public interface Observer {

	public void update(String s[],BufferedWriter output,String str[]);
	public void DisplayTab(int flag,BufferedWriter output);
}
