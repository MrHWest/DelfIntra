package src;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {

	/**
	 * Reads file and outputs a string for each line read
	 * @param filePath Path to the file which is to be read. Extension included.
	 * @return Array of strings, in which each element corresponds to a line in the file
	 * @throws FileNotFoundException
	 */
	public static String[] ReadFile(String filePath) throws FileNotFoundException {
		File f = new File(filePath);

		// If file doesn't exist, return empty array
		if(!f.exists()) {
			return new String[0];
		}

		// File exists. Time to read it
		Scanner scan = new Scanner(f);
		scan.useDelimiter("\n");

		ArrayList<String> result = new ArrayList<String>();

		while(scan.hasNext()) {
			result.add(scan.next());
		}

		scan.close();
		return result.toArray(new String[result.size()]);
	}

	/**
	 * Writes an array of string to a file. Each element is printed in its own line.
	 * @param filePath Path to file which is to be modified/added
	 * @param content The array of strings to write
	 * @throws IOException
	 */
	public static void WriteToFile(String filePath, String[] content) throws IOException {
		/*
		Open given file and prepare for writing
		*/ 

		File f = new File(filePath);

		// Make sure we have an empty file to work with
		if(f.exists()) {
			f.delete();
		}
		f.createNewFile();

		FileOutputStream fs = new FileOutputStream(f);
		OutputStreamWriter osw = new OutputStreamWriter(fs);

		/*
		Start writing all elements of "content" to file.
		Each element written in separate line
		*/ 

		for (int i = 0; i < content.length; i++) {
			osw.write(content[i]);
			if(i < content.length-1) {
				osw.write("\n"); // To prevent adding new-line for last element
			}
		}

		osw.close();
	}
}