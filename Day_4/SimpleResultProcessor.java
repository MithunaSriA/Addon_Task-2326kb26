package corejava;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class SimpleResultProcessor {

	    public static void main(String[] args) {
	        try {
	            File inputFile = new File("marks.txt");              
	            Scanner reader = new Scanner(inputFile);            

	            FileWriter writer = new FileWriter("results.txt");   

	            writer.write("RollNo\tName\tTotal\tAverage\tResult\n"); // write header

	            while (reader.hasNextLine()) {                       // read line by line
	                String line = reader.nextLine();                 // store current line
	                if (line.trim().isEmpty()) continue;             // skip empty lines

	                String[] parts = line.split(" ");                
	                int rollNo = Integer.parseInt(parts[0]);         // get roll number
	                String name = parts[1];                          // get name

	                int total = 0;
	                for (int i = 2; i < parts.length; i++) {         
	                    total += Integer.parseInt(parts[i]);         
	                }

	                double average = total / (double)(parts.length - 2); // 13. calculate average
	                String result = (average >= 50) ? "PASS" : "FAIL";   // 14. decide result

	                // 15. write result line
	                writer.write(rollNo + "\t" + name + "\t" + total + "\t" + String.format("%.2f", average) + "\t" + result + "\n");
	            }

	            reader.close();      // 16. close input file
	            writer.close();      // 17. close output file

	            System.out.println("✅ Results written to results.txt");

	        } catch (IOException e) {
	            System.out.println("❌ Error: " + e.getMessage());
	        }
	    }
	}

