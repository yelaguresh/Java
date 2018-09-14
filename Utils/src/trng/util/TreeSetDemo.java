package trng.util;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetDemo {

	public static void main(String a[]) {
		// By using name comparator (String comparison)
		TreeSet<Empl> empNameTreeSet = new TreeSet<Empl>(new MyNameComp());
		empNameTreeSet.add(new Empl("Ram", 3000));
		empNameTreeSet.add(new Empl("John", 6000));
		empNameTreeSet.add(new Empl("Crish", 2000));
		Empl tomEmpl = new Empl("Tom", 2400);
		empNameTreeSet.add(tomEmpl);
		for (Empl e : empNameTreeSet) {
			System.out.println(e);
		}
		System.out.println("===========================");
		// By using salary comparator (int comparison)
		TreeSet<Empl> empSalaryTreeSet = new TreeSet<Empl>(new MySalaryComp());
		empSalaryTreeSet.add(new Empl("Ram", 3000));
		empSalaryTreeSet.add(new Empl("John", 6000));
		empSalaryTreeSet.add(new Empl("Crish", 2000));
		empSalaryTreeSet.add(new Empl("Tom", 2400));
		for (Empl e : empSalaryTreeSet) {
			System.out.println(e);
		}
		
		// Sorting the Employees in descending order
		System.out.println("===========================");
		System.out.println("Employees in descending order by salary");
		Iterator<Empl> descendingIterator = empSalaryTreeSet.descendingIterator();
		while(descendingIterator.hasNext()) {
			System.out.println(descendingIterator.next());
		}
		
		System.out.println("First Employee: " + empNameTreeSet.first());
		System.out.println("Last Employee: " + empNameTreeSet.last());
		empNameTreeSet.remove(tomEmpl);
		System.out.println("Last Employee(after removing tom): " + empNameTreeSet.last());
		empNameTreeSet.clear();
	}
}

class MyNameComp implements Comparator<Empl> {

	@Override
	public int compare(Empl e1, Empl e2) {
		return e1.getName().compareTo(e2.getName());
	}
}

class MySalaryComp implements Comparator<Empl> {

	@Override
	public int compare(Empl e1, Empl e2) {
		if (e1.getSalary() > e2.getSalary()) {
			return 1;
		} else {
			return -1;
		}
	}
}

class Empl {

	private String name;
	private int salary;

	public Empl(String n, int s) {
		this.name = n;
		this.salary = s;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String toString() {
		return "Name: " + this.name + "-- Salary: " + this.salary;
	}
}
