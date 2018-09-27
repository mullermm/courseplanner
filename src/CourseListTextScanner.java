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

///-----------------added this chuck to read in words. ill edit it to look at lines(tomorow)

     HashMap wordMap = new HashMap();  // Map of word --> # of occurrences
        int totNumofWords = 0;//counts total num of words
        //scanner object is instantiated with name Cursor
        Scanner Cursor = new Scanner(new File("Sample.txt")); //file(Sample.txt) is opened to be read

        while (Cursor.hasNext()) //keep reading until cursor has reached end of document
        {
            String Word = Cursor.next();//capturing the next word in text
            if(wordMap.containsKey(Word)) //if this is another instance of the word we have encountered
             {
                // if word instance exists --> increment the number of appearances +1
                Integer count = (Integer)wordMap.get(Word);
                wordMap.put(Word, new Integer(count.intValue() + 1));
             } 
            else//New word at last -> add to the Map and make occurence=1  
                wordMap.put(Word, new Integer(1));
        totNumofWords++;            
        }


    }



}
