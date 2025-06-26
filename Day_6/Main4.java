package corejava;
class TicketBooking {
 private int availableTickets = 10; // total tickets

 public synchronized void bookTicket(String userName) {
     if (availableTickets > 0) {
         System.out.println(userName + " is trying to book a ticket...");

         try {
             Thread.sleep(1000);
         } catch (InterruptedException e) {
             System.out.println(userName + " was interrupted.");
         }

         availableTickets--;
         System.out.println(userName + " booked a ticket. Tickets left: " + availableTickets);
     } else {

         System.out.println("Sorry " + userName + ", tickets are SOLD OUT.");
     }
 }
}
class User extends Thread {
 private String userName;
 private TicketBooking bookingSystem;

 public User(String userName, TicketBooking bookingSystem) {
     this.userName = userName;
     this.bookingSystem = bookingSystem;
 }

 public void run() {
     bookingSystem.bookTicket(userName);
 }
}

public class Main4 {
 public static void main(String[] args) {
     TicketBooking bookingSystem = new TicketBooking();

     // Create multiple users (threads)
     User u1 = new User("User 1", bookingSystem);
     User u2 = new User("User 2", bookingSystem);
     User u3 = new User("User 3", bookingSystem);
     User u4 = new User("User 4", bookingSystem);
     User u5 = new User("User 5", bookingSystem);
     User u6 = new User("User 6", bookingSystem);
     User u7 = new User("User 7", bookingSystem);
     User u8 = new User("User 8", bookingSystem);
     User u9 = new User("User 9", bookingSystem);
     User u10 = new User("User 10", bookingSystem);
     User u11 = new User("User 11", bookingSystem); // One extra user

     u1.start();
     u2.start();
     u3.start();
     u4.start();
     u5.start();
     u6.start();
     u7.start();
     u8.start();
     u9.start();
     u10.start();
     u11.start(); 
 }
}