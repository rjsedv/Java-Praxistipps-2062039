package de.rjs.kopierbeispiel2;


class Addresse {
    String ort;

    Addresse(String ort) {
        this.ort = ort;
    }

    // Copy-Konstruktor für tiefe Kopie
    Addresse(Addresse other) {
        this.ort = other.ort;
    }
}

class Person {
    String name;
    Addresse addresse;

    Person(String name, Addresse addresse) {
        this.name = name;
        this.addresse = addresse;
    }

    // Statische Methode für Shallow Copy
    public static Person shallowCopy(Person other) {
        return new Person(other.name, other.addresse); // nur Referenz
    }

    // Statische Methode für Deep Copy
    public static Person deepCopy(Person other) {
        return new Person(other.name, new Addresse(other.addresse)); // neue Addresse
    }
}

public class KopierBeispiel {
    public static void main(String[] args) {
        // Original
        Person original = new Person("Felix", new Addresse("Bodenheim"));

        // Shallow Copy
        Person shallow = Person.shallowCopy(original);

        // Deep Copy
        Person deep = Person.deepCopy(original);

        System.out.println("original.addresse.ort vor einer Änderung");
        System.out.println("Original: " + original.addresse.ort);
        System.out.println("Shallow Copy: " + shallow.addresse.ort);
        System.out.println("Deep Copy: " + deep.addresse.ort);

        // Änderung am inneren Objekt
        original.addresse.ort = "Sontra";

        System.out.println("\nNach Änderung:");
        System.out.println("Original: " + original.addresse.ort);
        System.out.println("Shallow Copy: " + shallow.addresse.ort);
        System.out.println("Deep Copy: " + deep.addresse.ort);
    }
}
