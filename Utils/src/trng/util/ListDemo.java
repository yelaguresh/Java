package trng.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ListDemo {

	public static void main(String[] args) {
		List<String> namesList = new ArrayList<>() ;
		Scanner scanner = new Scanner(System.in);
		doSomething(namesList);
		String name = null;
		System.out.println("Enter names in each line, type exit to exit");
		do {
			name = scanner.nextLine();
			if(name.equalsIgnoreCase("exit")) 
				break;
			namesList.add(name);
		} while(name != null);
		
		//display
		System.out.println("Given names in the same order");
		for(String nam: namesList) {
			System.out.println(nam);
		}
		
		System.out.println("Enter name to search");
		name = scanner.nextLine();
		if(namesList.contains(name)) {
			System.out.println("Found");
		} else {
			System.out.println("Not Found");
		}
		
		Collections.sort(namesList);
		System.out.println("Given names in with sorted order");
		for(String nam: namesList) {
			System.out.println(nam);
		}
		
		System.out.println("Enter name to insert");
		name = scanner.nextLine();
		
		System.out.println("Enter position to insert");
		int index = scanner.nextInt();
		if (index < namesList.size()) {
			namesList.add(index, name);
		} else {
			System.out.println("can't add");
		}

		System.out.println("names after adding");
		for(String nam: namesList) {
			System.out.println(nam);
		}
		
		System.out.println("Enter name to remove");
		name = scanner.next();
		if(namesList.remove(name)) {
			System.out.println("removed successfully");
		} else {
			System.out.println("Can't find given name");
		}
		
		System.out.println("names in uppercase");
		for(String nam: namesList) {
			System.out.println(nam.toUpperCase());
		}
		
		System.out.println("do you like to clear the collection(true/false)");
		boolean flag = scanner.nextBoolean();
		if(flag) {
			namesList.clear();
		}
		
		System.out.println("names after clearing");
		for(String nam: namesList) {
			System.out.println(nam.toUpperCase());
		}
	}

	private static void doSomething(List<String> namesList) {
		// TODO Auto-generated method stub
		
	}

}
