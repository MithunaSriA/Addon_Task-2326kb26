package task.corejava;

import java.util.HashSet;

public class UniqueEMail {

    public static void main(String[] args) {
        
        HashSet<String> emailAddresses = new HashSet<>();

        
        emailAddresses.add("mithu@example.com");
        emailAddresses.add("thar@example.com");
        emailAddresses.add("charlie@example.com");
        emailAddresses.add("angle@example.com");  

       
        System.out.println("Unique Email Addresses:");
        for (String email : emailAddresses) {
            System.out.println(email);
        }
    }
}

