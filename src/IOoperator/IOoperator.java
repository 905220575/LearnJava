package IOoperator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class IOoperator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		try {
			System.out.println("Enter a line: ");
			String str = scan.nextLine();
			scan.close();
        	FileWriter  inFile = new FileWriter("src/src.java");                	
            inFile.write(str);    
            inFile.close();
		} catch (Exception e) {
			System.out.println(e.toString()); 
		}  
        try {  
            File inFile = new File("src/src.java");  
            File outFile = new File("src/dest.java");  
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
	}
	

}
