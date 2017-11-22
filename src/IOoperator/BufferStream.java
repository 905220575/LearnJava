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
		long startTime = System.currentTimeMillis();    //��ȡ��ʼʱ��
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
		long endTime = System.currentTimeMillis();    //��ȡ����ʱ��
		System.out.println("����������������ʱ�䣺" + (endTime - startTime) + "ms");    //�����������ʱ��
		startTime = System.currentTimeMillis();    //��ȡ��ʼʱ��
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
		endTime = System.currentTimeMillis();    //��ȡ����ʱ��
		System.out.println("������������������ʱ�䣺" + (endTime - startTime) + "ms");    //�����������ʱ��
	}

}
