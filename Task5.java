package PraktikalWork11;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
public class Task5 {
    public static void measure(List<Integer> list, String name) {
        int size = 20000;
        int repeat = 1000;
        long start = System.nanoTime();
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
        long addTime = System.nanoTime() - start;
        start = System.nanoTime();
        for (int i = 0; i < repeat; i++) {
            list.add(list.size() / 2, -1);
        }
        long insertTime = System.nanoTime() - start;
        start = System.nanoTime();
        for (int i = 0; i < repeat; i++) {
            list.remove(list.size() / 2);
        }
        long removeTime = System.nanoTime() - start;
        int found = 0;
        start = System.nanoTime();
        for (int i = 0; i < repeat; i++) {
            if (list.contains(size - 1)) {
                found++;
            }
        }
        long searchTime = System.nanoTime() - start;
        System.out.println(name);
        System.out.println("Добавление " + size + " элементов в конец: " + addTime + " нс");
        System.out.println("Вставка " + repeat + " элементов в середину: " + insertTime + " нс");
        System.out.println("Удаление " + repeat + " элементов из середины: " + removeTime + " нс");
        System.out.println("Поиск последнего значения " + repeat + " раз: " + searchTime + " нс");
        System.out.println("Число успешных поисков: " + found);
        System.out.println();
    }
    public static void main(String[] args) {
        measure(new ArrayList<Integer>(), "ArrayList");
        measure(new LinkedList<Integer>(), "LinkedList");
    }
}
