package PraktikalWork10;
import java.util.Comparator;
public class Task2 {
    public static void main(String[] args) {
        SortingStudentsByGPA students = new SortingStudentsByGPA();
        students.setArray();
        students.quicksort();
        System.out.println("Быстрая сортировка по среднему баллу:");
        students.outArray();

        students.setArray();
        students.mergeSort();
        System.out.println("\nСортировка слиянием по среднему баллу:");
        students.outArray();

        students.sortByLastName();
        System.out.println("\nСортировка по фамилии:");
        students.outArray();
    }
    static class SortingStudentsByGPA implements Comparator<Student> {
        private Student[] iDNumber;
        public int compare(Student a, Student b) {
            return Double.compare(b.getGpa(), a.getGpa());
        }
        public void setArray() {
            iDNumber = new Student[] {
                    new Student("Анна", "Смирнова", "Информатика", 2, "ИВТ-21", 4.7),
                    new Student("Иван", "Петров", "Информатика", 2, "ИВТ-21", 4.2),
                    new Student("Олег", "Иванов", "Математика", 1, "МТ-11", 3.8),
                    new Student("Мария", "Волкова", "Математика", 3, "МТ-31", 4.9)
            };
        }
        public void outArray() {
            for (Student student : iDNumber) {
                System.out.println(student);
            }
        }
        public void quicksort() {
            quicksort(0, iDNumber.length - 1);
        }
        private void quicksort(int left, int right) {
            if (left >= right) {
                return;
            }
            int i = left;
            int j = right;
            Student pivot = iDNumber[(left + right) / 2];
            while (i <= j) {
                while (compare(iDNumber[i], pivot) < 0) {
                    i++;
                }
                while (compare(iDNumber[j], pivot) > 0) {
                    j--;
                }
                if (i <= j) {
                    Student temp = iDNumber[i];
                    iDNumber[i] = iDNumber[j];
                    iDNumber[j] = temp;
                    i++;
                    j--;
                }
            }
            if (left < j) {
                quicksort(left, j);
            }
            if (i < right) {
                quicksort(i, right);
            }
        }
        public void mergeSort() {
            mergeSort(0, iDNumber.length - 1);
        }
        private void mergeSort(int left, int right) {
            if (left >= right) {
                return;
            }
            int middle = (left + right) / 2;
            mergeSort(left, middle);
            mergeSort(middle + 1, right);
            merge(left, middle, right);
        }
        private void merge(int left, int middle, int right) {
            Student[] temp = new Student[right - left + 1];
            int i = left;
            int j = middle + 1;
            int k = 0;
            while (i <= middle && j <= right) {
                if (compare(iDNumber[i], iDNumber[j]) <= 0) {
                    temp[k++] = iDNumber[i++];
                } else {
                    temp[k++] = iDNumber[j++];
                }
            }
            while (i <= middle) {
                temp[k++] = iDNumber[i++];
            }
            while (j <= right) {
                temp[k++] = iDNumber[j++];
            }
            for (k = 0; k < temp.length; k++) {
                iDNumber[left + k] = temp[k];
            }
        }
        public void sortByLastName() {
            for (int i = 1; i < iDNumber.length; i++) {
                Student current = iDNumber[i];
                int j = i - 1;
                while (j >= 0 && iDNumber[j].getLastName()
                        .compareToIgnoreCase(current.getLastName()) > 0) {
                    iDNumber[j + 1] = iDNumber[j];
                    j--;
                }
                iDNumber[j + 1] = current;
            }
        }
    }
    static class Student {
        private String firstName;
        private String lastName;
        private String specialty;
        private int course;
        private String group;
        private double gpa;
        public Student(String firstName, String lastName, String specialty, int course, String group, double gpa) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.specialty = specialty;
            this.course = course;
            this.group = group;
            this.gpa = gpa;
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
        public double getGpa() {
            return gpa;
        }
        public void setGpa(double gpa) {
            this.gpa = gpa;
        }
        public String toString() {
            return lastName + " " + firstName + ", " + specialty
                    + ", курс " + course + ", группа " + group + ", средний балл: " + gpa;
        }
    }
}
