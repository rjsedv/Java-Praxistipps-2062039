package de.rjs.boxing_unboxing;
/*
 * Besser für Performance
 */

public class PrimitivDemoPerformance {
    public static void main(String[] args) {
        int n = 10_000_000;

        int[] array = new int[n]; // primitive int-Array

        long start = System.currentTimeMillis();

        // Direkte Arbeit mit primitiven int
        for (int i = 0; i < n; i++) {
            array[i] = i;
        }

        long sum = 0;

        for (int i = 0; i < n; i++) {
            sum += array[i];
        }

        long end = System.currentTimeMillis();
        System.out.println("Summe: " + sum);
        System.out.println("Dauer ohne Boxing: " + (end - start) + " ms");
    }
}
