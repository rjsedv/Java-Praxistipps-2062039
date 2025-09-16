/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.rjs.concurrency;

/**
 *
 * @author ralph
 */
public class CounterExampleRaceCondition {
    
    // volatile sorgt nur für Sichtbarkeit, nicht für Atomarität
    private static volatile int count = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> incrementCounter(1000));
        Thread t2 = new Thread(() -> incrementCounter(1000));

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Endwert von count: " + count);
    }

    private static void incrementCounter(int times) {
        for (int i = 0; i < times; i++) {
            count++; // ❌ Race Condition!
        }
    }
}
