package taskManager.subject;

import taskManager.filter.DashboardFilter;
import taskManager.observers.Observer;

public interface Subject {

	void registerobserver(Observer o,DashboardFilter f);
	void removeobserver(Observer o);
	void notifyallobservers();
	void StartProcessing();
	void set(String str);
    void setMeasurements(String s);
    
}
