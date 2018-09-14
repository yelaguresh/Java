package trng.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapTest {

	public static void main(String[] args) {
		simpleUse();
//		complexUse();
	}
	
	private static void complexUse() {
		Employee e1 = new Employee(1, "Raj", "Kumar");
		Employee e2 = new Employee(1, "David", "Kumar");
		Employee e3 = new Employee(1, "Raj", "Kumar");
		
		System.out.println(e1.equals(e2));
		System.out.println(e1.hashCode() == e2.hashCode());
		System.out.println(e1.hashCode() == e3.hashCode());
		System.out.println(e1.equals(e3));

		Map<Employee, String> map = new HashMap<Employee, String>();
		map.put(e1, e1.firstName);
		map.put(e2, e2.firstName);
		
		System.out.println("Total values in map: " + map.size());
		System.out.println("Value of e1: " + map.get(e1));
		System.out.println("Value of e2: " + map.get(e2));
		System.out.println("Value of e3: " + map.get(e3));

		map.put(e3, "NewName");
		System.out.println("Value of e2: " + map.get(e1));
		System.out.println("Value of e3: " + map.get(e3));

		Map<String, Employee> nameAndEmployeeMap = new HashMap<>();
		nameAndEmployeeMap.put(e1.firstName, e1);
		System.out.println("Value is: " + map.get(e1.firstName));
	}

	public static void simpleUse() {
		Map<Integer, String> namesMap = new HashMap<>();

		namesMap.put(100, "Raju");
		namesMap.put(101, "John");
		namesMap.put(102, "Pingel");
		namesMap.put(100, "Kala");
		namesMap.put(106, "David");
		namesMap.put(109, "Praveen");

		System.out.println("Values in the map are: ");
		Set<Entry<Integer, String>> entrySet = namesMap.entrySet();
		for (Entry<Integer, String> entry: entrySet) {
			System.out.println(entry.getKey() + " - " + entry.getValue());
		}

		System.out.println(" Name for the key: 106 is " + namesMap.get(106));

		namesMap.remove(106);

		System.out.println("Values after removing 106");
		Set<Integer> keys = namesMap.keySet();
		for (Integer key : keys) {
			System.out.println(key + " - " + namesMap.get(key));
		}
		
		Map<Integer, String> syncMap = Collections.synchronizedMap(namesMap);
		Collections.unmodifiableMap(namesMap);
	}

}
