/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.rjs.designpattern.wiesingleton;

/**
 *
 * @author ralph
 */
/**
 *
 * @author ralph
 */
// Singleton-Klassepublic 
class Logger {
    private static int instanceCount = 0;
    private static Logger instance;

    private Logger() {
        instanceCount++;
        if (instanceCount > 1) {
            throw new RuntimeException("Nur eine Instanz erlaubt!");
        }
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("[LOG] " + message);
    }
}


// Demo
public class WieSingleton {
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
