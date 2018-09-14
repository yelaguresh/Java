package trng.imcs.collection;

import java.util.List;

public interface EmployeeOperations {

    void createEmployee(Employee employee) ;

    Employee findEmployee(int empId);

    List<Employee> findAll();

    boolean deleteEmployee(int empId) ;

    boolean updateEmployee(Employee employee);

    double displayHRA(int empId);

    Double calculateGrossSal(int empId);
    
    void groupByGender();
    
    void sortById();
    
    void sortBySalary();

}