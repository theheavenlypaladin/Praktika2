package PraktikalWork13;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class Task6 {
    public static StringBuilder getLine(String[] words) {
        boolean[] used = new boolean[words.length];
        StringBuilder result = new StringBuilder();
        if (buildChain(words, used, result, 0)) {
            return result;
        }
        return null;
    }
    private static boolean buildChain(String[] words, boolean[] used, StringBuilder result, int count) {
        if (count == words.length) {
            return true;
        }
        for (int i = 0; i < words.length; i++) {
            if (used[i]) {
                continue;
            }
            if (count > 0) {
                char last = Character.toLowerCase(result.charAt(result.length() - 1));
                char first = Character.toLowerCase(words[i].charAt(0));
                if (last != first) {
                    continue;
                }
            }
            int oldLength = result.length();
            if (count > 0) {
                result.append(' ');
            }
            result.append(words[i]);
            used[i] = true;
            if (buildChain(words, used, result, count + 1)) {
                return true;
            }
            used[i] = false;
            result.setLength(oldLength);
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя файла, например words.txt:");
        String fileName = scanner.nextLine();
        ArrayList<String> words = new ArrayList<String>();
        try {
            Scanner fileScanner = new Scanner(new File(fileName), "UTF-8");
            while (fileScanner.hasNext()) {
                words.add(fileScanner.next());
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден.");
            return;
        }
        String[] array = new String[words.size()];
        for (int i = 0; i < words.size(); i++) {
            array[i] = words.get(i);
        }
        StringBuilder result = getLine(array);
        if (result == null) {
            System.out.println("Нельзя составить цепочку из всех слов.");
        } else {
            System.out.println(result);
        }
    }
}
