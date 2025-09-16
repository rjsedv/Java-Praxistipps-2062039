/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.rjs.designpattern.singleton;



/**
 *
 * @author ralph
 */
// Singleton-Klasse
class Logger {
    // 1. Private statische Instanz (einzige Instanz)
    private static Logger instance;

    // 2. Privater Konstruktor verhindert externe Instanziierung
    private Logger() {
        // Initialisierungscode, z.B. Log-Datei öffnen
    }

    // 3. Öffentliche Methode zum Abrufen der Instanz
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger(); // Instanz wird nur einmal erstellt
        }
        return instance;
    }

    // Beispielmethode
    public void log(String message) {
        System.out.println("[LOG] " + message);
    }
}

// Demo
public class SingletonDemo {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("Erste Nachricht");
        logger2.log("Zweite Nachricht");

        // Prüfen, ob beide Variablen auf die gleiche Instanz zeigen
        if (logger1 == logger2) {
            System.out.println("Beide Logger-Objekte sind identisch!");
        }
    }
}
