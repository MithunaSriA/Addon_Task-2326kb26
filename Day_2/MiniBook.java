package task.corejava;
import java.util.Scanner;
public class MiniBook {

	public static void main(String[] args) {
		Scanner ms=new Scanner(System.in);
		String[] book=new String[4];
		System.out.println("This is miniaddressbook");
		for(int i=1;i<book.length;i++) {
			System.out.println("Enter the detail:"+i+":");
			System.out.println("name:");
			String name=ms.nextLine();
			System.out.println("Address:");
			String address=ms.nextLine();
			System.out.println("Phone number:");
			String phoneno=ms.nextLine();
		book[i]="name:"+name+ ",Address:"+address+ ",phonenumber:"+phoneno;
		}
		System.out.println("the book detail");
		for(int i=0;i<book.length;i++) {
			System.out.println((i+1)+"."+book[i]);		}
	}

}
