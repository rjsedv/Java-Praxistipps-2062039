package de.rjs.reflect2;
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
        Person p = new Person("Anna", 25);

        // "Roh" ohne Generics
        Class clazz = p.getClass();

        System.out.println("Klassenname: " + clazz.getName());

        // Felder ausgeben
        Field[] felder = clazz.getDeclaredFields();
        for (int i = 0; i < felder.length; i++) {
            Field f = felder[i];
            System.out.println("Feld: " + f.getName() + " (" + f.getType().getName() + ")");
        }

        // Privates Feld ändern
        Field feldName = clazz.getDeclaredField("name");
        feldName.setAccessible(true);
        feldName.set(p, "Max");

        // Private Methode aufrufen
        Method m = clazz.getDeclaredMethod("sagHallo");
        m.setAccessible(true);
        m.invoke(p);
    }
}
