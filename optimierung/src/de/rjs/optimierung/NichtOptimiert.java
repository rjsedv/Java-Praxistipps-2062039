/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package de.rjs.optimierung;


import java.util.*;

/**
 *
 * @author ralph
 */
public class NichtOptimiert {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 1_000_000; i++) {
            numbers.add(i);
        }

        int sum = 0;
        for (Integer n : numbers) {
            if (n % 2 == 0) {
                sum += n;
            }
        }

        System.out.println("Summe: " + sum);
    }
}
