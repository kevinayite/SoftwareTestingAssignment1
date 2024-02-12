package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Student;

public class StudentDao {
	private String dbUrl="jdbc:postgresql://localhost:5432/CRUD_Student";
	   private String username="postgres";
	   private String passwd="java123";
	public StudentDao() {
		super();
		try {
			Class.forName("org.postgresql.Driver");
		}catch (ClassNotFoundException e) {
			// TODO: handle exception
			System.out.println("No driver found");
			e.printStackTrace();
		}
	}
	   public String registerStudent (Student studentObj) {
		   try {
			   Connection con = DriverManager.getConnection(dbUrl, username, passwd);
			   // USing Prepare Statement
			   String sql ="insert into student (student_id,last_name,first_name) values(?,?,?)";
	           PreparedStatement pst = con.prepareStatement(sql);
	           pst.setString(1, studentObj.getStudentId());
	           pst.setString(2, studentObj.getLastName());
	           pst.setString(3, studentObj.getFirstName());
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
	   public String updateStudent (Student studentObj) {
		   try {
			   Connection con = DriverManager.getConnection(dbUrl, username, passwd);
			   // USing Prepare Statement
			   String sql ="update student set last_name=?,first_name=? where  student_id=?";

	           PreparedStatement pst = con.prepareStatement(sql);
	           pst.setString(3, studentObj.getStudentId());
	           pst.setString(1, studentObj.getLastName());
	           pst.setString(2, studentObj.getFirstName());
	           int rowsAffected = pst.executeUpdate();
	           con.close();
	           if(rowsAffected>=1){

	               return "Data Updated Successfully";
	           }else{

	               return "Data Not Updated";
	           }
			   
		   }catch (Exception ex) {
			   ex.printStackTrace();
			   
			// TODO: handle exception
		}
		   return "Server Error";
		   
	   }
	   public String deleteStudent (Student studentObj) {
		   try {
			   Connection con = DriverManager.getConnection(dbUrl, username, passwd);
			   // USing Prepare Statement
			   String sql ="delete from student where student_id=?";

	           PreparedStatement pst = con.prepareStatement(sql);
	           pst.setString(1, studentObj.getStudentId());
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
	   
	   public List<Student> allStudents(){
	       try{
	           Connection con = DriverManager.getConnection(dbUrl, username, passwd);
	           String sql="select * from student";
	           PreparedStatement pst = con.prepareStatement(sql);
	           ResultSet result = pst.executeQuery();
	           List<Student> studentList = new ArrayList<>();
	           while(result.next()){
	               Student theStudent = new Student();
	               theStudent.setStudentId(result.getString("student_id"));
	               theStudent.setLastName(result.getString("last_name"));
	               theStudent.setFirstName(result.getString("first_name"));

	               studentList.add(theStudent);
	           }
	           con.close();
	           return studentList;
	       }catch(Exception ex){
	           ex.printStackTrace();
	           return null;
	       }
	       
	       
	   }

}
