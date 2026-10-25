package PraktikalWork9;
import java.util.Comparator;
public class Task2 {
    static class Student {
        int idNumber;
        String name;
        double gpa;
        Student(int idNumber, String name, double gpa) {
            this.idNumber = idNumber;
            this.name = name;
            this.gpa = gpa;
        }
        @Override
        public String toString() {
            return idNumber + " " + name + ", средний балл: " + gpa;
        }
    }
    static class SortingStudentsByGPA implements Comparator<Student> {
        @Override
        public int compare(Student a, Student b) {
            return Double.compare(b.gpa, a.gpa);
        }
        public void quicksort(Student[] students, int left, int right) {
            if (left >= right) {
                return;
            }
            int i = left;
            int j = right;
            Student pivot = students[(left + right) / 2];
            while (i <= j) {
                while (compare(students[i], pivot) < 0) {
                    i++;
                }
                while (compare(students[j], pivot) > 0) {
                    j--;
                }
                if (i <= j) {
                    Student temp = students[i];
                    students[i] = students[j];
                    students[j] = temp;
                    i++;
                    j--;
                }
            }
            if (left < j) {
                quicksort(students, left, j);
            }
            if (i < right) {
                quicksort(students, i, right);
            }
        }
    }
    public static void main(String[] args) {
        Student[] students = {
                new Student(103, "Анна", 4.7),
                new Student(101, "Иван", 4.2),
                new Student(104, "Олег", 3.8),
                new Student(102, "Мария", 4.9)
        };
        SortingStudentsByGPA sorter = new SortingStudentsByGPA();
        sorter.quicksort(students, 0, students.length - 1);
        for (Student student : students) {
            System.out.println(student);
        }
    }
}