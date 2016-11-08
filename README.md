# taskManager
File Based Dashboard for a Task Manager

PROJECT 3

Due Date: Saturday, April 04, 2015
Submission Date: Saturday, April 04, 2015
Author(s): Niraj Kadu
e-mail(s): nkadu1@binghamton.edu

PURPOSE:

Design a simple taskmanager code in Java

PERCENT COMPLETE:

I believe I have completed 100% of the project.

FILES:

Following are the files that are necessary for the project to run:-
1)DisplayFile.java
2)Driver.java
3)DashboardFilter.java
4)defaultlistener.java	
5)PerformanceTab.java
6)PerformanceTabfilterimpl.java
7)ProcessesTab.java
8)ProcessesTabfilterimpl.java
8)UsersTab.java
11)UsersTabfilterimpl.java
10)DashboardSubject.java
11)Logger.java

SAMPLE OUTPUT:
---TAB(s) BEGIN---
---TAB(s) END---
---TAB(s) BEGIN---
---PERFORMANCE---
Memory Total: 2058364  Memory Used: 1949304  Memory  Free: 109060  Memory  Cached: 1539620
CPU Idle: 94.8  CPU User Level: 4.4  CPU System Level: 0.6

---TAB(s) END---
## To clean:
ant -buildfile src/build.xml clean

## To compile: 
ant -buildfile src/build.xml all

## To run
ant -buildfile src/build.xml run <args>
ant -buildfile src/build.xml run -Darg0=2 -Darg1=new_in1.txt -Darg2=myout.txt

## To create tarball for submission
ant -buildfile src/build.xml tarzip	
