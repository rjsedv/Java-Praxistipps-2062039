/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package de.rjs.lambda;

/**
 *
 * @author ralph
 */
public class LambdaDemo {
    public static void main(String[] args) {
        // Lambda für Addition
        Rechner addieren = (a, b) -> a + b;

        // Lambda für Multiplikation
        Rechner multiplizieren = (a, b) -> a * b;

        System.out.println("5 + 3 = " + addieren.berechne(5, 3));
        System.out.println("5 * 3 = " + multiplizieren.berechne(5, 3));
    }
}
