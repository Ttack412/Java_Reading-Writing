
package reading.writingfiles;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class ReadingWritingFiles {

    //main method creates an ArryaList and calls the other methods
    public static void main(String[] args) {

        ArrayList<String> myNames = new ArrayList<>();
        
        Reading(myNames);
        Writing(myNames);
           
    }
    
    public static void Reading(ArrayList<String> myNames)
    {
        //finds the file through a file reader then gets put into a buffered reader for faster reading
        try(BufferedReader myReader = new BufferedReader(new FileReader(new File("names/BoyNames.txt"))))
        {
            //reads the file while the lines read aren't null
            while(myReader.readLine() != null)
            {
                myNames.add(myReader.readLine());
            }
        }
        //catch : no more lines to read
        catch(EOFException eofe)
        {
            System.out.println("Out of lines to read");
            System.exit(0);
        }
        //catch : couldn't find the file
        catch(IOException ioe)
        {
            System.out.println("Error finding file");
            System.exit(0);
        }
        //catch : failsafe incase anyhitng else happens
        catch(Exception e)
        {
            System.out.println("other error");
            System.exit(0);
        }
    }
    
    public static void Writing(ArrayList<String> myNames)
    {
        //sorts the names
        Collections.sort(myNames);
        
        //writes the names to through file writer with a bufferedwriter and a print writer
        try(PrintWriter myWriter = new PrintWriter(new BufferedWriter(new FileWriter("names/SortedNames.txt"))))
        {
            //prints each name
            for(int i = 0; i < myNames.size(); i++)
            {
                myWriter.println(myNames.get(i));
            }
        }
        // catch : couldn't find file
        catch(IOException ioe)
        {
            System.out.println("Error finding file");
            System.exit(0);
        }
        //catch : failsafe incase anyhitng else happens
        catch(Exception e)
        {
            System.out.println("other error");
            System.exit(0);
        }
    }
    
    
}
