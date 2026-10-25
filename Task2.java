package PraktikalWork14;
import java.util.Scanner;
import java.util.regex.Pattern;
public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку:");
        String text = scanner.nextLine();
        boolean result = Pattern.matches("abcdefghijklmnopqrstuv18340", text);
        System.out.println(result ? "YES" : "NO");
    }
}
