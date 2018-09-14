package imcs.trng.Dao;

import java.util.List;

import imcs.trng.pojo.Customers;
import imcs.trng.pojo.ReportBean;

public interface CustomerDao {
	void createCustomer(Customers customer);

	List<Customers> getCustomers(String zipCode);

	List<ReportBean> getReport(int month);
}
