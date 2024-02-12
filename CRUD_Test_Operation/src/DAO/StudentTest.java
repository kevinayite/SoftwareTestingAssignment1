package DAO;
import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;
import org.junit.BeforeClass;
import model.Student;

public class StudentTest {

    private static StudentDao studentDao;

    @BeforeClass
    public static void setUp() {
        studentDao = new StudentDao();
    }

    @Test
    public void testRegisterStudent() {
        Student theStudent = new Student();
        theStudent.setStudentId("1");
        theStudent.setFirstName("Kevin");
        theStudent.setLastName("Ayite");

        String result = studentDao.registerStudent(theStudent);
        assertEquals("Data Saved Successfully", result);
    }

    @Test
    public void testUpdateStudent() {
        Student theStudent = new Student();
        theStudent.setStudentId("1");
        theStudent.setFirstName("Sister");
        theStudent.setLastName("Lea");

        String result = studentDao.updateStudent(theStudent);
        assertEquals("Data Updated Successfully", result);
    }

    @Test
    public void testDeleteStudent() {
        Student theStudent = new Student();
        theStudent.setStudentId("1");

        String result = studentDao.deleteStudent(theStudent);
        assertEquals("Data Deleted Successfully", result);
    }

    @Test
    public void testAllStudents() {
        List<Student> studentList = studentDao.allStudents();
        assertNotNull(studentList);
        assertTrue(studentList.size() > 0);
    }
}
