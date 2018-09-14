package trng.imcs.collection;
import java.util.Scanner;

public class EmployeeUtil {

    private static Scanner scanner = new Scanner(System.in);

    public static int chooseOperation() {
    	    System.out.println("Enter the operations to perform");
	        System.out.println("   ||| MENU |||   ");
	        System.out.println("1. Create Employee");
	        System.out.println("2. Read(View) Employee");
	        System.out.println("3. View all Employees");
	        System.out.println("4. Delete Employee");
	        System.out.println("5. Update Employee");
	        System.out.println("6. Calculate HRA");
	        System.out.println("7. Calculate Gross Salary");
	        System.out.println("8. GroupBy Gender");
	        System.out.println("9. SortBy");
	        System.out.println("10.GroupBy Avearage Salary");
	        System.out.println("11.SortBy comparable");
	        System.out.println("12.SortBy ID :Anonymous inner class");
	        System.out.println("13 SortBy Salary :Inner class");
	        System.out.println("14 exit");
	        System.out.print("Select a choice :");
	        return scanner.nextInt();	
    }

    public static Employee readEmployee() {
	    	System.out.print("Enter trng.Employee id:");
	    	int id = scanner.nextInt();
	    	scanner.nextLine();
	    	System.out.print("Enter trng.Employee firstname:");
	        String firstName = scanner.next();
	        System.out.print("Enter trng.Employee lastname:");
	        String lastName = scanner.next();
	        System.out.print("Enter trng.Employee Salary:");
	        double salary = scanner.nextDouble();
	        System.out.println("Select the gender");
	        System.out.println("	1.Male");
	        System.out.println("	2.Female");
	        int gender = scanner.nextInt();
	        System.out.println("Enter the department number of the student");
	        int deptNo=scanner.nextInt();
	        return new Employee(id, firstName, lastName, salary, gender,deptNo);
    	
    }
}