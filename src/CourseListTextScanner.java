import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;




/**
 * This class is for scanning the text document comprised of courses. This list was provided by
 * the customer.
 */
public class CourseListTextScanner {

    public static void RemovePageNumber(){

        try {
            File fileIn = new File("CourseListText/CourseDescriptions.txt");

            Scanner scanner = new Scanner(fileIn);

            scanner.nextLine();                                     //removes the first line of the file
            for(int i=0; i < 20; i++){
                System.out.println(scanner.nextLine() + "\n");
            }
        }
        catch (FileNotFoundException e){

            System.out.println("File Not Found!");
        }
        File file = new File("ParsedCourseList.txt");



    }

    public static void main(String[] args){

        RemovePageNumber();


    }



}
