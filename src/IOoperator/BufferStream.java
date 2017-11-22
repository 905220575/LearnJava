package IOoperator;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long startTime = System.currentTimeMillis();    //获取开始时间
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
		System.out.println("不带缓存区程序运行时间：" + (endTime - startTime) + "ms");    //输出程序运行时间
	}

}
