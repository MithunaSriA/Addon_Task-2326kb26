package task.corejava;

import java.util.HashMap;
import java.util.Map;

public class MarkList1 {

    public static void main(String[] args) {
      
        HashMap<String, Integer> studentMarks = new HashMap<>();

       
        studentMarks.put("Angle", 85);
        studentMarks.put("Babu", 90);
        studentMarks.put("Charu", 78);
        studentMarks.put("David", 92);

       
        int totalMarks = 0;
        for (Map.Entry<String, Integer> entry : studentMarks.entrySet()) {
            totalMarks += entry.getValue();
        }

       
        double averageMarks = totalMarks / (double) studentMarks.size();

     
        System.out.println("Student Marks:");
        for (Map.Entry<String, Integer> entry : studentMarks.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        
        System.out.println("\nAverage Marks: " + averageMarks);
    }
}
