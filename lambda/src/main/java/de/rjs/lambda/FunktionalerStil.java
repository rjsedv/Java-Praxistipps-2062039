/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.rjs.lambda;

/**
 *
 * @author ralph
 */


public class FunktionalerStil {
    
    // Methode, die eine Funktion als Parameter annimmt
    public static void ausfuehren(int x, int y, Rechner funktion) {
        int ergebnis = funktion.berechne(x, y);
        System.out.println("Ergebnis: " + ergebnis);
    }

    public static void main(String[] args) {
        // Lambda für Addition
        Rechner addieren = (a, b) -> a + b;

        // Lambda für Subtraktion
        Rechner subtrahieren = (a, b) -> a - b;

        // Lambda für Multiplikation
        Rechner multiplizieren = (a, b) -> a * b;

        System.out.println("5 + 3 = ");
        ausfuehren(5, 3, addieren);

        System.out.println("5 - 3 = ");
        ausfuehren(5, 3, subtrahieren);

        System.out.println("5 * 3 = ");
        ausfuehren(5, 3, multiplizieren);

        // Direkt als Lambda übergeben, ohne separate Variable
        System.out.println("5 / 2 = ");
        ausfuehren(5, 2, (a, b) -> a / b);
    }
}
