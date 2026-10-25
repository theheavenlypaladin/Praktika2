package PraktikalWork9;
public class Task1 {
    static class Student implements Comparable<Student> {
        int idNumber;
        String name;
        double gpa;
        Student(int idNumber, String name, double gpa) {
            this.idNumber = idNumber;
            this.name = name;
            this.gpa = gpa;
        }
        @Override
        public int compareTo(Student other) {
            return Integer.compare(idNumber, other.idNumber);
        }
        @Override
        public String toString() {
            return idNumber + " " + name + ", средний балл: " + gpa;
        }
    }
    public static void insertionSort(Student[] iDNumber) {
        for (int i = 1; i < iDNumber.length; i++) {
            Student current = iDNumber[i];
            int j = i - 1;
            while (j >= 0 && iDNumber[j].compareTo(current) > 0) {
                iDNumber[j + 1] = iDNumber[j];
                j--;
            }
            iDNumber[j + 1] = current;
        }
    }
    public static void main(String[] args) {
        Student[] iDNumber = {
                new Student(103, "Анна", 4.7),
                new Student(101, "Иван", 4.2),
                new Student(104, "Олег", 3.8),
                new Student(102, "Мария", 4.9)
        };
        insertionSort(iDNumber);
        for (Student student : iDNumber) {
            System.out.println(student);
        }
    }
}