import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class FileHandler {

	public static String ReadFile() {
		// TODO - implement FileHandler.ReadFile
		throw new UnsupportedOperationException();
	}

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