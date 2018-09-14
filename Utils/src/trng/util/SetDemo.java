package trng.util;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import com.rsa.cryptoj.c.it;

public class SetDemo {

	public static void main(String[] args) {
		Set<String> namesSet = new HashSet<>() ;
		Scanner scanner = new Scanner(System.in);
		
		String name = null;
		System.out.println("Enter names in each line, type exit to exit");
		do {
			name = scanner.nextLine();
			if(name.equalsIgnoreCase("exit")) 
				break;
			namesSet.add(name);
		} while(name != null);
		
		//display
		System.out.println("Given names");
		for(String nam: namesSet) {
			System.out.println(nam);
		}
		
		System.out.println("Enter name to search");
		name = scanner.nextLine();
		if(namesSet.contains(name)) {
			System.out.println("Found");
		} else {
			System.out.println("Not Found");
		}
		
		System.out.println("Enter name to add");
		name = scanner.nextLine();
		
		if(namesSet.add(name)) {
			System.out.println("added successfully");
		} else {
			System.out.println("already present");
		}

		System.out.println("names after adding");
		Iterator<String> iterator = namesSet.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		System.out.println("Enter name to remove");
		name = scanner.next();
		if(namesSet.remove(name)) {
			System.out.println("removed successfully");
		} else {
			System.out.println("Can't find given name");
		}
		
		System.out.println("names in uppercase");
		for(String nam: namesSet) {
			System.out.println(nam.toUpperCase());
		}
		
		System.out.println("do you like to clear the collection");
		boolean flag = scanner.nextBoolean();
		if(flag) {
			namesSet.clear();
		}
		
		System.out.println("names after clearing");
		for(String nam: namesSet) {
			System.out.println(nam.toUpperCase());
		}
	}

}

