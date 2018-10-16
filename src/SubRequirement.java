import java.util.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.io.*;
import java.util.Scanner;
import java.util.regex.*;

public class SubRequirement {

    int needToTake;
    ArrayList<Course> courseOption;
    int amountTaken;


    public static void ScanCourseList(CourseList courseList) {


        Scanner scan = new Scanner(System.in);
        /** This is the course list provided by the customer*/
        File fileIn = new File("CourseListText/CourseDescriptions.txt");

        String temp = scan.nextLine();

        if (temp.contains("[A-Z]{3} [0-9]{3}")) {

//            MyMajorCourse [] = temp;

        }

    }

    public int getNeedToTake() {
        return needToTake;
    }

    public ArrayList<Course> getCourseOption() {
        return courseOption;
    }

    public int getAmountTaken() {
        return amountTaken;
    }

    public void setNeedToTake(int needToTake) {
        this.needToTake = needToTake;
    }

    public void setCourseOption(ArrayList<Course> courseOption) {
        this.courseOption = courseOption;
    }

    public void setAmountTaken(int amountTaken) {
        this.amountTaken = amountTaken;
    }
}