package trng.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class ArrayListTest {

	public static void main(String[] args) {
		List<String> names = new ArrayList<>();
		String name = null;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the words, one in each line. At last presss enter twice");
		do {
			name = scanner.nextLine();
			names.add(name);
		} while (! name.isEmpty());

		System.out.println("Words entred in the order \n");
		Iterator<String> itr = names.iterator();
		
		while(itr.hasNext()) {
			name = itr.next();
			System.out.println(name);
			
			if (name.equals("Raj")) {
				itr.remove();
			}
		}
		
		System.out.println("Words after soring \n");
		Collections.sort(names);
		
		for (String name1 : names) {
			System.out.println(name1);
		}
		
		scanner.close();
	}
}
