import java.util.ArrayList;

public class CourseList {

    ArrayList<Course> listOfCourses;
    ArrayList<String> listOfDepartmentNames;
    /**
     * This methos is used for testing a debugging the CourseList class
     * @param args
     */
    public static void main(String[] args){

        CourseList courseList = new CourseList();
        CourseListTextScanner.ScanCourseList(courseList);




    }

    /**Constructors */
    public CourseList(){

    }

    /**Getters*/
    public ArrayList<Course> getListOfCourses(){
        return this.listOfCourses;
    }

    public ArrayList<String> getListOfDepNames(){
        return this.listOfDepartmentNames;
    }



    /**
     * This method adds a course to the array list "listOfCourses"
     * @param course course to add to list of courses
     */
    public void addToCourses(Course course){
        this.listOfCourses.add(course);
    }
    /**
     * This method adds a course to the array list "listOfDepartments"
     * @param department department to add to list of department
     */
    public void addToDepartment(String department){ this.listOfDepartmentNames.add(department); }
<<<<<<< HEAD
    
=======


>>>>>>> master
    /**@author Beteab Gebru
     * This method takes in a string(name) of a course to search and retuns the object found
     * @param NameOfCoursetoSearch to add to list of department
     *
     */
    public Course SearchbyCoureName(String NameOfCoursetoSearch) {

        boolean Found = false;

        int index = 0;
        int x = 0;

        while(!Found || x == listOfCourses.size()) {

            for (x = 0; x < listOfCourses.size(); x++) {
                if (listOfCourses.get(x).getName() == NameOfCoursetoSearch){
                    Found = true;
                    index=x;
                }
            }

        }
<<<<<<< HEAD
        return listOfCourses[index];
    }
<<<<<<< HEAD
     /**@author Beteab Gebru
     * This method takes in a string(coursenumber) of a course to search and retuns the course object found
     * @param NameOfCoursetoSearch to add to list of department
     *
     */
    public Course SearchbyCoureName(String NameOfCoursetoSearch) {
        boolean Found = false;
	
        while(!Found))
        {
            int index =0;
            for (int x=0;x<this.length();x++) {
                if listOfCourses[x].getName() == NameOfCoursetoSearch;{
                    Found = true;
                    index=x;
                }
            }
        }
        return listOfCourses[index];
    }



=======
    

    }
>>>>>>> master
=======

        return listOfCourses.get(index);
    }

>>>>>>> f81cddb1be8905ebf1ee81852f32e1e9421f8228
}


