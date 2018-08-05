package trng.imcs.jdbc;
import java.util.Scanner;


public class EmployeeUtil {

    private static Scanner scanner = new Scanner(System.in);

    public static int chooseOperation() {
    	    System.out.println("Enter the operations to perform");
	        System.out.println("   ||| MENU |||   ");
	        System.out.println("1. Create Employee");
	        System.out.println("2. Read(View) Employee");
	        System.out.println("3. View all Employees");
	        System.out.println("4. Update Employee");
	        System.out.println("5. Delete Employee");
	        System.out.println("6. Calculate HRA");
	        System.out.println("7. Calculate Gross Salary");
	        System.out.println("8. GroupBy firstName");
	        System.out.println("9. orderBy Salary");
	        System.out.println("10.GroupBy Average Salary");
	        System.out.println("11 exit");
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
        return new Employee(id, firstName, lastName, salary);
	
}
   
}