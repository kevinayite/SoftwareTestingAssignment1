package DAO;

import static org.junit.Assert.*;

import org.junit.Test;

import org.junit.BeforeClass;
import java.util.List;
import model.Course;

public class CourseTest {

    private static CourseDao courseDao;

    @BeforeClass
    public static void setUp() {
        courseDao = new CourseDao();
    }

    @Test
    public void testRegisterCourse() {
        Course course = new Course();
        course.setCourseId("Cours001");
        course.setCourseName("Test Course");
        course.setLecturerName("Lecturer1");

        String result = courseDao.registerCourse(course);
        assertEquals("Data Saved Successfully", result);
    }

    @Test
    public void testUpdateCourse() {
        Course course = new Course();
        course.setCourseId("Cours001");
        course.setCourseName("Course");
        course.setLecturerName("Lecturer2");

        String result = courseDao.updateCourse(course);
        assertEquals("Data Updated Successfully", result);
    }

    @Test
    public void testDeleteCourse() {
        Course course = new Course();
        course.setCourseId("Cours001");

        String result = courseDao.deleteCourse(course);
        assertEquals("Data Deleted Successfully", result);
    }

    @Test
    public void testAllCourses() {
        List<Course> courseList = courseDao.allCourses();
        assertNotNull(courseList);
        assertTrue(courseList.size() > 0);
    }
}

