package PraktikalWork14;
import java.util.Scanner;
import java.util.regex.Pattern;
public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку:");
        String text = scanner.nextLine();
        Pattern pattern = Pattern.compile("[\\s,;.!?]+", Pattern.UNICODE_CHARACTER_CLASS);
        String[] words = pattern.split(text);
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            if (!words[i].isEmpty()) {
                count++;
                System.out.println(count + ": " + words[i]);
            }
        }
        System.out.println("Количество элементов: " + count);
    }
}
