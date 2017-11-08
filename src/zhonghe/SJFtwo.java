package zhonghe;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SJFtwo {
	private List<Task> task;		//作业队列
	private List<Task> Pro;			//处理器
	private List<Task> Pro2;		//处理器
	
	public SJFtwo() {
		task = new ArrayList<Task>();
		Pro = new ArrayList<Task>();
		Pro2 = new ArrayList<Task>();
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
            	if(!Pro2.isEmpty() && time==Pro2.get(0).getFinishingTime()){
            		Pro2.remove(0);
            	}
            	if(Pro.isEmpty() && !task.isEmpty()){
            		int index = Search();
            		Pro.add(task.get(index));
            		SetDate(time,1);
            		System.out.println("First  Pro "+"Now time:"+time+"s "+Pro.get(0).toString());
            		task.remove(index);
            	}
            	if(Pro2.isEmpty() && !task.isEmpty()){
            		int index = Search();
            		Pro2.add(task.get(index));
            		SetDate(time,2);
            		System.out.println("Second Pro "+"Now time:"+time+"s "+Pro2.get(0).toString());
            		task.remove(index);
            	}
            	time++;
            }	
        } catch (FileNotFoundException e) {
             e.printStackTrace();
        }
        scanner.close();
	}
	private void SetDate(int time,int num){
		if(num==1){
			Pro.get(0).setStartingTime(time);
			Pro.get(0).setFinishingTime(time + Pro.get(0).getServiceTime());
			Pro.get(0).setTurnAroundTime(Pro.get(0).getFinishingTime() - Pro.get(0).getArrivalTime());
			Pro.get(0).setWeightTurnAround(Pro.get(0).getTurnAroundTime() * 1.0 / Pro.get(0).getServiceTime());
		}else{
			Pro2.get(0).setStartingTime(time);
			Pro2.get(0).setFinishingTime(time + Pro2.get(0).getServiceTime());
			Pro2.get(0).setTurnAroundTime(Pro2.get(0).getFinishingTime() - Pro2.get(0).getArrivalTime());
			Pro2.get(0).setWeightTurnAround(Pro2.get(0).getTurnAroundTime() * 1.0 / Pro2.get(0).getServiceTime());
		}		
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
