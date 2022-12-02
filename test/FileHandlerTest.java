package test;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import org.junit.Test;
import src.FileHandler;

public class FileHandlerTest {
    
    @Test
    public void WriteToFileTest() throws IOException {
		String[] sList = {"hej", "med", "dig"};
		FileHandler.WriteToFile("./test.txt", sList);

        File f = new File("./test.txt");

        // Check if file exists
        assert(f.exists());
        
        String contents = "";
        Scanner scan = new Scanner(f);
        while(scan.hasNext()) {
            contents += scan.next();
        }

        scan.close();
        f.delete();
        
        // Check if file content matches the expected
        assert(contents.equals("hejmeddig"));
    }
    
    @Test
    public void ReadFileTest() throws IOException {
        String[] in = {"this", "is", "a", "test"};
        FileHandler.WriteToFile("./test.txt", in);

        String[] result = FileHandler.ReadFile("./test.txt");

        assert(result.length == 4);
        assert(result[0].equals("this"));
        assert(result[1].equals("is"));
        assert(result[2].equals("a"));
        assert(result[3].equals("test"));

        (new File("./test.txt")).delete();
    }
}
