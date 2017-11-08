package zhonghe;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class SJF {

	private List<Task> task;		//作业队列
	private List<Task> Pro;			//处理器

	
	public SJF() {
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
            		int index = Search();
            		Pro.add(task.get(index));
            		SetDate(time);
            		System.out.println("Now Time:"+time+"s "+Pro.get(0).toString());
            		task.remove(index);
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
	private int Search(){
		int index = 0;
		int shortTime = task.get(0).getServiceTime();
		for(int i=0;i<task.size();i++){
			if(task.get(i).getServiceTime()<shortTime){
				shortTime = task.get(i).getServiceTime();
				index = i;
			}
		}
		return index;
	}
}
