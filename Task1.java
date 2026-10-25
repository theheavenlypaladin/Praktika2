package PraktikalWork13;
import java.util.Scanner;
public class Task1 {
    public static void processString(String text) {
        if (!text.isEmpty()) {
            System.out.println("Последний символ: " + text.charAt(text.length() - 1));
        } else {
            System.out.println("Строка пустая, последнего символа нет.");
        }
        System.out.println("Заканчивается на !!!: " + text.endsWith("!!!"));
        System.out.println("Начинается с I like: " + text.startsWith("I like"));
        System.out.println("Содержит Java: " + text.contains("Java"));
        int position = text.indexOf("Java");
        System.out.println("Позиция Java: " + position);
        System.out.println("Замена a на o: " + text.replace('a', 'o'));
        System.out.println("Верхний регистр: " + text.toUpperCase());
        System.out.println("Нижний регистр: " + text.toLowerCase());
        if (position != -1) {
            System.out.println("Подстрока: " + text.substring(position, position + 4));
        } else {
            System.out.println("Подстрока Java не найдена.");
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку, например I like Java!!!:");
        processString(scanner.nextLine());
    }
}
