package corejava;
import java.util.Scanner;
public class Calculator {
	
		//method-return

		public static int add(int a, int b) {

		return a+b;
		}

		public static int sub(int a, int b) {
			return a-b;
		}


		public static int mul(int a, int b) {

		return a*b;
		}

		public static double div(int a, int b){

		return (double) a/b;
		}

		public static void main(String args[]){

		Scanner ms=new Scanner(System.in);

		System.out.println("Enter the num1:");

		int num1=ms.nextInt();
		
		System.out.println("Enter the num2;");

		int num2=ms.nextInt();

		System.out.println("1.Addition");

		System.out.println("2.Substraction");
		
		System.out.println("3.Multiplication");

		System.out.println("4.Divide");

		System.out.println("Enter ur choices");

		int choice=ms.nextInt();

		switch (choice) {

		case 1:

		System.out.println("the answer:" +add(num1,num2));

		break;

		case 2:

		System.out.println("the answer:" +sub(num1,num2));
		
		break;

		case 3:

		System.out.println("the answer:" +mul(num1,num2));
		
		break;
		
		case 4:

		System.out.println("the answer is:"+div(num1,num2));
		break;
		default:

		System.out.println("invalid choice");
	}
	}}
