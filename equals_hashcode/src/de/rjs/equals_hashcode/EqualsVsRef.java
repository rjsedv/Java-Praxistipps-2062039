package de.rjs.equals_hashcode;

public class EqualsVsRef {

	public static void main(String[] args) {
		String a = new String("Hallo");
		String b = new String("Hallo");
		System.out.println(a.equals(b)); // true
		System.out.println(a == b);      // false
		String c = "Hallo";
		String d = "Hallo";
		System.out.println(c.equals(d)); // true
		System.out.println(c == d);      // true


	}

}
