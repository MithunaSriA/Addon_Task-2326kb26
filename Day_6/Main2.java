package corejava;

class MyThread extends Thread {
 private String name;

 public MyThread(String name) {
     this.name = name;
 }

 public void run() {
     for (int i = 1; i <= 3; i++) {
         System.out.println(name + " - Count: " + i);
         try {

             Thread.sleep(500);
         } catch (InterruptedException e) {
             System.out.println(name + " was interrupted.");
         }
     }
     System.out.println(name + " has finished.");
 }
}
public class Main2 {
 public static void main(String[] args) {
     // Create two threads
     MyThread thread1 = new MyThread("Thread 1");
     MyThread thread2 = new MyThread("Thread 2");

     thread1.start();

     try {
         thread1.join();
     } catch (InterruptedException e) {
         System.out.println("Main thread interrupted while waiting.");
     }

     thread2.start();

     try {
         thread2.join();
     } catch (InterruptedException e) {
         System.out.println("Main thread interrupted while waiting.");
     }

     System.out.println("Main thread finished.");
 }
}