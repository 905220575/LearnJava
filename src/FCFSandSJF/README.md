﻿# JAVA集合类综合小实验
### 模拟实现FCFS（先来先服务）算法
#### 实验要求  

FCFS算法按照任务到达的顺序进行服务，先来先服务每个Task对象可以描述为至少包含下列属性：taskID //任务IDarrivalTime //到达时间serviceTime //服务时间startingTime //开始时间finishingTime //完成时间=开始时间+服务时间turnAroundTime //周转时间=完成时间-达到时间weightTurnAround //带权周转时间=周转时间/服务时间其他的属性根据程序需要设置  

任务(Task)的ID、开始时间和服务时间由文件读入，形如右图所示。这个任务列表文件首先由程序生成，每秒一个任务达到，服务时间由{6,2,1,3,9}这个集合中的数据随机获取。文件列表要包含至少100个任务。先要求实现如下要求的FCFS当只有一个处理队列时的情况当有两个处理队列时的情况  
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
        scanner.close();`
#### 实验结果
一个队列情况  

![image](https://raw.githubusercontent.com/905220575/LearnJava/master/img/zhonghe/FCFSone.png) 
两个队列情况  

![image](https://raw.githubusercontent.com/905220575/LearnJava/master/img/zhonghe/FCFStwo.png) 

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













