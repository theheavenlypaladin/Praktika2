package PraktikalWork9;
public class Task3 {
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
    public static void mergeSort(Student[] students, int left, int right) {
        if (left >= right) {
            return;
        }
        int middle = (left + right) / 2;
        mergeSort(students, left, middle);
        mergeSort(students, middle + 1, right);
        merge(students, left, middle, right);
    }
    public static void merge(Student[] students, int left, int middle, int right) {
        Student[] temp = new Student[right - left + 1];
        int i = left;
        int j = middle + 1;
        int k = 0;
        while (i <= middle && j <= right) {
            if (students[i].compareTo(students[j]) <= 0) {
                temp[k++] = students[i++];
            } else {
                temp[k++] = students[j++];
            }
        }
        while (i <= middle) {
            temp[k++] = students[i++];
        }
        while (j <= right) {
            temp[k++] = students[j++];
        }
        for (k = 0; k < temp.length; k++) {
            students[left + k] = temp[k];
        }
    }
    public static Student[] unite(Student[] first, Student[] second) {
        Student[] result = new Student[first.length + second.length];
        for (int i = 0; i < first.length; i++) {
            result[i] = first[i];
        }
        for (int i = 0; i < second.length; i++) {
            result[first.length + i] = second[i];
        }
        mergeSort(result, 0, result.length - 1);
        return result;
    }
    public static void main(String[] args) {
        Student[] first = {
                new Student(105, "Анна", 4.7),
                new Student(101, "Иван", 4.2),
                new Student(103, "Олег", 3.8)
        };
        Student[] second = {
                new Student(104, "Мария", 4.9),
                new Student(102, "Павел", 4.0)
        };
        Student[] result = unite(first, second);
        for (Student student : result) {
            System.out.println(student);
        }
    }
}