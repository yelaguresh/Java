package imcs.trng.Dao;

import static imcs.trng.util.HibernateUtil.openSession;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import imcs.trng.util.ReportResultTransformer;

import imcs.trng.pojo.Customers;
import imcs.trng.pojo.ReportBean;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public void createCustomer(Customers customer) {
		Session session = null;
		try {
			session = openSession();
			session.beginTransaction();
			session.save(customer);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public List<Customers> getCustomers(String zipCode) {
		List<Customers> list = new ArrayList<Customers>();
		Session session = null;
		session = openSession();
		session.beginTransaction();
		String hql = "FROM Customers c WHERE c.postalCode = 75063";
		Query query = session.createQuery(hql);
		for (Iterator it = query.iterate(); it.hasNext();) {
			Customers customers = (Customers) it.next();
			Customers customers2 = new Customers(customers.getId(), customers.getCustomerName(),
					customers.getContactLastName(), customers.getContactFirstName(), customers.getPhone(),
					customers.getAddressLine1(), customers.getAddressLine2(), customers.getCity(), customers.getState(),
					customers.getPostalCode(), customers.getCountry(), customers.getSalesRepEmployeeNumber(),
					customers.getCreditLimit(), null);
			list.add(customers2);
		}
		session.getTransaction().commit();
		session.close();
		return list;
	}

	public List<ReportBean> getReport(int month) {
		List<ReportBean> list = new ArrayList<ReportBean>();
		Session session = null;
		session = openSession();
		session.beginTransaction();
		String hql = "select c.id, c.customerName, (ord.quantityOrdered*ord.priceEach) from Customer as c inner join c.orderdetails as ord where month(Orders.orderDate)= :month order by (ord.quantityOrdered*ord.priceEach)";
		Query query = session.createQuery(hql);
		query.setParameter("month", month);
		query.setResultTransformer(new ReportResultTransformer());
		for (Iterator it = query.iterate(); it.hasNext();) {
			ReportBean bean = (ReportBean) it.next();
			ReportBean bean2 = new ReportBean(bean.getCustomerId(), bean.getCustomerName(), bean.getPriceEach(),
					bean.getQuantityOrdered());
			list.add(bean2);
		}
		session.getTransaction().commit();
		session.close();
		return list;
	}

}
