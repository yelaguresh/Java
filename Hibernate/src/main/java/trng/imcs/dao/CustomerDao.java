package trng.imcs.dao;

import trng.imcs.pojo.Customer;

public interface CustomerDao {
	void createCustomer(Customer customer);

	Customer getCustomer(int id);

	void updateCustomer(Customer customer);

	boolean deleteCustomer(int id);
}
