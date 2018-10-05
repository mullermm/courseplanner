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


    /**@author Beteab Gebru
     * This method takes in a string(name) of a course to search and retuns the object found
     * @param NameOfCoursetoSearch: string name of course will be passed to search list of courses
     *@return course object from arraylist of courses if found NUll object is returned otherwise
     */
    public Course SearchbyCoureName(String NameOfCoursetoSearch) {

        boolean Found = false;
        int index = 0;
        int x = 0;

        while(!Found || index < listOfCourses.size()){

            if (listOfCourses.get(x).getName() == NameOfCoursetoSearch){
                Found = true;
            }
            index++;
        }
        if(found)
            return listOfCourses.get(index);//returns a course object found
        else
            return Null;//null

    }

}


