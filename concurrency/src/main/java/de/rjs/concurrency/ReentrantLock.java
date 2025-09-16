/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.rjs.concurrency;

/**
 *
 * @author ralph
 */
import java.util.concurrent.locks.ReentrantLock;

class ReentrantLockExample {
    private static final ReentrantLock lock = new ReentrantLock();
    private static int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(ReentrantLockExample::increment);
        Thread t2 = new Thread(ReentrantLockExample::increment);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Endwert von counter: " + counter);
    }

    private static void increment() {
        for (int i = 0; i < 1000; i++) {
            lock.lock(); // Lock wird erworben
            // Ausnahmebehandlung zwingend, um Deadlocks zu vermeiden
            try {
                counter++; // kritischer Abschnitt
            } finally {
                lock.unlock(); // Lock wird immer freigegeben
            }
        }
    }
}
