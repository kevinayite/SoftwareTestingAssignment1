package view;

import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.*;

import DAO.CourseDao;
import DAO.StudentDao;
import model.Course;
import model.Student;

public class UI {
	
	public static void main(String[] args) {
		String studentId;
		String firstName;
		String lastName;
		
		String courseId;
		String courseName;
		String lecturerName;
		boolean condition  = true;
		
		Student theStudent = new Student();
		Course theCourse = new Course();
		StudentDao dao = new StudentDao();
		CourseDao courDao = new CourseDao();
		while(condition) {
			System.out.println("=========================================");
			System.out.println("            Students Management          ");
			System.out.println("=========================================");
			System.out.println("1. Register a Student");
			System.out.println("2. Update Student");
			System.out.println("3. Delete a Student");
			System.out.println("4. Display all Students");
			System.out.println("                                         ");
			System.out.println("=========================================");
			System.out.println("            Course Management          ");
			System.out.println("=========================================");
			System.out.println("5. Register a Course");
			System.out.println("6. Update Course");
			System.out.println("7. Delete a Course");
			System.out.println("8. Display all Courses");
			System.out.println("Press 0 to exit");
			System.out.println("                                         ");
			System.out.println("                                         ");
			System.out.println("=========================================");
			System.out.print("Choose an option:\t");
			Scanner sc = new Scanner(System.in);
			int option = sc.nextInt();
			
			
			
			switch(option) {
			case 1:
				System.out.print("Enter Student ID: ");
                studentId = sc.next();
                System.out.print("Enter student last name: ");
                lastName = sc.next();
                System.out.print("Enter student last name: ");
                firstName = sc.next();
                // create model object

                theStudent.setStudentId(studentId);
                theStudent.setLastName(lastName);
                theStudent.setFirstName(firstName);
                
                // create dao object

                String result =  dao.registerStudent(theStudent);
                System.out.println(result);
                System.out.println("Do your wish to continue enter Yes or No");
                String answer = sc.next();
                if(answer.equalsIgnoreCase("yes")){
                    condition = true;
                }else{
                    System.out.println("Thank you for using the system");
                    condition = false;
                }
				break;
			case 2:
				System.out.print("Enter the Student ID : ");
                studentId = sc.next();
                System.out.print("Enter student last name: ");
                lastName = sc.next();
                System.out.print("Enter student last name: ");
                firstName = sc.next();
                // create model object

                theStudent.setStudentId(studentId);
                theStudent.setLastName(lastName);
                theStudent.setFirstName(firstName);
                
                // create dao object

                String result1 =  dao.updateStudent(theStudent);
                System.out.println(result1);
                System.out.println("Do your wish to continue enter Yes or No");
                String answer1 = sc.next();
                if(answer1.equalsIgnoreCase("yes")){
                    condition = true;
                }else{
                    System.out.println("Thank you for using the system");
                    condition = false;
                }
				break;
			case 3:
				System.out.println("Enter Student ID: ");
                studentId = sc.next();
                theStudent.setStudentId(studentId);
                String feedBack = dao.deleteStudent(theStudent);
                System.out.println(feedBack);
                System.out.println("Do your wish to continue enter Yes or No");
                answer = sc.next();
                if(answer.equalsIgnoreCase("yes")){
                    condition = true;
                }else{
                    System.out.println("Thank you for using the system");
                    condition = false;
                }
				break;
				
			case 4:
				StudentDao stDao = new StudentDao();
				List<Student> students =  stDao.allStudents();
                int counter =0;
                if(students!=null) {
                	for(Student studentObj: students){
                        counter ++;
                        System.out.println("Student "+counter);
                        System.out.println("---------");
                        System.out.println("Student ID: "+studentObj.getStudentId());
                        System.out.println("Last Name  : "+studentObj.getLastName());
                        System.out.println("First Name  : "+studentObj.getFirstName());
                    }
                }
            	else{
                System.out.println("No Data Found!");
            	}
				break;
				
			case 5:
				System.out.print("Enter Course ID: ");
                courseId = sc.next();
                System.out.print("Enter Course's name: ");
                courseName = sc.next();
                System.out.print("Enter the lecturer's name: ");
//                lecturerName = reader.readLine();
                lecturerName = sc.next();
                // create model object

                theCourse.setCourseId(courseId);
                theCourse.setCourseName(courseName);
                theCourse.setLecturerName(lecturerName);
                
                // create dao object

                String resultat =  courDao.registerCourse(theCourse);
                System.out.println(resultat);
                System.out.println("Do your wish to continue enter Yes or No\t");
                String reponse = sc.next();
                if(reponse.equalsIgnoreCase("yes")){
                    condition = true;
                }else{
                    System.out.println("Thank you for using the system");
                    condition = false;
                }

				break;
			case 6:
				System.out.print("Enter Course ID: ");
                courseId = sc.next();
                System.out.print("Enter Course's name: ");
                courseName = sc.next();
                System.out.print("Enter the lecturer's name: ");
//                lecturerName = reader.readLine();
                lecturerName = sc.next();
                // create model object

                theCourse.setCourseId(courseId);
                theCourse.setCourseName(courseName);
                theCourse.setLecturerName(lecturerName);
                
                // create dao object

                String resultat1 =  courDao.updateCourse(theCourse);
                System.out.println(resultat1);
                System.out.println("Do your wish to continue enter Yes or No\t");
                String reponse1 = sc.next();
                if(reponse1.equalsIgnoreCase("yes")){
                    condition = true;
                }else{
                    System.out.println("Thank you for using the system");
                    condition = false;
                }


				break;
			case 7:
				System.out.println("Enter Course ID to be deleted: ");
                courseId = sc.next();
                theCourse.setCourseId(courseId);
                String feedBack1 = courDao.deleteCourse(theCourse);
                System.out.println(feedBack1);
                System.out.println("Do your wish to continue enter Yes or No");
                answer = sc.next();
                if(answer.equalsIgnoreCase("yes")){
                    condition = true;
                }else{
                    System.out.println("Thank you for using the system");
                    condition = false;
                }
				break;
			case 8:
				CourseDao coursDao = new CourseDao();
				List<Course> courses =  coursDao.allCourses();
                int counter1 =0;
                if(courses!=null) {
                	for(Course courseObj: courses){
                        counter1 ++;
                        System.out.println("Course "+counter1);
                        System.out.println("---------");
                        System.out.println("Course ID: "+courseObj.getCourseId());
                        System.out.println("Course Name  : "+courseObj.getCourseName());
                        System.out.println("Lecturer Name  : "+courseObj.getLecturerName());
                    }
                }
            	else{
                System.out.println("No Data Found!");
            	}
				break;
			case 0:
				System.out.println("Thank you for using the system");
            	System.exit(0);
            	break;
            default:
                System.out.println("....");
			
			
				
			}
			
			
		}
		
	}

}
