import exception.abstracts.PrintException;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("Hello World!");
        } catch (PrintException e) {
            System.out.println(e.getMessage());
        }
    }
}
