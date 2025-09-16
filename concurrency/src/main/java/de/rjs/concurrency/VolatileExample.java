/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.rjs.concurrency;

/**
 *
 * @author ralph
 */
public class VolatileExample {
    // volatile sorgt dafür, dass Änderungen sofort sichtbar sind
    private static volatile boolean running = true;

    public static void main(String[] args) throws InterruptedException {
        Thread worker = new Thread(() -> {
            System.out.println("Worker startet...");
            while (running) {
                // Arbeitet, bis running auf false gesetzt wird
            }
            System.out.println("Worker beendet.");
        });

        worker.start();

        // Hauptthread wartet 2 Sekunden
        Thread.sleep(2000);

        System.out.println("Stoppe Worker...");
        running = false; // sofort sichtbar für den Worker

        worker.join(); // Warten bis Worker beendet
        System.out.println("Programm beendet.");
    }
}
