import java.util.*;
import java.io.*;

public class School {

    static ArrayList<Student> arr = new ArrayList<Student>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        load();

        while (true) {

            System.out.println("\n1 Add");
            System.out.println("2 Remove");
            System.out.println("3 Search");
            System.out.println("4 Show All");
            System.out.println("5 Exit");

            System.out.print("Choice: ");
            int ch = sc.nextInt();
            sc.nextLine();

            if (ch == 1) add();
            else if (ch == 2) remove();
            else if (ch == 3) search();
            else if (ch == 4) show();
            else if (ch == 5) {
                save();
                break;
            }
            else System.out.println("Wrong input");
        }
    }

    static void add() {

        System.out.print("Name: ");
        String name = sc.nextLine();

        if (name.length() == 0) {
            System.out.println("Name empty");
            return;
        }

        System.out.print("Roll: ");
        int roll = sc.nextInt();
        sc.nextLine();

        System.out.print("Grade: ");
        String grade = sc.nextLine();

        arr.add(new Student(name, roll, grade));
        System.out.println("Added");
    }

    static void remove() {

        System.out.print("Roll to remove: ");
        int roll = sc.nextInt();

        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).r == roll) {
                arr.remove(i);
                System.out.println("Removed");
                return;
            }
        }

        System.out.println("Not found");
    }

    static void search() {

        System.out.print("Roll to search: ");
        int roll = sc.nextInt();

        for (Student s : arr) {
            if (s.r == roll) {
                System.out.println("Found: " + s.n + " " + s.g);
                return;
            }
        }

        System.out.println("Not found");
    }

    static void show() {

        if (arr.size() == 0) {
            System.out.println("No data");
            return;
        }

        for (Student s : arr) {
            System.out.println(s.n + " " + s.r + " " + s.g);
        }
    }

    static void save() {

        try {
            FileWriter fw = new FileWriter("data.txt");

            for (Student s : arr) {
                fw.write(s.getData() + "\n");
            }

            fw.close();
        } catch (Exception e) {
            System.out.println("Save error");
        }
    }

    static void load() {

        try {
            File f = new File("data.txt");

            if (!f.exists()) return;

            Scanner fs = new Scanner(f);

            while (fs.hasNextLine()) {

                String line = fs.nextLine();
                String[] p = line.split(",");

                if (p.length == 3) {
                    arr.add(new Student(p[0], Integer.parseInt(p[1]), p[2]));
                }
            }

            fs.close();
        } catch (Exception e) {
            System.out.println("Load error");
        }
    }
}