package de.rjs.equals_hashcode.problem;

import java.util.HashSet;

class Person {
	   public Person(String name, int alter) {
	        this.name = name;
	        this.alter = alter;
	    }

	String name;
    int alter;
}


public class CollectionsProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p1 = new Person("Anna", 25);
		Person p2 = new Person("Anna", 25);

		HashSet<Person> set = new HashSet<>();
		set.add(p1);
		System.out.println(p1 == p2); // natürlich false, weil unterschiedliche Objekte
		System.out.println(p1.equals(p2)); // ebenso false, weil unterschiedliche Objekte und keine passende Vergleichsmethode
		System.out.println("p1.hashCode():\t" + p1.hashCode() + ",\tp2.hashCode():\t" +  p2.hashCode());// verschiedene Hashcodes, weil unterschiedliche Objekte

		System.out.println(set.contains(p2)); // liefert aber auch false ohne korrekte equals() und hashCode()
		

	}

}
