package PraktikalWork8;
import java.util.Scanner;
public class Task5 {
    public static int sumDigits(long n) {
        if (n < 10) {
            return (int) n;
        }
        return (int) (n % 10) + sumDigits(n / 10);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите натуральное число N:");
        long n = scanner.nextLong();
        if (n < 1) {
            System.out.println("N должно быть натуральным числом.");
            return;
        }
        System.out.println(sumDigits(n));
    }
}
