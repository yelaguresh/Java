package trng.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student {

	private int studentId;
	private String name;
	private int marks;

	public Student(int studentId, String name, int marks) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.marks = marks;
	}

	public Student() {

	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", marks=" + marks + "]";
	}

	// Static nested class
	static class StudentComparator implements Comparator<Student> {

		@Override
		public int compare(Student s1, Student s2) {
			final int BEFORE = -1;
			final int EQUAL = 0;
			final int AFTER = 1;

			// Then compare by name
			if (s1.name.compareTo(s2.name) > 0)
				return AFTER;
			if (s1.name.compareTo(s2.name) < 0)
				return BEFORE;

			// Then compare by marks, high marks first.
			if (s1.marks > s2.marks)
				return BEFORE;
			if (s1.marks < s2.marks)
				return AFTER;

			return 0;
		}
	}

	// Static nested class
	static class StudentByMarksComparator implements Comparator<Student> {

		@Override
		public int compare(Student s1, Student s2) {
			final int BEFORE = -1;
			final int EQUAL = 0;
			final int AFTER = 1;

			// Then compare by marks, high marks first.
			if (s1.marks > s2.marks)
				return BEFORE;
			if (s1.marks < s2.marks)
				return AFTER;

			return 0;
		}
	}
}

public class ComparatorDemo {

	List<Student> students;

	public ComparatorDemo() {
		students = new ArrayList<>();
		students.add(new Student(123, "Raj", 25));
		students.add(new Student(121, "Kumar", 45));
		students.add(new Student(122, "Mohan", 28));
		students.add(new Student(124, "Kavitha", 35));
		students.add(new Student(127, "Mohan", 15));
		students.add(new Student(125, "Amar", 85));
		students.add(new Student(126, "Ranu", 95));
	}

	public void displayStudents() {
		for (Student student : students) {
			System.out.println(student);
		}
	}

	public static void main(String[] args) {
		ComparatorDemo comparableTest = new ComparatorDemo();
		System.out.println("Student info before sorting....");
		comparableTest.displayStudents();
		
		Collections.sort(comparableTest.students, new Student.StudentComparator());
		System.out.println("Student info after sorting by name and marks..");
		comparableTest.displayStudents();

		Collections.sort(comparableTest.students, new Student.StudentByMarksComparator());
		System.out.println("Student info after sorting by marks....");
		comparableTest.displayStudents();
	}
}