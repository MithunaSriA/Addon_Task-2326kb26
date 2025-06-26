package task.corejava;
import java.util.Scanner;
public class Split {
	public static void main(String args[]) {
		Scanner ms=new Scanner(System.in);
		System.out.println("Enter the sentence:");
		String sp=ms.nextLine();
		String[] words=sp.split(" ");
		System.out.println("the slpit words are:");
		for(String i:words) {
			System.out.println(i);
		}
		
		
	}

}
