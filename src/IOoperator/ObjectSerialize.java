package IOoperator;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;



public class ObjectSerialize {

	private List<Student> student;
	
	private File destFile;
	
	public ObjectSerialize(){
		
		File file = new File("C:/Users/Administrator/Desktop/list.txt");
	
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
		sortByStudentID(this.student);
	}
	
	//��ѧ������
	private void sortByStudentID(List<Student> student) {
		Collections.sort(student, new Comparator<Student>() {
			@Override
			public int compare(Student arg0, Student arg1) {
				// TODO Auto-generated method stub
				if (arg0.getStudentID() > arg1.getStudentID()) {
					return 1;
				} else if (arg0.getStudentID() == arg1.getStudentID()) {
					return 0;
				} else {
					return -1;
				}
			}
		});
	}

	//ʹ��ObjectOutputStream���Ѿ������ѧ����Ϣд�����ļ���student.bin���С�
	public void write(){ 
		try {
			FileOutputStream foutS = new FileOutputStream(destFile);
			ObjectOutputStream OoutS = new ObjectOutputStream(foutS);
			Iterator<Student> it = this.student.iterator();
			while (it.hasNext()) {
				System.out.println(it.next().toString());
			}
			while (it.hasNext()) {
				OoutS.writeObject(it.next());
			}
			OoutS.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("FileStreamsTest: " + e);
		}
	}
	
	//ʹ��ObjectInputStream����student.bin���еĶ�����Ϣ���������ʾ�ڿ���̨�С�
	public void read () {
		List<Student> out = new ArrayList<Student>();
		try {
			FileInputStream finS = new FileInputStream(destFile);
			ObjectInputStream OinS = new ObjectInputStream(finS);
			Student st = null;
			System.out.println("ѧ��" + "\t\t����" + "\t�Ա�");
			while (true) { //ֱ����while(true),�ö�ȡ����һֱ����  
				st = (Student) OinS.readObject(); //ѭ����������   
			    System.out.println(st.getStudentID() + "\t" + st.getName() + "\t" + st.getSex());   
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("FileStreamsTest: " + e);
		} 
	}
	
}