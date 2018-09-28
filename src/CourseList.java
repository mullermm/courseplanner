import java.util.ArrayList;

public class CourseList {

    ArrayList<Course> listOfCourses;


    /**Constructors */
    public CourseList(){

    }

    /**Getters*/
    public ArrayList<Course> getListOfCourses(){
        return this.listOfCourses;
    }

    /**
     * This method adds a course to the array list "listOfCourses"
     * @param course course to add to list of courses
     */
    public void addToCourses(Course course){
        this.listOfCourses.add(course);
    }

}
