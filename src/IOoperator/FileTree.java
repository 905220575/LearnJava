package IOoperator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FileTree {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		 String path="C://Users//Administrator//Workspaces//MyEclipse Professional 2014//JavaLearn";
		 //这里改成文件夹路径，记住是//不是\
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
		 inFile.close();
	}
}
