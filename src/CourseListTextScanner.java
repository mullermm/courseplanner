import javax.sound.midi.SysexMessage;
import java.io.*;
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

        /**Create the new file and verify we are not writing over an already existing Temp.txt*/
        try {
            tempFile.createNewFile();
        }
        catch(IOException e) {
            System.out.println("File already exists.");
        }

        /** Make sure the scanner actually finds the file and that*/
        try {


            /* The next three lines are used to manipulate the text file CourseDescriptions.txt. First, we remove
             * the page numbers from the file. Next, we remove any department name "headers" from the file. Last,
             * we take the CourseListDescriptions.txt file and create our list of courses inside our course list
             * object. */

            Scanner scanner = new Scanner(fileIn);      //Our scanner to read in the file from the customer
            CreateDeptList(scanner, courseList);        //Creates Department List in the Course List Object

            scanner = new Scanner(fileIn);              //Our scanner to read in the file from the customer
            RemovePageNumber(scanner, fileIn, tempFile);//Removes the page number from the text file

            scanner = new Scanner(fileIn);
            AddListOfCourse(scanner, courseList);       //Adds listOfCouses to course list object
            System.out.println("3");




        }
        catch (FileNotFoundException e){
            System.out.println("Input File Not Found! Expected to find CourseDescriptions.txt");
        }
        catch (IOException e){
            System.out.println("Error opening the temp file CourseListText/Temp.txt");
        }

        return courseList;

    }

    /**
     * This method takes a course list object and populates the listOfCourses.
     *
     * @param scanner scanner containing file of course descriptions
     * @param courseList Course List to have listOfCourses populated
     * @return CourseList that has had listOfCourses populated
     */
    public static CourseList AddListOfCourse(Scanner scanner, CourseList courseList){

        String headerRegex = "([A-Z]{3})(\\s)(–|-).*";
        String creditRegex = "";
        String descriptionRegex = "$\\.";

        scanner.nextLine();                                 //Eats the first line of the file. We dont need it


        boolean matches;
        String temp = "";                                   //This will hold the current line being read in by scanner

        while(scanner.hasNext()) {                          //While the EoF of fileIn has not been reached
            temp = scanner.nextLine();                      //read in the next line
            if(temp.matches(headerRegex)){                  //If the next line is a department header
                temp = scanner.nextLine();                  //read in the next line

            }

            Course course = new Course();                   //Make a new course to add to courseList's list of coures
            course.coursenumber = temp;                     //assign the course number
            temp = scanner.nextLine();                      //Gets the course name
            course.name = temp;                             //assign the course name
            temp = scanner.nextLine();                      //gets the course credits
            course.credits = Integer.parseInt(temp.substring(0,1)); //Stores credit amount
            temp = scanner.nextLine();

            int count = 0;

            while(temp.endsWith(".") == false){             //The course description ends in a . Keep apending until
                temp += scanner.nextLine();                 //we find a .

            }
            course.description = temp;                      //Save description to course

            temp = scanner.nextLine();                      //get the core curriculum
            course.coreCurriculum = temp;                   //Store the core curriculum

            temp = scanner.nextLine();                      //Get the next line

            if(temp.endsWith("e")){
                String[] prereq= new String[1];
                prereq[0] = temp;
                course.prereq = prereq;
            }
            else{


                //KEEP WORKING HERE
            }




        }




       return courseList;
    }

    /**
     * This method takes the CourseList.txt file and looks for any line containing a "-". This line has the name
     * of a department at Augsburg, and this method takes that department name, stores it into the listOfDepartments
     * of the CourseList sent to this method.
     *
     * @param scanner Scanner of infile
     * @param courseList CourseList to have listOfDepartments updated for
     * @throws IOException Throws if the infile is not found
     */
    public static void CreateDeptList(Scanner scanner, CourseList courseList) throws IOException{

        String regex = "([A-Z]{3})(\\s)(–|-).*";

        boolean matches;                                    //This wil become true if the regex is a match
        String temp = "";                                   //This will hold the current line being read in by scanner

        while(scanner.hasNext()) {                          //While the EoF of fileIn has not been reached
            temp = scanner.nextLine();                      //Store next line into temp
            matches = temp.matches(regex);                  //True if next line observes regex rule

            if (matches) {                                  //If the line is an integer do nothing and dont copy it
                courseList.addToDepartment(temp);           //adding Course to temp

            }
        }
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

    /**
     * This method takes the course list text document and removes the department header. This header has a - in it,
     * which makes it easy to find and remove.
     *
     * @param scanner scanner of our courselist text file
     * @param fileIn  file object of course list text file being read in
     * @param tempFile file object of our temp file for manipulating text
     * @throws IOException If the temp file is not found, we throw this exception to where it was called from
     */
    public static void RemoveDepartmentHeader(Scanner scanner, File fileIn, File tempFile) throws IOException{
        FileWriter fw = new FileWriter(tempFile);
        BufferedWriter br = new BufferedWriter(fw);         //This will be used to write the text to a temp
        String temp;                                        //This will hold the current line being read in by scanner
        fw.flush();                                         //Makes sure tempFile is flushed

        while(scanner.hasNext()) {                          //While the EoF of fileIn has not been reached
            temp = scanner.nextLine();                      //Store next line into temp
            if (temp.contains("-")) {                       //If the line is an integer do nothing and dont copy it
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
     * This method will check to see if a string is an integer. If so, it returns true, else it returns false
     *
     * @author Oscar Lopez - https://stackoverflow.com/questions/8336607/how-to-check-if-the-value-is-integer-in-java
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
