package course;

import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class CourseListTextScannerTest {


    /**
     * This test is used to verify that a courseList
     */
    @Test
    public void testCourseListConstructor(){

        CourseList test = new CourseList();

        ArrayList<Course> expected = new ArrayList<Course>();
        ArrayList<Course> actual = test.getListOfCourses();

        assertEquals(expected, actual);

    }

    @Test
    public void testString(){

        String expected = "hello";
        String actual = "hello";

        assertEquals(expected, actual);

    }


}
