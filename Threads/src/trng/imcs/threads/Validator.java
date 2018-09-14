package trng.imcs.threads;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



public class Validator {
	
public List<Employee> validateEmployee(List<Employee> empList){
	List<Employee> validateEmp=new ArrayList<Employee>();
	List<Employee> failedEmp=new ArrayList<Employee>();
	Iterator<Employee> itr=empList.iterator();
    while(itr.hasNext()){  
    Employee emp1=(Employee)itr.next();
    if(emp1.getSalary()>=4000)
    {
    	Employee e=new Employee(emp1.getId(), emp1.getName(), emp1.getAge(), emp1.getSalary());
    	validateEmp.add(e);
    }
    else {
    	Employee e1=new Employee(emp1.getId(), emp1.getName(), emp1.getAge(), emp1.getSalary());
    	failedEmp.add(e1);
    	}
    
}
    return validateEmp;
}
}

