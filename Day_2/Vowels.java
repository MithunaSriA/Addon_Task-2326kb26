package task.corejava;
import java.util.Scanner;
public class Vowels {
	public static void main(String args[]){
	int vowels=0;
	int consonants=0;
	Scanner cb=new Scanner(System.in);
	System.out.println("Enter String:");
	String a=cb.nextLine();
	String str=a.toLowerCase();
	System.out.println(str);
	for(int i=0;i<a.length();i++){
	char chr=a.charAt(i); //method
	if(chr=='a'||chr=='e'||chr=='i' || chr=='p' || chr=='u')
			{

			vowels++;
			}
	else{
		consonants++;
		}
	}
	System.out.println("No.of.Vowels are: "+vowels);
	System.out.println("No.of.Consonants are:"+consonants);
	}
}
