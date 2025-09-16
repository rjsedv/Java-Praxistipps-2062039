package de.rjs.equals_hashcode.noproblem;

import java.util.HashSet;


import java.util.Objects;

class Person {
    String name;
    int alter;

    public Person(String name, int alter) {
        this.name = name;
        this.alter = alter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;                  // gleiche Referenz
        if (o == null || getClass() != o.getClass()) return false; // falscher Typ
        Person person = (Person) o;
        return alter == person.alter && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, alter);
    }
}


public class CollectionsNoProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p1 = new Person("Anna", 25);
		Person p2 = new Person("Anna", 25);

		HashSet<Person> set = new HashSet<>();
		set.add(p1);
		System.out.println(p1 == p2); // natürlich weiter false, weil unterschiedliche Objekte
		System.out.println(p1.equals(p2)); // true, weil zwar unterschiedliche Objekte, aber equals passend überschrieben
		System.out.println("p1.hashCode():\t" + p1.hashCode() + ",\tp2.hashCode():\t" +  p2.hashCode()); // gleichee Hashcodes, weil hascode passend überschrieben

		System.out.println(set.contains(p2)); // liefert jetzt auch true, da korrekte equals() und hashCode()
		


	}

}
