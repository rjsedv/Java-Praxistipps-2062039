/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.rjs.immutableobjects.defensiv;

/**
 *
 * @author ralph
 */
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> hobbies = new ArrayList<>();
        hobbies.add("Lesen");
        hobbies.add("Schwimmen");

        Person p1 = new Person("Alice", 30, hobbies);

        // Versuch, die interne Liste zu ändern
        p1.getHobbies().add("Laufen"); // wirft keinen Fehler, ändert aber **nicht** das Objekt
        System.out.println(p1.getHobbies()); // [Lesen, Schwimmen] – unverändert

        // Neue Version des Objekts erstellen
        Person p2 = p1.withAddedHobby("Laufen");
        System.out.println(p2.getHobbies()); // [Lesen, Schwimmen, Laufen]
        System.out.println(p1.getHobbies()); // [Lesen, Schwimmen] – Original bleibt unverändert
    }
}
