package de.rjs.finale;

public class FinallyBeispiel {
    public static void main(String[] args) {
        System.out.println(testMethode());
    }

    static int testMethode() {
        try {
            System.out.println("Im try-Block");
            return 42; // return löst Sprung aus
        } catch (Exception e) {
            System.out.println("Im catch-Block");
        } finally {
            System.out.println("Im finally-Block (immer ausgeführt!)");
        }
        return -1; 
    }
}
