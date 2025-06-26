package corejava;
import java.util.Scanner;
public class LeapYear {
	public static void main(String args[]) {
		Scanner m=new Scanner(System.in);
		System.out.println("Enter the year:");
		int year=m.nextInt();
		if((year%4==0 && year%100!=0) || (year%400==0)) {
			System.out.println("it's leap year");
		}
		else {
			System.out.println("it's not leap year");
		}
	}

}
