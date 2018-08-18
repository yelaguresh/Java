package imcs.trng.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


public class CustomerService {
	CustomerDao customerDao;
	AddressDao addressDao;
	
	@Autowired
	public CustomerService(@Qualifier("customerDaoImpl") CustomerDao customerDao) {
		super();
		System.out.println("EmployeeService constructor called");
		this.customerDao = customerDao;
	}

	public Customer create() {
		Customer customer =  customerDao.create();
		customer.setAddress(addressDao.loadAddress());
		return customer;
	}

	@Autowired
	public void setAddressDao(AddressDao addressDao) {
		System.out.println("setAddressDao is called");
		this.addressDao = addressDao;
	}
}
