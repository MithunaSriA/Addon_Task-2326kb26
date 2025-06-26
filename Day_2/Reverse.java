package task.corejava;

public class Reverse {
	public static void main(String args[]) {
		int[] num= {10,20,30,40,50};
		System.out.println("The orginal num");
		for(int i:num) {
			System.out.println(i);
		}
		System.out.println("The reverse num is:");
		for(int i=num.length-1;i>=0;i--) {
			System.out.println(num[i]);
		}
	}

}

