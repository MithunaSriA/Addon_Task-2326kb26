package corejava;
import java.io.BufferedWriter;   
import java.io.FileWriter;      
import java.io.IOException; 
public class WriteToFile {
      
	    public static void main(String[] args) {      
	        String fileName = "output.txt";          

	        String[] lines = {
	            "First line",
	            "Second line",
	            "Third line"
	        };
        
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {

	            for (String line : lines) {           
	                writer.write(line);               
	                writer.newLine();                 
	            }
	            
	            System.out.println("Lines written successfully to " + fileName);

	        } catch (IOException e) {                 

	            System.out.println("An error occurred: " + e.getMessage());
	        }
	    }
	}

