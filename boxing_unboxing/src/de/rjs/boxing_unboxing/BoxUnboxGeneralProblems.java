package de.rjs.boxing_unboxing;

public class BoxUnboxGeneralProblems {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer sum = 0;
		for (int i = 0; i < 1000000; i++) {
			sum += i; // Auto-Boxing und Auto-Unboxing bei jedem Schritt
		}
		try {
			Integer value = null;
			int x = value; // NullPointerException!

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		Integer a = 128;
		Integer b = 128;
		System.out.println(a == b); // false, weil unterschiedliche Objekte
		System.out.println(a.equals(b)); // true, korrekter Vergleich

	}

}
