package trng.imcs.jdbc;

import java.util.List;

public interface EmployeeOperations {

	void createEmployee(Employee employee);

    List<Employee> findEmployee(int empId);

    List<Employee> findAll();

    void deleteEmployee(int empId) ;

    void updateEmployee(Employee employee);
       
    List<Employee> groupByfirstName();
    
    List<Employee> orderBySalary();

    List<Employee> groupByAverageSalary();

}