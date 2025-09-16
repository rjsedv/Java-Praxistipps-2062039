/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.rjs.immutableobjects.nichtdefensiv;

/**
 *
 * @author ralph
 */
import java.util.List;

public final class Person {
    private final String name;
    private final List<String> hobbies;

    public Person(String name, List<String> hobbies) {
        this.name = name;
        this.hobbies = hobbies; // Problem: direkte Referenz
    }

    public List<String> getHobbies() {
        return hobbies; // Problem: kann von außen verändert werden
    }
}
