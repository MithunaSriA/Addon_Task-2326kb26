package corejava;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Reader {

	    public static void main(String[] args) {

	        try {
	            // 1. Create a File object pointing to the text file
	            File file = new File("sample.txt"); // File must exist in the same folder

	            Scanner reader = new Scanner(file);

	            System.out.println("File content:\n");

	            while (reader.hasNextLine()) {
	                String line = reader.nextLine(); // Read one line at a time
	                System.out.println(line);       
	            }

	            reader.close();

	        } catch (FileNotFoundException e) {
	            // This block runs if the file is not found
	            System.out.println("Error: File not found!");
	            e.printStackTrace(); 
	        }
	    }
	}

