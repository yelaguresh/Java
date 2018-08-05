package imcs.trng.JDBCMVN;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import trng.imcs.jdbc.Employee;
import trng.imcs.jdbc.EmployeeDao;
import trng.imcs.jdbc.EmployeeUtil;

public class EmployeeApplication {

	static EmployeeDao emp = new EmployeeDao();
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int choice = 0;
		do {
			choice = EmployeeUtil.chooseOperation();
			switch (choice) {
			case 1:
				add();
				break;
			case 2:
				display();
				break;
			case 3:
				displayAll();
				break;
			case 4:
				update();
				break;
			case 5:
				delete();
				break;
			case 6:
				calculateHRA();
				break;
			case 7:
				calculateGrossSal();
				break;
			case 8:
				groupByfirstName();
				break;
			case 9:
				orderBySalary();
				break;
			case 10:
				groupByAverageSalary();
				break;
			case 11:
				System.out.println("End of application");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid Option");
				break;
			}
		} while (choice != 11);
	}

	private static void groupByAverageSalary() {
		List<Employee> list = new ArrayList<Employee>();
		list = emp.groupByAverageSalary();
		System.out.println("Employees who have salary more than average salary\n" + list.toString());
	}

	private static void orderBySalary() {
		List<Employee> list = new ArrayList<Employee>();
		list = emp.orderBySalary();
		System.out.println(list.toString());
	}

	private static void groupByfirstName() {
		List<Employee> list = new ArrayList<Employee>();
		list = emp.groupByfirstName();
		System.out.println(list.toString());
	}

	private static void calculateGrossSal() {
		List<Employee> list = new ArrayList<Employee>();
		System.out.println("Please enter the employee id");
		int id = scanner.nextInt();
		list = emp.findEmployee(id);
		for (Employee employee : list) {
			double grossSalary = (employee.getSalary()) + (employee.getSalary()) * (20.00 / 100.00);
			System.out.println("Gross Salary " + grossSalary);
		}
	}

	private static void calculateHRA() {
		List<Employee> list = new ArrayList<Employee>();
		System.out.println("Please enter the employee id");
		int id = scanner.nextInt();
		list = emp.findEmployee(id);
		for (Employee employee : list) {
			double hra = (employee.getSalary()) * (20.00 / 100.00);
			System.out.println("HRA " + hra);
		}

	}

	private static void delete() {
		System.out.println("Please enter the employee id");
		int id = scanner.nextInt();
		emp.deleteEmployee(id);
	}

	private static void update() {
		Employee employee = EmployeeUtil.readEmployee();
		emp.updateEmployee(employee);
		System.out.println("Records updated");
	}

	private static void displayAll() {
		List<Employee> list = new ArrayList<Employee>();
		list = emp.findAll();
		System.out.println(list.toString());
	}

	private static void display() {
		List<Employee> list = new ArrayList<Employee>();
		System.out.println("Please enter the employee id");
		int id = scanner.nextInt();
		list = emp.findEmployee(id);
		System.out.println(list.toString());
	}

	private static void add() {
		Employee employee = EmployeeUtil.readEmployee();
		emp.createEmployee(employee);
		System.out.println("Records added");
	}

}
