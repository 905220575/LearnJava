# JAVA的IO操作
### 实验一 基本IO操作
#### 实验要求  

从键盘接收字节流
写入到当前目录下的src.txt文件中
将src.txt文件内容复制到当前目录下dest.txt文件中
将dest.txt文件内容显示到屏幕上

#### 实验结果  

控制台输入  

![image](https://raw.githubusercontent.com/905220575/LearnJava/master/img/IOoperator/Input.png) 

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
		 `String path="C://Users//Administrator//Workspaces//MyEclipse Professional 2014//JavaLearn"; `
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
#### 实验结果
控制台  

![image](https://raw.githubusercontent.com/905220575/LearnJava/master/img/IOoperator/FileTree.png)  

txt文件内容  

![image](https://raw.githubusercontent.com/905220575/LearnJava/master/img/IOoperator/FileTreeTxt.png)  

### 实验三 带缓冲区的IO
#### 实验要求

用带缓冲和不带缓冲的字符流实现文件复制，并比较耗时情况。

#### 部分代码展示
		 `long startTime = System.currentTimeMillis();    //获取开始时间
		try {  
		    File inFile = new File("C://Users//Administrator//Desktop//src.txt");  
		    File outFile = new File("C://Users//Administrator//Desktop//dest.txt");  
		    FileInputStream finS = new FileInputStream(inFile);  
		    FileOutputStream foutS = new FileOutputStream(outFile);  
		    BufferedInputStream bfinS=new  BufferedInputStream(finS);
		    BufferedOutputStream bfoutS=new  BufferedOutputStream(foutS) ;
		    int c;
		    while((c = bfinS.read()) != -1){
		    	bfoutS.write(c);
		    }
		    bfinS.close();
		    bfoutS.close();
		}
		catch (IOException e) {  
            System.err.println("BufferStreamsTest: " + e);  
        } 
		long endTime = System.currentTimeMillis();    //获取结束时间
		System.out.println("带缓存区程序运行时间：" + (endTime - startTime) + "ms");    //输出程序运行时间
		startTime = System.currentTimeMillis();    //获取开始时间
        try {  
            File inFile = new File("C://Users//Administrator//Desktop//src.txt");  
            File outFile = new File("C://Users//Administrator//Desktop//dest.txt");  
            FileInputStream finS = new FileInputStream(inFile);  
            FileOutputStream foutS = new FileOutputStream(outFile);  
            int c;  
            while ((c = finS.read()) != -1) {  
                foutS.write(c);  
            }  
            finS.close();  
            foutS.close();  
        } catch (IOException e) {  
            System.err.println("FileStreamsTest: " + e);  
        } 
		endTime = System.currentTimeMillis();    //获取结束时间
		System.out.println("不带缓存区程序运行时间：" + (endTime - startTime) + "ms");    //输出程序运行时间`
#### 实验结果  

![image](https://raw.githubusercontent.com/905220575/LearnJava/master/img/IOoperator/BufferStream.png)  

### 实验四 对象序列化
#### 实验要求

类Student表示学生，属性包括{studentID, name, sex} (学号，姓名，性别)，使用序列化技术定义Student。学生信息从文件list.txt读入，并按照学号升序排列。注意，这里姓名和性别可以组织成String类型，而学号可以是String也可以是Long。使用ObjectOutputStream将已经排序的学生信息写出到文件“student.bin”中。使用ObjectInputStream将“student.bin”中的对象信息读入程序，显示在控制台中。

#### 部分代码展示
		 `File file = new File("C:/Users/Administrator/Desktop/list.txt");
	
		this.destFile = new File("C:/Users/Administrator/Desktop/student.bin");
		this.student = new ArrayList<Student>();
		
        Scanner scanner = null;
		try {
			scanner = new Scanner(file);
			while (scanner.hasNext()) {
                long StudentID = scanner.nextLong();
                String name = scanner.next();
                char sex = scanner.next().charAt(0);
                this.student.add(new Student(StudentID, name, sex));
            }
		} catch (IOException e) {
			// TODO: handle exception
			System.err.println("FileStreamsTest: " + e);
		}
		sortByStudentID(this.student);`
#### 实验结果  

![image](https://raw.githubusercontent.com/905220575/LearnJava/master/img/IOoperator/Object.png)  
