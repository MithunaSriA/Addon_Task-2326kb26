package corejava;

public class Calculator {

    public int sum(int a, int b) {         
        return a + b;
    }

    public double sum(double a, double b) { 
        return a + b;
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();

        int    intResult    = calc.sum(7, 5);        
        double doubleResult = calc.sum(7.3, 5.2);      

        System.out.println("Integer sum  : " + intResult);
        System.out.println("Double  sum  : " + doubleResult);
    }
}
