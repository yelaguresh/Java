package trng.imcs.threads;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import trng.imcs.threads.Employee;

public class ThreadsReadData extends Thread{
File file;

public ThreadsReadData(String filePath) {
	super();
	this.file = new File(filePath);
}

public ThreadsReadData() {
	super();
}

public File getFile() {
	return file;
}

public void setFile(File file) {
	this.file = file;
}

@Override
synchronized public void run() {
	Validator validate=new Validator();
	ThreadsWriteData twd=new ThreadsWriteData();
	List<Employee> empList=new ArrayList<Employee>();
	List<Employee> validateEmpList=new ArrayList<Employee>();
	empList=readData();
	validateEmpList=validate.validateEmployee(empList);
	try {
		twd.csvWriter(validateEmpList);
	} catch (IOException e) {
		e.printStackTrace();
	}
}
public List<Employee> readData() {
	List<Employee> empList=new ArrayList<Employee>();
	String line = "";
    String cvsSplitBy = ",";
    try(BufferedReader br = new BufferedReader(new FileReader(file))) {
    	while ((line = br.readLine()) != null) {
            String[] employee = line.split(cvsSplitBy);
            int id=Integer.parseInt(employee[0]);
            String name=employee[1];
            int age=Integer.parseInt(employee[2]);
            double salary=Double.parseDouble(employee[3]);
            Employee emp=new Employee(id, name, age, salary);
            empList.add(emp);
         }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
	return empList; 
	
}

}
