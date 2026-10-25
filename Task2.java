package PraktikalWork11;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        format.setLenient(false);
        System.out.print("Введите дату и время (дд.ММ.гггг ЧЧ:мм:сс): ");
        String text = scanner.nextLine();
        try {
            Date entered = format.parse(text);
            Date current = new Date(System.currentTimeMillis() / 1000 * 1000);
            System.out.println("Текущая дата: " + format.format(current));
            System.out.println("Введенная дата: " + format.format(entered));
            if (entered.before(current)) {
                System.out.println("Введенная дата раньше текущей.");
            } else if (entered.after(current)) {
                System.out.println("Введенная дата позже текущей.");
            } else {
                System.out.println("Даты совпадают.");
            }
        } catch (ParseException e) {
            System.out.println("Неверная дата или время.");
        }
    }
}
