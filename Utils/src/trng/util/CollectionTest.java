package trng.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class CollectionTest {

	public static void main(String[] args) {
		Set<Integer> numbers = new HashSet<>();
		Scanner scanner = new Scanner(System.in);
		int number;
		System.out.println("Enter the numbers");
		do {
			number = scanner.nextInt();
			numbers.add(number);
		} while (number != 0);

		System.out.println("the numbers entered are");
		Iterator<Integer> it = numbers.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + "\n");
		}
		
		
		System.out.println("the words after sorting");
		List<Integer> sortedlist = new ArrayList<>(numbers);
		Collections.sort(sortedlist);
		for (Integer x : sortedlist) {
			System.out.println(x);
		}
		
		
		System.out.println("enter the number to search\n");
		Integer searchNum = scanner.nextInt();
		if (sortedlist.contains(searchNum)) {
			System.out.println("the number found");

		} else {
			System.out.println("the number not found");
		}
		
		System.out.println("Enter the number");
		String indexSearchnumber = scanner.next();
		int index = sortedlist.indexOf(indexSearchnumber);
		System.out.print("Your value is present at index: " + index);
		
		
		System.out.println("After insertion");
		Integer numberToInsert = scanner.nextInt();
		sortedlist.add(3, numberToInsert);
		for (Integer x : sortedlist) {
			System.out.println(x);
		}
	}
}
