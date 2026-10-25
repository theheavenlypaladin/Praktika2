package PraktikalWork11;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Locale;
public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat inputFormat = new SimpleDateFormat("dd.MM.yyyy");
        inputFormat.setLenient(false);
        System.out.print("Введите имя студента: ");
        String name = scanner.nextLine();
        System.out.print("Введите дату рождения (дд.ММ.гггг): ");
        String text = scanner.nextLine();
        System.out.print("Формат даты: 1 - короткий, 2 - средний, 3 - полный: ");
        int choice = scanner.nextInt();
        int format;
        if (choice == 1) {
            format = DateFormat.SHORT;
        } else if (choice == 2) {
            format = DateFormat.MEDIUM;
        } else if (choice == 3) {
            format = DateFormat.FULL;
        } else {
            System.out.println("Такого формата нет.");
            return;
        }
        try {
            Date birthDate = inputFormat.parse(text);
            Student student = new Student(name, birthDate, format);
            System.out.println(student);
        } catch (ParseException e) {
            System.out.println("Неверная дата рождения.");
        }
    }
    static class Student {
        private String name;
        private Date birthDate;
        private int dateFormat;
        public Student(String name, Date birthDate, int dateFormat) {
            this.name = name;
            this.birthDate = birthDate;
            this.dateFormat = dateFormat;
        }
        public String formatBirthDate(int format) {
            DateFormat formatter = DateFormat.getDateInstance(format, new Locale("ru", "RU"));
            return formatter.format(birthDate);
        }
        @Override
        public String toString() {
            return "Студент: " + name + ", дата рождения: " + formatBirthDate(dateFormat);
        }
    }
}