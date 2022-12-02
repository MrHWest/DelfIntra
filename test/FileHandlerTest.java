package test;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.junit.Test;
import src.FileHandler;

public class FileHandlerTest {
    
    @Test
    public void FileWriteTest() throws IOException {
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
    
}
