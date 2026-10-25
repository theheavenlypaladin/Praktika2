package PraktikalWork11;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите год, месяц и число через пробел: ");
        int year = scanner.nextInt();
        int month = scanner.nextInt();
        int day = scanner.nextInt();
        System.out.print("Введите часы и минуты через пробел: ");
        int hour = scanner.nextInt();
        int minute = scanner.nextInt();
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.setLenient(false);
        calendar.set(year, month - 1, day, hour, minute);
        try {
            Date date = new Date(calendar.getTimeInMillis());
            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm");
            System.out.println("Объект Date: " + format.format(date));
            System.out.println("Объект Calendar: " + format.format(calendar.getTime()));
        } catch (IllegalArgumentException e) {
            System.out.println("Неверная дата или время.");
        }
    }
}
