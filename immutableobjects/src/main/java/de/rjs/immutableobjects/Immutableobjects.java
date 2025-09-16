/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package de.rjs.immutableobjects;

/**
 *
 * @author ralph
 */
public class Immutableobjects {

    public static void main(String[] args) {
        Person p1 = new Person("Felix", 25);

        // Zustand von p1 kann abgefragt werden
        System.out.println(p1.getName()); 
        System.out.println(p1.getAge()); 

        // "Änderung" erzeugt ein neues Objekt
        Person p2 = p1.newName("Florian");
        System.out.println(p2.getName());  // "Forian"
        System.out.println(p1.getName());  // "Felix" (unverändert)
    }
}
