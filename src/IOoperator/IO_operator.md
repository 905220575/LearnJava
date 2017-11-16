# JAVA的IO操作
### 实验一 基本IO操作
#### 实验要求  

从键盘接收字节流
写入到当前目录下的src.txt文件中
将src.txt文件内容复制到当前目录下dest.txt文件中
将dest.txt文件内容显示到屏幕上

#### 实验结果  

控制台输入  

![image](https://raw.githubusercontent.com/905220575/LearnJava/master/img/IOoperator/InPut.png) 

文件夹情况  

![image](https://raw.githubusercontent.com/905220575/LearnJava/master/img/IOoperator/srcanddest.png)  

txt文件查看  

![image](https://raw.githubusercontent.com/905220575/LearnJava/master/img/IOoperator/src.png)  

![image](https://raw.githubusercontent.com/905220575/LearnJava/master/img/IOoperator/dest.png)  

### 实验二 获取系统的文件树
#### 实验要求

获取某个目录下的目录信息，目录从控制台输入。
目录信息包括该目录下的所有文件和文件夹的列表。对于每个文件夹显示其名称，修改日期。对于每个文件显示其名称，修改日期和大小。
目录的信息写出到文件中。注意，文件信息首先按类型分类，文件夹在前，文件在后，并且他们各自按照文件名字符串的顺序排序。  

#### 部分代码展示
`		 String path="C://Users//Administrator//Workspaces//MyEclipse Professional 2014//JavaLearn";  

		 File file=new File(path);  
		 File[] tempList = file.listFiles();  
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		 Calendar cal = Calendar.getInstance();  
		 FileWriter  inFile = new FileWriter("src/FileTree.txt");  
		 System.out.println("该目录下对象个数："+tempList.length);  
		 for (int i = 0; i < tempList.length; i++) {
			 if (tempList[i].isDirectory()) {
				 cal.setTimeInMillis(tempList[i].lastModified());
				 String s = sdf.format(cal.getTime());				 
				 String str = "文件夹："+tempList[i]+"  修改日期："+s+ System.getProperty("line.separator");
				 System.out.print(str);
				 inFile.write(str); 
			 }
		 }
		 for (int i = 0; i < tempList.length; i++) {
			 if (tempList[i].isFile()) {
				 cal.setTimeInMillis(tempList[i].lastModified());
				 String s = sdf.format(cal.getTime());
				 String str = "文     件："+tempList[i]+"  修改日期："+s+"  文件大小："+tempList[i].length()*0.1/1024+"KB"+ System.getProperty("line.separator");
				 System.out.print(str);
				 inFile.write(str);
			 }
		}	
		 inFile.close();`

