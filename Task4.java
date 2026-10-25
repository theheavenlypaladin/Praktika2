package PraktikalWork8;
import java.util.Scanner;
public class Task4 {
    public static long countDigits(int digitsLeft, int sumLeft) {
        if (digitsLeft == 0) {
            return sumLeft == 0 ? 1 : 0;
        }
        if (sumLeft < 0 || sumLeft > 9L * digitsLeft) {
            return 0;
        }
        long count = 0;
        for (int digit = 0; digit <= 9; digit++) {
            count += countDigits(digitsLeft - 1, sumLeft - digit);
        }
        return count;
    }
    public static long countNumbers(int k, int s) {
        long count = 0;
        for (int firstDigit = 1; firstDigit <= 9; firstDigit++) {
            count += countDigits(k - 1, s - firstDigit);
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество цифр k и сумму цифр s:");
        int k = scanner.nextInt();
        int s = scanner.nextInt();
        if (k < 1 || s < 0) {
            System.out.println("k должно быть положительным, s — неотрицательным.");
            return;
        }
        System.out.println(countNumbers(k, s));
    }
}

