package PraktikalWork13;
public class Task2 {
    public static void main(String[] args) {
        Person[] people = {
                new Person("Иванов", "Иван", "Иванович"),
                new Person("Петров", "Пётр", null),
                new Person("Сидоров", "", "Петрович"),
                new Person("Смирнов", null, null)
        };
        for (Person person : people) {
            System.out.println(person.getFullName());
        }
    }
    static class Person {
        private String surname;
        private String firstName;
        private String patronymic;
        public Person(String surname, String firstName, String patronymic) {
            this.surname = surname == null ? "" : surname.trim();
            this.firstName = firstName == null ? "" : firstName.trim();
            this.patronymic = patronymic == null ? "" : patronymic.trim();
        }
        public String getFullName() {
            StringBuilder result = new StringBuilder(surname);
            if (!firstName.isEmpty() || !patronymic.isEmpty()) {
                if (result.length() > 0) {
                    result.append(' ');
                }
                if (!firstName.isEmpty()) {
                    result.append(firstName.charAt(0)).append('.');
                }
                if (!patronymic.isEmpty()) {
                    result.append(patronymic.charAt(0)).append('.');
                }
            }
            return result.toString();
        }
    }
}