package IOoperator;

import java.io.Serializable;

public class Student implements Serializable ,Comparable<Student>{
	private static final long serialVersionUID = 1L;  
	private Long studentID;
	private String name;
	private char sex;
	public Student(long id,String n,char s){
		this.studentID = id;
		this.name = n;
		this.sex = s;
	}
	public Long getStudentID() {
		return studentID;
	}
	public void setStudentID(Long studentID) {
		this.studentID = studentID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public char getSex() {
		return sex;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}
	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return this.getStudentID().compareTo(o.getStudentID());
	}
	@Override
	public String toString() {
		return "Student [studentID=" + studentID + ", name=" + name + ", sex="
				+ sex + "]";
	}
	
	
}
