package de.rjs.reflect3;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

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
/*
Verschiedene Wege, ein Class-Objekt zu bekommen
 */
public class ReflectionBeispiel {
    public static void main(String[] args) throws Exception {
        //Person p = new Person("Anna", 25);

        // 1. Über .class Literal (statisch, zur Compilezeit bekannt)
        Class clazz1 = Person.class;

// 2. Über eine Instanz (zur Laufzeit ermittelt)
        Person p = new Person("Anna", 25);
        Class clazz2 = p.getClass();

// 3. Über den Namen (dynamisch, zur Laufzeit geladen)
       Class clazz3 = Class.forName("de.rjs.reflect3.Person"); // Achtung - vollqualifiziert


        System.out.println("Klassenname 1: " + clazz1.getName());
        System.out.println("Klassenname 2: " + clazz2.getName());
       // System.out.println("Klassenname 3: " + clazz3.getName());
        // Felder ausgeben clazz1
        Field[] felder = clazz1.getDeclaredFields();
        for (int i = 0; i < felder.length; i++) {
            Field f = felder[i];
            System.out.println("Feld: " + f.getName() + " (" + f.getType().getName() + ")");
        }

        // Privates Feld ändern clazz2
        Field feldName = clazz2.getDeclaredField("name");
        feldName.setAccessible(true);
        feldName.set(p, "Max");

        // Private Methode aufrufen clazz3
        Method m = clazz3.getDeclaredMethod("sagHallo");
        m.setAccessible(true);
        m.invoke(p);
    }
}
