package PraktikalWork8;
import java.util.Scanner;
public class Task6 {
    public static boolean isPrime(int n, int divisor) {
        if (divisor > n / divisor) {
            return true;
        }
        if (n % divisor == 0) {
            return false;
        }
        return isPrime(n, divisor + 1);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите натуральное число n > 1:");
        int n = scanner.nextInt();
        if (n <= 1) {
            System.out.println("Число должно быть больше 1.");
            return;
        }
        System.out.println(isPrime(n, 2) ? "YES" : "NO");
    }
}
