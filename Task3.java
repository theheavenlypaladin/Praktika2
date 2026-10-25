package PraktikalWork8;
import java.util.Scanner;
public class Task3 {
    public static void printNumbers(int a, int b) {
        System.out.print(a);
        if (a == b) {
            return;
        }
        System.out.print(" ");
        if (a < b) {
            printNumbers(a + 1, b);
        } else {
            printNumbers(a - 1, b);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите A и B:");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        printNumbers(a, b);
        System.out.println();
    }
}
