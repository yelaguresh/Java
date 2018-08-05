package trng.imcs.jdbc;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
public class EmployeeDao implements EmployeeOperations{

	
	public void createEmployee(Employee employee) {
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/classicmodels?useSSL=false","root","newuser_123");
			PreparedStatement stmt=con.prepareStatement("insert into employeejdbc values(?,?,?,?)");
			stmt.setInt(1,employee.getId());//1 specifies the first parameter in the query  
			stmt.setString(2,employee.getFirstName());
			stmt.setString(3,employee.getLastName());
			stmt.setDouble(4,employee.getSalary());
			stmt.executeUpdate();  
			con.close();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	
	public List<Employee> findEmployee(int empId) {
		List<Employee> list=new ArrayList<Employee>();
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/classicmodels?useSSL=false","root","newuser_123");
			PreparedStatement stmt=con.prepareStatement("select * from employeejdbc where id=?");
			stmt.setInt(1,empId);
			ResultSet rs=stmt.executeQuery();
			while (rs.next()) {
				int id=rs.getInt(1);
				String firstname=rs.getString(2);
				String lastname=rs.getString(3);
				double salary=rs.getDouble(4);
				Employee emp=new Employee(id, firstname, lastname, salary);
				list.add(emp);
			}
		}
		catch (Exception e) {
			e.getMessage();
		}
		return list;
	}
	
	public List<Employee> findAll() {
		List<Employee> list=new ArrayList<Employee>();
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/classicmodels?useSSL=false","root","newuser_123");
			PreparedStatement stmt=con.prepareStatement("select * from employeejdbc");
			ResultSet rs=stmt.executeQuery();
			while (rs.next()) {
				int id=rs.getInt(1);
				String firstname=rs.getString(2);
				String lastname=rs.getString(3);
				double salary=rs.getDouble(4);
				Employee emp=new Employee(id, firstname, lastname, salary);
				list.add(emp);
			}
		}
		catch (Exception e) {
			e.getMessage();
		}
		return list;
	}

	
	public void deleteEmployee(int empId) {
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/classicmodels?useSSL=false","root","newuser_123");
			PreparedStatement stmt=con.prepareStatement("DELETE FROM employeejdbc\r\n" + 
					"WHERE id=?");
			stmt.setInt(1, empId);
			stmt.executeUpdate();  
			con.close();
		}
		catch (Exception e) {
			e.getMessage();
		}
	}

	
	public void updateEmployee(Employee employee) {
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/classicmodels?useSSL=false","root","newuser_123");
			PreparedStatement stmt=con.prepareStatement("Update employeejdbc set id=?,firstname=?,lastName=?,salary=? where id=?");
			stmt.setInt(1, employee.getId());
			stmt.setString(2, employee.getFirstName());
			stmt.setString(3, employee.getLastName());
			stmt.setDouble(4, employee.getSalary());
			stmt.setDouble(5, employee.getId());
			stmt.executeUpdate();  
			con.close();
		}
		catch (Exception e) {
			e.getMessage();
		}
		
	}
	
	public List<Employee> groupByfirstName() {
		List<Employee> list=new ArrayList<Employee>();
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/classicmodels?useSSL=false","root","newuser_123");
			PreparedStatement stmt=con.prepareStatement("SELECT id,firstname,lastName,SUM(salary) AS TotalSalary from employeejdbc GROUP BY firstname");
			ResultSet rs=stmt.executeQuery();
			while (rs.next()) {
				int id=rs.getInt(1);
				String firstName=rs.getString(2);
				String lastName=rs.getString(3);
				double salary=rs.getDouble(4);
				Employee emp=new Employee(id, firstName, lastName, salary);
				list.add(emp);
			} 
			con.close();
		}
		catch (Exception e) {
			e.getMessage();
		}
		return list;
		
	}
	public List<Employee> orderBySalary() {
		List<Employee> list=new ArrayList<Employee>();
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/classicmodels?useSSL=false","root","newuser_123");
			PreparedStatement stmt=con.prepareStatement("SELECT * FROM employeejdbc\r\n" + 
					"ORDER BY salary");
			ResultSet rs=stmt.executeQuery();
			while (rs.next()) {
				int id=rs.getInt(1);
				String firstName=rs.getString(2);
				String lastName=rs.getString(3);
				double salary=rs.getDouble(4);
				Employee emp=new Employee(id, firstName, lastName, salary);
				list.add(emp);
			} 
			con.close();
		}
		catch (Exception e) {
			e.getMessage();
		}
		return list;
	}

	
	public List<Employee> groupByAverageSalary() {
		List<Employee> list=new ArrayList<Employee>();
		double totalSalary=0;
		double averageSalary=0;
		int i=0;
		try
		{
			
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/classicmodels?useSSL=false","root","newuser_123");
			PreparedStatement stmt=con.prepareStatement("select salary from employeejdbc");
			ResultSet rs=stmt.executeQuery();
			while (rs.next()) {
				i++;
				totalSalary=totalSalary+rs.getDouble(1);
			}
			averageSalary=totalSalary/i;
			PreparedStatement stmt1=con.prepareStatement("select * from employeejdbc");
			ResultSet rs1=stmt1.executeQuery();
			while (rs1.next()) {
				if(rs1.getDouble(4)>=averageSalary)
				{
					int id=rs1.getInt(1);
					String firstName=rs1.getString(2);
					String lastName=rs1.getString(3);
					double salary=rs1.getDouble(4);
					Employee emp=new Employee(id, firstName, lastName, salary);
					list.add(emp);
				}
				
			}
		}
		catch (Exception e) {
			e.getMessage();
		}
		return list;
	}

}
