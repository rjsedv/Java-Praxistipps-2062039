/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.rjs.immutableobjects.defensiv;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Person {
    private final String name;
    private final int age;
    private final List<String> hobbies;

    public Person(String name, int age, List<String> hobbies) {
        this.name = name;
        this.age = age;
        // Defensive Kopie der Liste, um Mutationen von außen zu verhindern
        this.hobbies = new ArrayList<>(hobbies);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Defensive Kopie zurückgeben
    public List<String> getHobbies() {
        return new ArrayList<>(hobbies);
    }

    // Beispiel einer "Modifikationsmethode", die ein neues Objekt zurückgibt
    public Person withAge(int newAge) {
        return new Person(this.name, newAge, this.hobbies);
    }

    public Person withAddedHobby(String hobby) {
        List<String> newHobbies = new ArrayList<>(this.hobbies);
        newHobbies.add(hobby);
        return new Person(this.name, this.age, newHobbies);
    }
}
