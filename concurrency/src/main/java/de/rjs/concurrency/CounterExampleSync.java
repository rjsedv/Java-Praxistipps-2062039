/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.rjs.concurrency;

/**
 *
 * @author ralph
 */
class CounterExampleSync {
    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> incrementCounter(1000));
        Thread t2 = new Thread(() -> incrementCounter(1000));

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Endwert von count: " + count);
    }

    // synchronisierte Methode garantiert Atomarität
    private static synchronized void incrementCounter(int times) {
        for (int i = 0; i < times; i++) {
            count++; // ✅ jetzt atomar
        }
    }
}
