package PraktikalWork14;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите текст с ценами:");
        String text = scanner.nextLine();
        String regex = "(?<![\\w.,+-])\\d+(\\.\\d{1,2})?\\s+(USD|RUB|EU)\\b";
        Pattern pattern = Pattern.compile(regex, Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher = pattern.matcher(text);
        boolean found = false;
        while (matcher.find()) {
            System.out.println(matcher.group());
            found = true;
        }
        if (!found) {
            System.out.println("Цены не найдены.");
        }
    }
}
