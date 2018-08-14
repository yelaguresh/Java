package imcs.trng.service;

import java.util.ArrayList;
import java.util.List;

import imcs.trng.CustomerLoginDao;
import imcs.trng.pojo.CustomerCredentials;
import imcs.trng.pojo.Customers;

public class CustomerService {
	CustomerLoginDao dao = new CustomerLoginDao();

	public boolean checkCredentials(String Username, String Password) {

		List<CustomerCredentials> list = new ArrayList<>();
		list = dao.getCredentials(Username, Password);
		for (CustomerCredentials customerCredentials : list) {

			if (customerCredentials.getUsername().equals(Username)
					&& customerCredentials.getPassword().equals(Password)) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	public boolean checkCreateCustomer(Customers customers) {

		boolean flag = dao.storeData(customers);
		if (flag == true) {
			return true;
		} else {
			return false;
		}
	}

	public Customers read(int id) {
		Customers customers = dao.getCustomers(id);
		return customers;
	}

	public boolean checkUpdateCustomer(int id, String phone) {
		boolean flag = dao.updateData(id, phone);
		if (flag == true) {
			return true;
		} else {
			return false;
		}
	}

	public boolean checkDeleteCustomer(int id) {
		boolean flag = dao.deleteCustomer(id);
		if (flag == true) {
			return true;
		} else {
			return false;
		}

	}
}
