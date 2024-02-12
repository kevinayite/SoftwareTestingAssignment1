package model;

public class Student {
	
	private String studentId;
	private String lastName;
	private String firstName;
	public Student() {
		super();
	}
	public Student(String studentId, String lastName, String firstName) {
		super();
		this.studentId = studentId;
		this.lastName = lastName;
		this.firstName = firstName;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	

}
