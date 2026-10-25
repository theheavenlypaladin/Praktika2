package PraktikalWork10;
public class Task1 {
    public static void main(String[] args) {
        Student student = new Student("Иван", "Петров", "Информатика", 2, "ИВТ-21");
        System.out.println(student);
        student.setCourse(3);
        student.setGroup("ИВТ-31");
        System.out.println("После изменения курса и группы:");
        System.out.println(student);
    }
    static class Student {
        private String firstName;
        private String lastName;
        private String specialty;
        private int course;
        private String group;
        public Student(String firstName, String lastName, String specialty, int course, String group) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.specialty = specialty;
            this.course = course;
            this.group = group;
        }
        public String getFirstName() {
            return firstName;
        }
        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }
        public String getLastName() {
            return lastName;
        }
        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
        public String getSpecialty() {
            return specialty;
        }
        public void setSpecialty(String specialty) {
            this.specialty = specialty;
        }
        public int getCourse() {
            return course;
        }
        public void setCourse(int course) {
            this.course = course;
        }
        public String getGroup() {
            return group;
        }
        public void setGroup(String group) {
            this.group = group;
        }
        public String toString() {
            return lastName + " " + firstName + ", " + specialty
                    + ", курс " + course + ", группа " + group;
        }
    }
}
