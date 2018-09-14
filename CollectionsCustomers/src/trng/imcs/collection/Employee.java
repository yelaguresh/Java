package trng.imcs.collection;

import java.util.Comparator;

public class Employee implements Comparable<Employee>{

	public enum Gender{
		FEMALE,MALE;
	}
	
	private int id;
	private String firstName;
	private String lastName;
	private double salary;
	Employee manager;
	Gender gender;
	private int deptNo;
	
	class HighSalaryIterator{
		private double givenSalary;
		
		public HighSalaryIterator(int salary) {
			super();
			this.givenSalary = salary;
		}
		public boolean getHighSalaryEmployee(Employee e) {
			if(e.salary>this.givenSalary)
				return true;
			return false;
	}
	}
	public Employee() {
		super();
	}
	public Employee(int id) {
		super();
		this.id = id;
	}
	public Employee(int id, String firstName, String lastName, double salary,int gender,int deptNo) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
		if(gender == 1){
			this.gender = Gender.MALE;
		}else if(gender == 2){
			this.gender = Gender.FEMALE;
		}
		this.deptNo=deptNo;
	}
	public double calculateHRA(){
		//System.out.println(salary);
		double hra = (salary)*(20.00/100.00);
		//System.out.println(hra);
		return hra;	
		
	}
	
	public double calculateGrossSal(){
		
		double grossSal = this.salary + calculateHRA();
		return grossSal;
		
	}
	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public double getSalary() {
		return salary;
	}



	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Employee getManager() {
		return manager;
	}



	public void setManager(Employee manager) {
		this.manager = manager;
	}

	public Gender getGender() {
		return gender;
	}



	public void setGender(Gender gender) {
		this.gender = gender;
	}



	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", salary=" + salary
				+ ", manager=" + manager + ", gender=" + gender + ", deptNo=" + deptNo + "]";
	}
	@Override
	public int compareTo(Employee o) {
		int last=this.lastName.compareTo(o.lastName);
		if(last==0)
		{
			int first=this.firstName.compareTo(o.firstName);
			if(first==0)
			{
				int compared = Double.compare(this.salary, o.salary);
				return compared;
			}
			return first;
		}
		//return last==0?this.firstName.compareTo(o.firstName):last;
		return last;
	}
	public int getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}
	public static class DepartmentComparator implements Comparator<Employee> {

		@Override
		public int compare(Employee o1, Employee o2) {
			if(o1.getDeptNo()==o2.getDeptNo())
				return 0;
			else if (o1.getDeptNo()>o2.getDeptNo())
				return 1;
			else 
				return -1;
			
		}
		
	}	
	
}
