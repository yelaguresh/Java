package trng.imcs.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import trng.imcs.collection.Employee.DepartmentComparator;

public class EmployeeApplication {
	static EmployeeCollectionOperations eCollOps=new EmployeeCollectionOperations();
	EmployeeOperations employeeOperations = null;
    static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		int choice=0;
		 do {
			 	choice=EmployeeUtil.chooseOperation();
		        switch (choice) {
				case 1: add();
					    break;
					    
				case 2: display();
						break;
						
				case 3: displayAll();
						break;
				
				case 4:delete();
						break;
				case 5:update();
						break;
				case 6:displayHra();
						break;
				case 7:calculateGross();
						break;
				case 8:groupBy();
						break;
				case 9:sortArraylist();
						break;
				case 10:groupByAvgSalary();
						break;
				case 11:sortByName();
						break;
				case 12:sortByID();
						break;
				case 13:sortBySalaryInner();
						break;
				case 14:System.out.println("End of application");
						System.exit(0);
						break;
				default:System.out.println("Invalid Option");
					    break;
				}
			}while(choice!=14);
	}

	private static void sortBySalaryInner() {
		int i=0;
		Employee e=null;
		do {
		e=EmployeeUtil.readEmployee();
		i++;
		}while(i!=2);
		System.out.println("Enter the salary that needs to be compared");
		int salary=scanner.nextInt();
		Employee.HighSalaryIterator hSal=new Employee().new HighSalaryIterator(salary);
		boolean flag=hSal.getHighSalaryEmployee(e);
		if(flag==true)
		{
			System.out.println("Highest Salary employee is "+" "+e.getId()+" "+e.getFirstName()+" "+e.getLastName()
			+" "+e.getSalary()+" "+e.getGender()+" "+e.getDeptNo());
		}
	}

	private static void sortByID() {
		List<Employee> emp=new ArrayList<>();
		emp=eCollOps.sortListByAnnInnerClass();
		Iterator<Employee> itr=emp.iterator();
		while (itr.hasNext()) {
			 Employee employee1 = (Employee) itr.next();
			 System.out.println("Arraylist after sorting by ID "+employee1.getId()+ " "+employee1.getFirstName()+" "+employee1.getLastName()+" "+employee1.getSalary()+" "+employee1.getDeptNo());
		}
	}

	private static void sortByName() {
	List<Employee> emp=new ArrayList<>();
	emp=eCollOps.sortByName();
	Iterator<Employee> itr=emp.iterator();
	while (itr.hasNext()) {
		 Employee employee1 = (Employee) itr.next();
		System.out.println("Arraylist after sorting by name "+employee1.getId()+ " "+employee1.getFirstName()+" "+employee1.getLastName()+" "+employee1.getSalary());
	}
	}

	private static void groupByAvgSalary() {
		eCollOps.groupByAverageSalaryOfEmployees();
	}

	private static void sortArraylist() {
		System.out.println("Sort the arraylist by 1.Id 2.salary 3.Department");
		int sortOption=scanner.nextInt();
		if(sortOption==1)
			eCollOps.sortById();
		else if (sortOption==2) {
			eCollOps.sortBySalary();
		}
		else if(sortOption==3){
			List<Employee> emp=new ArrayList<>();
			emp=eCollOps.sortByDepartment();
			Collections.sort(emp, new DepartmentComparator());
			Iterator<Employee> itr=emp.iterator();
			while (itr.hasNext()) {
				 Employee employee1 = (Employee) itr.next();
				System.out.println("Arraylist after sorting by Department "+employee1.getId()+ " "+employee1.getFirstName()+" "+employee1.getLastName()
				+" "+employee1.getSalary()+" "+employee1.getDeptNo());
			}
		}
		else {
			System.out.println("Invalid Option");
		}	
	}

	private static void groupBy() {
		eCollOps.groupByGender();
	}

	private static void calculateGross() {
		System.out.println("Enter the employee id of the employee for whom gross salary needs to be calculated");
		int empId=scanner.nextInt();
		double grossSalary=eCollOps.calculateGrossSal(empId);
		System.out.println("gross salary of the employee is "+grossSalary);
	}

	private static void displayHra() {
		System.out.println("Enter the employee id of the employee for whom HRA needs to be calculated");
		int empId=scanner.nextInt();
		double hra=eCollOps.displayHRA(empId);
		System.out.println("HRA of the employee is "+hra);
	}

	private static void update() {
		Employee employee=EmployeeUtil.readEmployee();
		eCollOps.updateEmployee(employee);		
	}

	private static void delete() {
		System.out.println("Enter the empid to delete");
		int empId=scanner.nextInt();
		boolean flag=eCollOps.deleteEmployee(empId);
		if(flag==true)
			System.out.println("Deleted record");
		else
			System.out.println("Enter valid emp ID");
		
	}

	private static void displayAll() {
		List<Employee> emp=new ArrayList<>();
		emp=eCollOps.findAll();
		Iterator<Employee> itr=emp.iterator();  
		  //traversing elements of ArrayList object  
		  while(itr.hasNext()){  
		    Employee e=(Employee)itr.next();  
		    System.out.println("Id\t"+e.getId()+"\t"+"Firstname\t"+e.getFirstName()+"\t"+"Lastname\t"+e.getLastName()+"\t"+"Salary\t"+e.getSalary()+"\t"+"Gender\t"+e.getGender()+"\t"+"Department\t"+e.getDeptNo());  
		  }
	}

	private static void display() {
		System.out.println("Enter the emp id to search");
		int empid=scanner.nextInt();
		Employee emp=eCollOps.findEmployee(empid);
		System.out.println(emp);
		
	}

	private static void add() {
		Employee employee=EmployeeUtil.readEmployee();
		eCollOps.createEmployee(employee);
	}

}
