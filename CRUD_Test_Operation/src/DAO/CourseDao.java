package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Course;




public class CourseDao {
	private String dbUrl="jdbc:postgresql://localhost:5432/CRUD_Student";
	   private String username="postgres";
	   private String passwd="java123";
	public CourseDao() {
		super();
	}
	public String registerCourse (Course courseObj) {
		   try {
			   Connection con = DriverManager.getConnection(dbUrl, username, passwd);
			   // USing Prepare Statement
			   String sql ="insert into course (course_id,course_name,lecturer_name) values(?,?,?)";
	           PreparedStatement pst = con.prepareStatement(sql);
	           pst.setString(1, courseObj.getCourseId());
	           pst.setString(2, courseObj.getCourseName());
	           pst.setString(3, courseObj.getLecturerName());
	           int rowsAffected = pst.executeUpdate();
	           con.close();
	           if(rowsAffected>=1){

	               return "Data Saved Successfully";
	           }else{

	               return "Data Not Saved";
	           }
			   
		   }catch (Exception ex) {
			   ex.printStackTrace();
			   
			// TODO: handle exception
		}
		   return "Server Error";
		   
	   }
	   public String updateCourse (Course courseObj) {
		   try {
			   Connection con = DriverManager.getConnection(dbUrl, username, passwd);
			   // USing Prepare Statement
			   String sql ="update course set course_name=?,lecturer_name=? where  course_id=?";

	           PreparedStatement pst = con.prepareStatement(sql);
	           pst.setString(1, courseObj.getCourseName());
	           pst.setString(2, courseObj.getLecturerName());
	           pst.setString(3, courseObj.getCourseId());
	           int rowsAffected = pst.executeUpdate();
	           con.close();
	           if(rowsAffected>=1){

	               return "Data Updated Successfully";
	           }else{

	               return "Data Not Saved";
	           }
			   
		   }catch (Exception ex) {
			   ex.printStackTrace();
			   
			// TODO: handle exception
		}
		   return "Server Error";
		   
	   }
	   public String deleteCourse (Course courseObj) {
		   try {
			   Connection con = DriverManager.getConnection(dbUrl, username, passwd);
			   // USing Prepare Statement
			   String sql ="delete from course where course_id=?";

	           PreparedStatement pst = con.prepareStatement(sql);
	           pst.setString(1, courseObj.getCourseId());
	           int rowsAffected = pst.executeUpdate();
	           con.close();
	           if(rowsAffected>=1){

	               return "Data Deleted Successfully";
	           }else{

	               return "Data Not Deleted";
	           }
			   
		   }catch (Exception ex) {
			   ex.printStackTrace();
			   
			// TODO: handle exception
		}
		   return "Server Error";
		   
	   }
	   public List<Course> allCourses(){
	       try{
	           Connection con = DriverManager.getConnection(dbUrl, username, passwd);
	           String sql="select * from course";
	           PreparedStatement pst = con.prepareStatement(sql);
	           ResultSet result = pst.executeQuery();
	           List<Course> courseList = new ArrayList<>();
	           while(result.next()){
	               Course theCourse = new Course();
	               theCourse.setCourseId(result.getString("course_id"));
	               theCourse.setCourseName(result.getString("course_name"));
	               theCourse.setLecturerName(result.getString("lecturer_name"));

	               courseList.add(theCourse);
	           }
	           con.close();
	           return courseList;
	       }catch(Exception ex){
	           ex.printStackTrace();
	           return null;
	       }
	       
	       
	   }


}
