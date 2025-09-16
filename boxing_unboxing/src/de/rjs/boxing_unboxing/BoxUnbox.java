package de.rjs.boxing_unboxing;

import java.util.ArrayList;
import java.util.List;

public class BoxUnbox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 10;
		Integer boxedA = a; // Auto-Boxing: primitiver int wird automatisch in Integer umgewandelt
		
		int b = boxedA;        // Auto-Unboxing
		ArrayList<Integer> numbers = new ArrayList<>();

        

        // Auto-Boxing: primitiver int wird zu Integer
        numbers.add(a);

        // Auto-Unboxing: Integer wird zu int
        int y = numbers.get(0);

        System.out.println("y = " + y);
        
        // Integration mit generischen Typen
        List<Double> values = new ArrayList<>();
        values.add(3.14); // Auto-Boxing von double → Double
        System.out.println(values.get(0));
	}

}
