package imcs.trng.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;


@Component
public class CustomerDaoImpl implements CustomerDao{
	@Value("Spring")
	String message;

	@Autowired
	Environment env;

	@Override
	public Customer create() {
		Customer customer=new Customer();
		customer.setName("Raj");
		return customer;
	}

	@Override
	public void display() {
		System.out.println("Hello" + message);
		System.out.println("Country is: " + env.getProperty("default.country"));
	}

}
