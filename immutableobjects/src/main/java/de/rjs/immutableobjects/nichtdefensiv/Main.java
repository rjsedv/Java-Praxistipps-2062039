/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.rjs.immutableobjects.nichtdefensiv;

import java.util.ArrayList;
import java.util.List;

public class Main {
  /**
 *
 * @author ralph
 */

    public static void main(String[] args) {
 List<String> hobbyListe = new ArrayList<>();
hobbyListe.add("Lesen");

Person p = new Person("Alice", hobbyListe);
p.getHobbies().add("Schwimmen"); // Ändert die interne Liste von p!
System.out.println(p.getHobbies());
    }  
}
