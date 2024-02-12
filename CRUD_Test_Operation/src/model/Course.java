package model;

public class Course {
	private String courseId;
	private String courseName;
	private String lecturerName;
	public Course() {
		super();
	}
	public Course(String courseId, String courseName, String lecturerName) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.lecturerName = lecturerName;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getLecturerName() {
		return lecturerName;
	}
	public void setLecturerName(String lecturerName) {
		this.lecturerName = lecturerName;
	}
	
	
}
