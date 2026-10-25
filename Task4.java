package PraktikalWork13;
public class Task4 {
    public static void main(String[] args) {
        String[] shirts = {
                "S001,Black Polo Shirt,Black,XL",
                "S002,Black Polo Shirt,Black,L",
                "S003,Blue Polo Shirt,Blue,XL",
                "S004,Blue Polo Shirt,Blue,M",
                "S005,Tan Polo Shirt,Tan,XL",
                "S006,Black T-Shirt,Black,XL",
                "S007,White T-Shirt,White,XL",
                "S008,White T-Shirt,White,L",
                "S009,Green T-Shirt,Green,S",
                "S010,Orange T-Shirt,Orange,S",
                "S011,Maroon Polo Shirt,Maroon,S"
        };
        Shirt[] result = new Shirt[shirts.length];
        for (int i = 0; i < shirts.length; i++) {
            result[i] = new Shirt(shirts[i]);
        }
        for (Shirt shirt : result) {
            System.out.println(shirt);
            System.out.println();
        }
    }
    static class Shirt {
        private String id;
        private String name;
        private String color;
        private String size;
        public Shirt(String line) {
            String[] parts = line.split(",");
            id = parts[0].trim();
            name = parts[1].trim();
            color = parts[2].trim();
            size = parts[3].trim();
        }
        public String toString() {
            return "Артикул: " + id
                    + "\nНазвание: " + name
                    + "\nЦвет: " + color
                    + "\nРазмер: " + size;
        }
    }
}