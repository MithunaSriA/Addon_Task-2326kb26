package corejava;

class MessagePrinter implements Runnable {
 private String message;

 public MessagePrinter(String message) {
     this.message = message;
 }

 public void run() {
     // Print the message
     System.out.println("Message from thread: " + message);
 }
}

public class Main3 {
 public static void main(String[] args) {
     MessagePrinter printer1 = new MessagePrinter("Hello from Thread 1!");
     MessagePrinter printer2 = new MessagePrinter("Hello from Thread 2!");
     MessagePrinter printer3 = new MessagePrinter("Hello from Thread 3!");

     Thread thread1 = new Thread(printer1);
     Thread thread2 = new Thread(printer2);
     Thread thread3 = new Thread(printer3);

     thread1.start();
     thread2.start();
     thread3.start();
 }
}
