package trng.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * implementing Comparable allows Student objects sortable using Collections API.
 */

class ComparableStudent implements Comparable<ComparableStudent> {

	private int studentId;
	private String name;
	private int marks;
	
	public ComparableStudent(int studentId, String name, int marks) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.marks = marks;
	}
	
	public ComparableStudent() {
		
	}

	@Override
	public int compareTo(ComparableStudent another) {
	    final int BEFORE = -1;
	    final int EQUAL = 0;
	    final int AFTER = 1;

	    //First compare by studentId
		if (studentId > another.studentId) return AFTER;
		if (studentId < another.studentId) return BEFORE;

		//Then compare by name
		if (name.compareTo(another.name) > 0) return AFTER;
		if (name.compareTo(another.name) < 0) return BEFORE;
		
		//Then compare by marks
		if (marks > another.marks) return AFTER;
		if (marks < another.marks) return BEFORE;
		
		return EQUAL;
	}

	@Override
	public String toString() {
		return "ComparableStudent [studentId=" + studentId + ", name=" + name + ", marks=" + marks + "]";
	}
}

public class ComparableDemo {
	
	List<ComparableStudent> students;
	
	public ComparableDemo() {
		students = new ArrayList<>();
		students.add(new ComparableStudent(123, "Raj", 25));
		students.add(new ComparableStudent(121, "Kumar", 45));
		students.add(new ComparableStudent(122, "Mohan", 28));
		students.add(new ComparableStudent(124, "Kavitha", 35));
		students.add(new ComparableStudent(127, "Mohan", 15));
		students.add(new ComparableStudent(125, "Amar", 85));
		students.add(new ComparableStudent(126, "Ranu", 95));
	}
	
	public void displayStudents() {
		for (ComparableStudent student : students) {
			System.out.println(student);
		}
	}
	
	
	public void sortStudents() {
		Collections.sort(students);
	}
	
	
	public static void main(String[] args) {
		ComparableDemo comparableTest = new ComparableDemo();
		System.out.println("Student info before sorting....");
		comparableTest.displayStudents();
		comparableTest.sortStudents();
		
		System.out.println("Student info after sorting....");
		comparableTest.displayStudents();
	}
}