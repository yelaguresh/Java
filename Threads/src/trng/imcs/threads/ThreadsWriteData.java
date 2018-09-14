package trng.imcs.threads;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ThreadsWriteData {
 public synchronized void csvWriter(List<Employee> list) throws IOException {
	String filePath="C:\\Temp\\Output.csv";
	String fileHeader="id,name,age,salary";
	String newLineSeperator="\n";
	String commaDelimiter=",";
	FileWriter fileWriter=new FileWriter(filePath);
	
	fileWriter.append(fileHeader);
	for (Employee emp : list) {
		String id=String.valueOf(emp.getId());
	    String name=emp.getName();
	    String age=String.valueOf(emp.getAge());
	    String salary=String.valueOf(emp.getSalary());
	    fileWriter.append(newLineSeperator);
		fileWriter.append(id);
		fileWriter.append(commaDelimiter);
		fileWriter.append(name);
		fileWriter.append(commaDelimiter);
		fileWriter.append(age);
		fileWriter.append(commaDelimiter);
		fileWriter.append(salary);
		fileWriter.append(newLineSeperator);
	}
	    System.out.println("done");
		fileWriter.flush();
		fileWriter.close();
	} 
	
}

