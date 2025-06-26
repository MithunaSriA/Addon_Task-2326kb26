package corejava;
import java.util.Scanner;
public class Grading {

	public static String grading(double avg) {

	if (avg>=90)

	return "A+";

	else if(avg>=75)

	return "B+";

	else if (avg>=45)

	return "C+";

	else if(avg>=30)

	return "D+";

	else return "fail";
	}
	public static void main(String args[]) {
	Scanner po=new Scanner(System.in);
	System.out.println("Enter the name:");
	String n=po.nextLine();
	System.out.println("enter the mark1:");
	int mark1=po.nextInt();
	System.out.println("the mark1:" +mark1);
	System.out.println("Enter mark2:");
	int mark2=po.nextInt();
	System.out.println( "the mark2:"+mark2); 
	System.out.println("Enter the mark3:");
	int mark3=po.nextInt();	
	System.out.println("the mark3:"+mark3);
	System.out.println("name:"+n);
	double avg =(mark1+mark2+mark3)/3.0;
	System.out.println("the average is: "+avg);
	String rank= grading(avg);
	System.out.println("the grade is:"+rank);
}
}
