package PraktikalWork11;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        format.setLenient(false);
        System.out.print("Введите фамилию разработчика: ");
        String surname = scanner.nextLine();
        System.out.print("Дата получения задания (дд.ММ.гггг ЧЧ:мм:сс): ");
        String text = scanner.nextLine();
        try {
            Date received = format.parse(text);
            Date submitted = new Date();
            System.out.println("Разработчик: " + surname);
            System.out.println("Задание получено: " + format.format(received));
            System.out.println("Задание сдано: " + format.format(submitted));
        } catch (ParseException e) {
            System.out.println("Неверная дата или время.");
        }
    }
}
