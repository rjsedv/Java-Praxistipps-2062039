package de.rjs.speicherverwaltung;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;

public class HeapVerbrauch {
    public static void main(String[] args) {
        MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();

        // Vor dem GC
        printHeap("Vor dem GC", memoryBean);

        // Viele Objekte erzeugen und gleich wieder "vergessen"
        for (int i = 0; i < 1_000_000; i++) {
            String data = new String("Objekt " + i);
        }

        // Vorher nochmal messen
        printHeap("Nach Objekterzeugung (vor GC)", memoryBean);

        // Garbage Collection anfordern
        System.gc();

        // Kurze Pause, damit GC auch Zeit bekommt
        try { Thread.sleep(2000); } catch (InterruptedException ignored) {}

        // Nach dem GC
        printHeap("Nach dem GC", memoryBean);
    }

    private static void printHeap(String phase, MemoryMXBean memoryBean) {
        MemoryUsage heapUsage = memoryBean.getHeapMemoryUsage();
        long used = heapUsage.getUsed() / (1024 * 1024);
        long max  = heapUsage.getMax() / (1024 * 1024);
        System.out.printf("%s: benutzt = %d MB, max = %d MB%n", phase, used, max);
    }
}
