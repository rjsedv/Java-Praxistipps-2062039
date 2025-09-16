/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package de.rjs.optimierung;




/**
 *
 * @author ralph
 */
public class Optimiert {

    public static void main(String[] args) {
        int n = 1_000_000;

           // Summe der geraden Zahlen: 2 + 4 + ... + 1_000_000
        int sum = n / 2 * (2 + n); // Formel: n/2 * (erstes + letztes)

        System.out.println("Summe: " + sum);
    }
}
