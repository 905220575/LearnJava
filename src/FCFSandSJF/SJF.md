# JAVA集合类综合小实验
### 模拟实现SJF（短作业优先）
#### 实验要求  

SJF算法首先调度已到达的任务中，服务时间最短的任务，这里不要求实现任务的抢占。按照FCFS算法的要求实现SJF算法，同样要求处理两种情况：当只有一个处理队列时的情况当有两个处理队列时的情况
#### 部分代码展示
一个队列情况  

	`Scanner scanner = null;
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
        scanner.close();`
两个队列情况  

	`Scanner scanner = null;
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
        scanner.close();`
#### 实验结果
一个队列情况  

![image](https://raw.githubusercontent.com/905220575/LearnJava/master/img/zhonghe/SJFone.png) 
两个队列情况  

![image](https://raw.githubusercontent.com/905220575/LearnJava/master/img/zhonghe/SJFtwo.png) 







