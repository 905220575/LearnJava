package zhonghe;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FCFStwo {
	
	private List<Task> task;		//��ҵ����
	private List<Task> Pro;			//������
	private List<Task> Pro2;		//������

	
	public FCFStwo() {
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
            		Pro.add(task.get(0));
            		SetDate(time,1);
            		System.out.println("First  Pro "+"Now time:"+time+"s "+Pro.get(0).toString());
            		task.remove(0);
            	}
            	if(Pro2.isEmpty() && !task.isEmpty()){
            		Pro2.add(task.get(0));
            		SetDate(time,2);
            		System.out.println("Second Pro "+"Now time:"+time+"s "+Pro2.get(0).toString());
            		task.remove(0);
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

}
