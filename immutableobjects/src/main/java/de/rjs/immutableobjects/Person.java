/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.rjs.immutableobjects;

/**
 *
 * @author ralph
 */
public final class Person { // final verhindert Unterklassen
    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter-Methoden
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Beispiel für eine "Modifikation", die ein neues Objekt zurückgibt
    public Person newName(String name) {
        return new Person(name, this.age);
    }
}
