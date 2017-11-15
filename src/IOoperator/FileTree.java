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
		 //����ĳ��ļ���·������ס��//����\
		 File file=new File(path);
		 File[] tempList = file.listFiles();
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 Calendar cal = Calendar.getInstance();
		 FileWriter  inFile = new FileWriter("src/FileTree.txt");  
		 System.out.println("��Ŀ¼�¶��������"+tempList.length);
		 for (int i = 0; i < tempList.length; i++) {
			 if (tempList[i].isDirectory()) {
				 cal.setTimeInMillis(tempList[i].lastModified());
				 String s = sdf.format(cal.getTime());				 
				 String str = "�ļ��У�"+tempList[i]+"  �޸����ڣ�"+s+ System.getProperty("line.separator");
				 System.out.print(str);
				 inFile.write(str); 
			 }
		 }
		 for (int i = 0; i < tempList.length; i++) {
			 if (tempList[i].isFile()) {
				 cal.setTimeInMillis(tempList[i].lastModified());
				 String s = sdf.format(cal.getTime());
				 String str = "��     ����"+tempList[i]+"  �޸����ڣ�"+s+"  �ļ���С��"+tempList[i].length()*0.1/1024+"KB"+ System.getProperty("line.separator");
				 System.out.print(str);
				 inFile.write(str);
			 }
		}	
		 inFile.close();
	}
}
