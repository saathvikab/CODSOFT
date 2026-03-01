public class Student {

    String n;
    int r;
    String g;

    Student(String n, int r, String g) {
        this.n = n;
        this.r = r;
        this.g = g;
    }

    String getData() {
        return n + "," + r + "," + g;
    }
}