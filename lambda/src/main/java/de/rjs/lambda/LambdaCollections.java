/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.rjs.lambda;

/**
 *
 * @author ralph
 */
import java.util.Arrays;
import java.util.List;

public class LambdaCollections {
    public static void main(String[] args) {
        List<String> namen = Arrays.asList("Anna", "Bob", "Clara");

        // Früher (anonyme Klasse)
        /*
        namen.forEach(new Consumer<String>() {
            public void accept(String s) {
                System.out.println(s);
            }
        });
        */

        // Mit Lambda
        namen.forEach(s -> System.out.println(s));

        // Oder noch kürzer mit Method Reference
        namen.forEach(System.out::println);
    }
}
