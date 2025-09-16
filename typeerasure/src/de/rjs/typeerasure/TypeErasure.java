package de.rjs.typeerasure;

import java.util.ArrayList;
import java.util.List;

public class TypeErasure {

	public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("Hallo");
		List<Integer> intList = new ArrayList<>();
		intList.add(42);
	    System.out.println(stringList.getClass());
        System.out.println(intList.getClass());
		Object obj = intList.get(0);
		System.out.println(obj.getClass()); // Typ zur Laufzeit bekannt

	}

}
