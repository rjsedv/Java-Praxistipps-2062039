package de.rjs.boxing_unboxing;

import java.util.ArrayList;
/*
 * Schlecht für Performance
 */

public class BoxingDemoPerformanceProblem {
    public static void main(String[] args) {
        int n = 10_000_000;

        ArrayList<Integer> list = new ArrayList<>();
        
        long start = System.currentTimeMillis();

        // Auto-Boxing bei jedem add
        for (int i = 0; i < n; i++) {
            list.add(i); // int → Integer (Auto-Boxing)
        }

        long sum = 0;

        // Auto-Unboxing bei jedem Zugriff
        for (int i = 0; i < n; i++) {
            sum += list.get(i); // Integer → int (Auto-Unboxing)
        }

        long end = System.currentTimeMillis();
        System.out.println("Summe: " + sum);
        System.out.println("Dauer mit Boxing: " + (end - start) + " ms");
    }
}
