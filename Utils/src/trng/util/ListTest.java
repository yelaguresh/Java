package trng.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import trng.generics.ex2.Emp;

public class ListTest {

	public static void main(String[] args) {
//		simpleList();
		complextList();
	}
	
	private static void complextList() {
		List<Employee> empList = new ArrayList<>();
		
		long time = new Date().getTime();
		for(int i=0; i<5000000; i++) {
			empList.add(new Employee(i + 1, "Raj" + "-" + i, "Kumar"));
		}
		System.out.println(" Total time to add all elements: " + (new Date().getTime() - time));
		
		Employee e = new Employee(449998, "Raj-449997", "Kumar");
		
		time = new Date().getTime();
		System.out.println("is given employee present in list: " + empList.contains(e));
		System.out.println(" Total time is: " + (new Date().getTime() - time));
		
//		Collections.sort(empList);
	}

	public static void simpleList() {

		List<Integer> numbers = new ArrayList<>();
		
		numbers.add(1);
		numbers.add(6);
		numbers.add(6);
		numbers.add(8);
		numbers.add(3);
		numbers.add(13);
		numbers.add(7);
		numbers.add(2);
//		numbers.add("Manohar");
//		numbers.add(new Employee());
		
		int sum = 0;

		System.out.println("Origional data");
		for (Integer num : numbers) {
			System.out.println(num);
/*			if (num == 6) {
				numbers.remove(num);
			}*/
		}
		
		System.out.println("element 6 remove, data is: ");
		for (Iterator iterator = numbers.iterator(); iterator.hasNext();) {
			Integer num = (Integer) iterator.next();
			
			if(num == 6) {
				iterator.remove();
			}
		}
		
		
		for (Integer num : numbers) {
			sum = sum + num;
			System.out.println(num);
		}
		
//		for (int i = 0; i < numbers.size(); i++) {
//			sum += numbers.get(i);;
//		}
		
		System.out.println("sum is: " + sum);
		
		
		numbers.add(3, 60);
		
		Collections.sort(numbers);
		
		System.out.println("element 60 added, and sorted data is: ");
		for (Integer number : numbers) {
			System.out.println(number);
		}

		System.out.println("Element 60 removed, data is");
		boolean flag = numbers.remove(new Integer(60));
		
		if(flag) {
			System.out.println("Deleted Successfully");
		} else {
			System.out.println("Element Not deleted");
		}
		
		for (Integer number : numbers) {
			System.out.println(number);
		}
	
	}

}
