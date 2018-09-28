import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;




/**
 * This class is for scanning the text document comprised of courses. This list was provided by
 * the customer. It contains methods that are helpful to scanning the Course list provided by the customer.
 */
public class CourseListTextScanner {

    /**
     * This main is used to debug and test the methods of this class
     * */
    public static void main(String[] args){

        CourseList courseList = new CourseList();
        ScanCourseList(courseList);

    }

    /**
     * This method is used to scan CourseDescriptions.txt, remove page numbers, read in the text, create course
     * objects, and create a CourseList object. This CourseList object will contain every course offered at
     * Augsburg.*/
    public static CourseList ScanCourseList(CourseList courseList){


        /** This is the course list provided by the customer*/
        File fileIn = new File("CourseListText/CourseDescriptions.txt");

        /** This is the temp file we will use to modify the course list from the customer.
         * We need a temp because we will be reading lines from the customer text and then
         * create a temp using the text we want to keep. Eventually, this Temp.txt will
         * be written back to CourseDescriptions.txt*/
        File tempFile = new File("CourseListText/Temp.txt");

        //Create the new file and verify we are not writing over an already existing Temp.txt
        try {
            tempFile.createNewFile();
        }
        catch(IOException e) {
            System.out.println("File already exists.");
        }

        /** Make sure the scanner actually finds the file and that*/
        try {

            Scanner scanner = new Scanner(fileIn);      //Our scanner to read in the file from the customer
            String temp;                                //Will store the lines we are reading in from scanner

            scanner.nextLine();                         //Eats the first line of the text file - We don't need it

            RemovePageNumber(scanner, fileIn, tempFile); //Removes the page number from CourseDescriptions.txt


        }
        catch (FileNotFoundException e){
            System.out.println("Input File Not Found! Expected to find CourseDescriptions.txt");
        }
        catch (IOException e){
            System.out.println("Error opening the temp file CourseListText/Temp.txt");
        }

        File file = new File("ParsedCourseList.txt");


        return courseList;

    }

    public static void AddCoursesToCourseList(Scanner scanner, File fileIn, CourseList courseList){

        Course course = new Course();


    }

    /**
     * This method is used to remove page numbers from CourseDescriptions.txt
     * @param scanner       Scanner built from CourseDescriptions.txt
     * @param fileIn        File object containing the path to CourseDesctiptions.txt
     * @param tempFile      File object containing the path to Temp.txt
     * @throws IOException  Is thrown if scanner and files have errors finding files. Caught in method that calls this.
     */
    public static void RemovePageNumber(Scanner scanner, File fileIn, File tempFile) throws IOException{

        FileWriter fw = new FileWriter(tempFile);
        BufferedWriter br = new BufferedWriter(fw);         //This will be used to write the text to a temp
        String temp;                                        //This will hold the current line being read in by scanner

        fw.flush();                                         //Makes sure tempFile is flushed

        while(scanner.hasNext()) {                          //While the EoF of fileIn has not been reached
            temp = scanner.nextLine();                      //Store next line into temp
            if (isInteger(temp)) {                          //If the line is an integer do nothing and dont copy it
                //Don't copy line to temp file
            } else {                                        //Write the line to temp.txt and append a new line
                br.write(temp);
                br.write("\n");
            }
        }

        br.close();                                         //Close the writer so the buffer clears to temp.txt
        CopyFile(tempFile, fileIn);                         //Copies contents of temp.txt back into original file
        tempFile.delete();                                  //Deletes the temp file



    }


    public static void RemoveDepartmentHeader(Scanner scanner, File fileIn, File tempFile) throws IOException{

        FileWriter fw = new FileWriter(tempFile);
        BufferedWriter br = new BufferedWriter(fw);         //This will be used to write the text to a temp
        String temp;                                        //This will hold the current line being read in by scanner

        fw.flush();                                         //Makes sure tempFile is flushed

        br.close();                                         //Close the writer so the buffer clears to temp.txt
        CopyFile(tempFile, fileIn);                         //Copies contents of temp.txt back into original file
        tempFile.delete();                                  //Deletes the temp file



    }

    /**
     *This method takes two files and copies ton contents of the inFile to the outFile.
     *
     * @author https://www.tutorialspoint.com/javaexamples/file_copy.htm
     * */
    public static void CopyFile(File inFile, File outFile) {
        FileInputStream ins = null;
        FileOutputStream outs = null;
        try {
            ins = new FileInputStream(inFile);
            outs = new FileOutputStream(outFile);
            byte[] buffer = new byte[1024];
            int length;

            while ((length = ins.read(buffer)) > 0) {
                outs.write(buffer, 0, length);
            }
            ins.close();
            outs.close();
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }



    /**
     * */
    public static void AddCoursesToList(Scanner scanner, File fileIn){

        String temp;

        scanner.nextLine();         //Eats the first line of the text file - We don't need it

        temp = scanner.nextLine();  //read in the first line

        /** If the line has a "-" in it, the line is not part of a Course*/
        if(temp.contains("-")){
            temp = scanner.nextLine();
        }

    }

    public static void BuildCourse(Scanner scanner, File fileIn){

    }

    /**
     * This method will check to see if a string is an integer. If so, it returns true, else it returns false
     */
    public static boolean isInteger(String s) {
        boolean isValidInteger = false;
        try {
            Integer.parseInt(s);
            isValidInteger = true;
        }
        catch (NumberFormatException ex)
        {
            //Is not an integer
        }
        return isValidInteger;
    }

}
