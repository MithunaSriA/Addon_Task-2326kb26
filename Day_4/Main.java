package corejava;
import java.util.Scanner;

/**
 * Demo: Safe division for beginners
 */
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // ask the user for two integers
        System.out.print("Enter numerator  : ");
        int num = sc.nextInt();

        System.out.print("Enter denominator: ");
        int den = sc.nextInt();

        /* ──────────────
           METHOD 1: try–catch
           ────────────── */
        try {
            int result = num / den;       // risky line
            System.out.println("[try‑catch] Result = " + result);
        } catch (ArithmeticException ex) {
            System.out.println("[try‑catch] Oops! Cannot divide by zero.");
        }

        /* ──────────────
           METHOD 2: manual guard
           ────────────── */
        if (den != 0) {
            int result = num / den;
            System.out.println("[guard]     Result = " + result);
        } else {
            System.out.println("[guard]     Denominator must not be zero.");
        }

        /* ──────────────
           METHOD 3: loop until valid
           ────────────── */
        int safeDen = den;
        while (safeDen == 0) {            // keep asking until user types non‑zero
            System.out.print("[loop]      Enter a non‑zero denominator: ");
            safeDen = sc.nextInt();
        }
        int result = num / safeDen;
        System.out.println("[loop]      Result = " + result);

        sc.close();
    }
}