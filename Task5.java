package PraktikalWork13;
import java.util.Scanner;
public class Task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер телефона:");
        PhoneNumber phone = new PhoneNumber(scanner.nextLine());
        try {
            System.out.println(phone.format());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
    static class PhoneNumber {
        private String number;
        public PhoneNumber(String number) {
            this.number = number.trim();
        }
        public String format() {
            String digits;
            if (number.startsWith("+") && number.length() > 11) {
                digits = number.substring(1);
            } else if (number.startsWith("8") && number.length() == 11) {
                digits = "7" + number.substring(1);
            } else {
                throw new IllegalArgumentException("Неверный формат номера.");
            }
            for (int i = 0; i < digits.length(); i++) {
                char digit = digits.charAt(i);
                if (digit < '0' || digit > '9') {
                    throw new IllegalArgumentException("В номере должны быть только цифры.");
                }
            }
            int countryLength = digits.length() - 10;
            String country = digits.substring(0, countryLength);
            String phone = digits.substring(countryLength);
            return "+" + country + phone.substring(0, 3)
                    + "-" + phone.substring(3, 6)
                    + "-" + phone.substring(6);
        }
    }
}