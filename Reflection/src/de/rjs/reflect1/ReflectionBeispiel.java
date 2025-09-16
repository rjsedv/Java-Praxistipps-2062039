package de.rjs.reflect1;

import java.lang.reflect.*;

class Person {
    private String name;
    private int alter;

    public Person(String name, int alter) {
        this.name = name;
        this.alter = alter;
    }

    private void sagHallo() {
        System.out.println("Hallo, mein Name ist " + name + " und ich bin " + alter + " Jahre alt.");
    }
}

public class ReflectionBeispiel {
    public static void main(String[] args) throws Exception {
        // Objekt erstellen
        Person p = new Person("Florian", 25);

        // Klasse über Reflection holen
        Class<?> clazz = p.getClass();

        // Klassenname ausgeben
        System.out.println("Klassenname: " + clazz.getName());

        // Felder anzeigen
        System.out.println("\nFelder:");
        for (Field f : clazz.getDeclaredFields()) {
            System.out.println(" - " + f.getName() + " (" + f.getType().getSimpleName() + ")");
        }

        // Privates Feld "name" zugänglich machen und Wert ändern
        Field feldName = clazz.getDeclaredField("name");
        feldName.setAccessible(true);
        feldName.set(p, "Felix"); // neuen Wert setzen

        // Methoden anzeigen
        System.out.println("\nMethoden:");
        for (Method m : clazz.getDeclaredMethods()) {
            System.out.println(" - " + m.getName());
        }

        // Private Methode "sagHallo" aufrufen
        Method methodeHallo = clazz.getDeclaredMethod("sagHallo");
        methodeHallo.setAccessible(true);
        methodeHallo.invoke(p);
    }
}
