package task.corejava;

import java.util.ArrayList;
import java.util.Iterator;

public class StudentList {

    public static void main(String[] args) {
      
        ArrayList<String> students = new ArrayList<>();

        students.add("Mithuna");
        students.add("Reshma");
        students.add("Keerthana");
        students.add("Tharani");

      
        Iterator<String> iterator = students.iterator();

   
        System.out.println("List of Students:");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
