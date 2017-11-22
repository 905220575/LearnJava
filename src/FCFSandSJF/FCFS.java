package FCFSandSJF;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class FCFS {

	private List<Task> task;		//作业队列
	private List<Task> Pro;			//处理器
	
	public FCFS() {
		task = new ArrayList<Task>();
		Pro = new ArrayList<Task>();
	}
	public void Run(String fileString){
        Scanner scanner = null;
        int time = 0;
        try {
            scanner = new Scanner(new File(fileString));
            while (scanner.hasNext() || !task.isEmpty()) {
            	if(scanner.hasNext()){
            		task.add(new Task(scanner.nextInt(), scanner.nextInt(), scanner.nextInt()));	//processID,arrivalTime,serviceTime
            	}
            	if(!Pro.isEmpty() && time==Pro.get(0).getFinishingTime()){
            		Pro.remove(0);
            	}
            	if(Pro.isEmpty()){
            		Pro.add(task.get(0));
            		SetDate(time);
            		System.out.println("Now Time:"+time+"s "+Pro.get(0).toString());
            		task.remove(0);
            	}

                time++;
            }
        } catch (FileNotFoundException e) {
             e.printStackTrace();
        }
        scanner.close();
	}
	private void SetDate(int time){
		Pro.get(0).setStartingTime(time);
		Pro.get(0).setFinishingTime(time + Pro.get(0).getServiceTime());
		Pro.get(0).setTurnAroundTime(Pro.get(0).getFinishingTime() - Pro.get(0).getArrivalTime());
		Pro.get(0).setWeightTurnAround(Pro.get(0).getTurnAroundTime() * 1.0 / Pro.get(0).getServiceTime());
	}
}
