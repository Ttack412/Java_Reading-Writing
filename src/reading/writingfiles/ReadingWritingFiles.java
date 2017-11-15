
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

    public static void main(String[] args) {

        ArrayList<String> myNames = new ArrayList<>();
        
        Reading(myNames);
        Writing(myNames);
           
    }
    
    public static void Reading(ArrayList<String> myNames)
    {
        try(BufferedReader myReader = new BufferedReader(new FileReader(new File("names/BoyNames.txt"))))
        {
            while(myReader.readLine() != null)
            {
                myNames.add(myReader.readLine());
            }
        }
        catch(EOFException eofe)
        {
            System.out.println("Out of lines to read");
            System.exit(0);
        }
        catch(IOException ioe)
        {
            System.out.println("Error finding file");
            System.exit(0);
        }
        catch(Exception e)
        {
            System.out.println("other error");
            System.exit(0);
        }
    }
    
    public static void Writing(ArrayList<String> myNames)
    {
        Collections.sort(myNames);
        
        try(PrintWriter myWriter = new PrintWriter(new BufferedWriter(new FileWriter("names/SortedNames.txt"))))
        {
            for(int i = 0; i < myNames.size(); i++)
            {
                myWriter.println(myNames.get(i));
            }
        }
        catch(IOException ioe)
        {
            System.out.println("Error finding file");
            System.exit(0);
        }
        catch(Exception e)
        {
            System.out.println("other error");
            System.exit(0);
        }
    }
    
    
}
