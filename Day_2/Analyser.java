package task.corejava;
import java.util.Scanner;
public class Analyser {
	public static void main(String args[]) {
		Scanner m=new Scanner(System.in);
		System.out.println("Enter the crt sentence:");
		String word=m.nextLine();
		String[] in=word.split(" ");
		int wordcount=in.length;
		String revword="  ";
		for(int i=word.length()-1;i>=0;i--) {
			revword+=word.charAt(i);
		}
		String largest=in[0];
		for(String words:in) { 
			if(words.length() > largest.length()) {
				largest=words;
			}
		}
		
		System.out.println("the length of sentence:"+word.length());
		System.out.println("the reverse sentence:"+revword);
		System.out.println("the num words:"+wordcount);
		System.out.println("the largest word:"+largest);
		}
}
