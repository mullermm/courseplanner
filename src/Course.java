/**
 * This class represents a course at Augsburg University. It's attributes describe one of these courses.
 */
public class Course {

    String name;                    //Name of course
    int credits;                    //Number of credits for the course
    String[] prereq;                //List of prereqs for the course
    String coursenumber;            //Course number
    Enum OfferedIn;                   //Semesters class is offered- Spring Summer Fall...
    String description;             //Description of the course
    String department;              //What department the course is a part of




    /**
     * These enums are used by the Course object to specify what semeseters the course is offered.
     */
    private enum OfferedIn {

        SPRING, SUMMER, FALL, ALL, FALLANDSPRING

    }


}
