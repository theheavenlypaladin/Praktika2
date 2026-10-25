package PraktikalWork13;
import java.util.StringTokenizer;
public class Task3 {
    public static void main(String[] args) {
        String[] commaAddresses = {
                " Россия, Московская область, Химки, Молодёжная, 10, 2, 15 ",
                "Россия, Ленинградская область, Гатчина, Соборная, 7, , 21",
                "Беларусь, Минская область, Борисов, Гагарина, 12, 1, 8",
                "Казахстан, Акмолинская область, Кокшетау, Абая, 5, 3, 42"
        };
        System.out.println("Разбор методом split():");
        for (String line : commaAddresses) {
            System.out.println(Address.parseWithSplit(line));
            System.out.println();
        }
        String[] mixedAddresses = {
                " Россия; Московская область. Химки, Молодёжная; 10. 2, 15 ",
                "Россия. Ленинградская область; Гатчина, Соборная. 7;; 21",
                "Беларусь; Минская область, Борисов. Гагарина; 12, 1. 8",
                "Казахстан. Акмолинская область; Кокшетау, Абая. 5; 3, 42"
        };
        System.out.println("Разбор классом StringTokenizer:");
        for (String line : mixedAddresses) {
            System.out.println(Address.parseWithTokenizer(line));
            System.out.println();
        }
    }
    static class Address {
        private String country;
        private String region;
        private String city;
        private String street;
        private String house;
        private String building;
        private String apartment;
        private Address(String[] parts) {
            if (parts.length != 7) {
                throw new IllegalArgumentException("В адресе должно быть 7 частей.");
            }
            country = parts[0].trim();
            region = parts[1].trim();
            city = parts[2].trim();
            street = parts[3].trim();
            house = parts[4].trim();
            building = parts[5].trim();
            apartment = parts[6].trim();
        }
        public static Address parseWithSplit(String line) {
            return new Address(line.split(",", -1));
        }
        public static Address parseWithTokenizer(String line) {
            String[] parts = {"", "", "", "", "", "", ""};
            StringTokenizer tokenizer = new StringTokenizer(line, ",.;", true);
            int index = 0;
            while (tokenizer.hasMoreTokens()) {
                String token = tokenizer.nextToken();
                if (token.equals(",") || token.equals(".") || token.equals(";")) {
                    index++;
                    if (index >= parts.length) {
                        throw new IllegalArgumentException("Слишком много частей адреса.");
                    }
                } else {
                    parts[index] = token;
                }
            }
            if (index != 6) {
                throw new IllegalArgumentException("В адресе должно быть 7 частей.");
            }
            return new Address(parts);
        }
        public String toString() {
            return "Страна: " + country
                    + "\nРегион: " + region
                    + "\nГород: " + city
                    + "\nУлица: " + street
                    + "\nДом: " + house
                    + "\nКорпус: " + building
                    + "\nКвартира: " + apartment;
        }
    }
}