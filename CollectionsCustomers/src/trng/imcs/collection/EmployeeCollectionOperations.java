package trng.imcs.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import trng.imcs.collection.Employee.Gender;


public class EmployeeCollectionOperations implements EmployeeOperations{
	  ArrayList<Employee> emp=new ArrayList<Employee>();  
	 
	@Override
	public void createEmployee(Employee employee) {
		emp.add(employee);
		
	}

	@Override
	public Employee findEmployee(int empId) {
		 Iterator<Employee> itr=emp.iterator();
		    while(itr.hasNext()){  
		    Employee emp=(Employee)itr.next();  
		    if(emp.getId()==empId)
		    	return emp;
		    
		  }  
		return null;
	}

	@Override
	public List<Employee> findAll() {
		return emp;
	}

	
	@Override
	public boolean deleteEmployee(int empId) {
		boolean flag=false;
		 Iterator<Employee> itr=emp.iterator();
		 while (itr.hasNext()) {
			Employee employee = (Employee) itr.next();
			if(employee.getId()==empId)
			{
				itr.remove();
				flag=true;
			}
		 }
		 return flag;
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		boolean flag=false;
		Iterator<Employee> itr=emp.iterator();
		 while (itr.hasNext()) {
			Employee employee1 = (Employee) itr.next();
			if(employee1.getId()==employee.getId())
			{
				int index=emp.indexOf(employee1);
				emp.set(index, employee);
				flag=true;
			}
		 }
		return flag;
	}

	@Override
	public double displayHRA(int empId) {
		double hra=0;
		Iterator<Employee> itr=emp.iterator();
		 while (itr.hasNext()) {
			Employee employee = (Employee) itr.next();
			if(employee.getId()==empId)
			{
				hra=(employee.getSalary()*0.15);
			}
			else {
				System.out.println("Invalid emp id");
			}
		 }
	return hra;
	}

	@Override
	public Double calculateGrossSal(int empId) {
		double grossSalary=0;
		double hra=0;
		double da=0;
		Iterator<Employee> itr=emp.iterator();
		 while (itr.hasNext()) {
			Employee employee = (Employee) itr.next();
			if(employee.getId()==empId)
			{
				hra=(employee.getSalary()*0.15);
				da=(employee.getSalary()*0.12);
				grossSalary=(employee.getSalary()+hra+da);
			}
			else {
				System.out.println("Invalid emp id");
			}
		 }
		 return grossSalary;
	}

	public void groupByGender() {
		Map<Gender,List<Employee>> employeeMap
        = emp.stream().collect(Collectors.groupingBy(Employee::getGender));
		System.out.println(employeeMap);
	}

	public void sortById() {
		Collections.sort(emp, new IdComparator());
		Iterator itr=emp.iterator();  
		while(itr.hasNext()){  
			Employee emp=(Employee)itr.next(); 
			System.out.println(emp.getId()+" "+emp.getFirstName()+" "+emp.getLastName()+" "+emp.getSalary()+" "+emp.getGender());
		}
	}

	public void sortBySalary() {
		Collections.sort(emp, new salaryComparator());
		Iterator itr=emp.iterator();  
		while(itr.hasNext()){  
			Employee emp=(Employee)itr.next(); 
			System.out.println(emp.getId()+" "+emp.getFirstName()+" "+emp.getLastName()+" "+emp.getSalary()+" "+emp.getGender());
		}
	}
	public List<Employee> sortByDepartment() {
		return emp;
	}
	public void groupByAverageSalaryOfEmployees() {
		double averageSalary=0;
		double totalSalary=0;
		int noOfEmployees=(emp.size());
		Iterator<Employee> itr=emp.iterator();
		 while (itr.hasNext()) {
			Employee employee = (Employee) itr.next();
			totalSalary+=employee.getSalary();
		 }
		 averageSalary=totalSalary/noOfEmployees;
		 Map<Double, List<Employee>> groupBysalary = emp.stream()
		            .collect(Collectors.groupingBy(Employee::getSalary));
		 for (Map.Entry<Double, List<Employee>> entry : ((Map<Double,List<Employee>>) groupBysalary).entrySet()) {
			 if(entry.getKey()>averageSalary)
				 System.out.println("Salary greater than average salary "+entry.getKey());
			 else if (entry.getKey()<averageSalary) {
				 System.out.println("Salary lesser than average salary "+entry.getKey());
			}
			 else {
				System.out.println("Salary is equal to average salary");
			}
		 }
		 }

	public List<Employee> sortByName() {
		Collections.sort(emp);
		return emp;
	}

	public List<Employee> sortListByAnnInnerClass() {
		Collections.sort(emp, new Comparator<Employee>() {
			public int compare(Employee o1, Employee o2) {
				return o1.getId() - o2.getId();
			}
		});

		return emp;
	}
}


