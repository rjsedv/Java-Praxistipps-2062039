package de.rjs.kopierbeispiel1;

class Addresse {
    String ort;

    Addresse(String ort) {
        this.ort = ort;
    }
}

class Person implements Cloneable {
    String name;
    Addresse addresse;

    Person(String name, Addresse addresse) {
        this.name = name;
        this.addresse = addresse;
    }

    // Shallow Copy mit clone()
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); // nur die Referenzen werden kopiert
    }
    // Deep Copy manuell implementiert
    public Person deepCopy() {
        return new Person(this.name, new Addresse(this.addresse.ort));
    }

}

public class KopierBeispiel {
    public static void main(String[] args) throws CloneNotSupportedException {
        // Original
        Person original = new Person("Felix",new Addresse("Bodenheim"));

        // Shallow Copy
        Person shallow = (Person) original.clone();

        // Deep Copy
        Person deep = original.deepCopy();
        System.out.println("original.addresse.ort vor einer Änderung");
        System.out.println("Original: " + original.addresse.ort);
        System.out.println("Shallow Copy: " + shallow.addresse.ort);
        System.out.println("Deep Copy: " + deep.addresse.ort);
        // Änderung an innerem Objekt
        original.addresse.ort = "Sontra";

        System.out.println("Original: " + original.addresse.ort);
        System.out.println("Shallow Copy: " + shallow.addresse.ort);
        System.out.println("Deep Copy: " + deep.addresse.ort);
    }
}