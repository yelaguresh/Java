package imcs.trng.Dao;

import static imcs.trng.util.HibernateUtil.openSession;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import imcs.trng.pojo.CustomerCredentials;
import imcs.trng.pojo.Customers;

public class CustomerLoginDao {
	public List<CustomerCredentials> getCredentials(String Username, String Password) {
		List<CustomerCredentials> list1 = new ArrayList<CustomerCredentials>();
		Session session = null;
		session = openSession();
		session.beginTransaction();
		String hql = "select c from CustomerCredentials c where c.Username=:Username and c.Password =:Password";
		Query query = session.createQuery(hql);
		query.setParameter("Username", Username);
		query.setParameter("Password", Password);
		List<Object[]> list = query.list();
		for (Iterator it = query.iterate(); it.hasNext();) {
			CustomerCredentials credentials = (CustomerCredentials) it.next();
			CustomerCredentials credentials2 = new CustomerCredentials(credentials.getUsername(),
					credentials.getPassword());
			list1.add(credentials2);
		}
		return list1;
	}

	public boolean storeData(Customers customers) {
		Session session = null;
		try {
			session = openSession();
			session.beginTransaction();
			session.save(customers);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return false;
	}

	public Customers getCustomers(int id) {
		Customers customers2 = null;
		Session session = null;
		session = openSession();
		session.beginTransaction();
		String hql = "FROM Customers c WHERE c.customerNumber = :customerNumber";
		Query query = session.createQuery(hql);
		query.setParameter("customerNumber", id);
		for (Iterator it = query.iterate(); it.hasNext();) {
			Customers customers = (Customers) it.next();
			customers2 = new Customers(customers.getCustomerNumber(), customers.getCustomerName(),
					customers.getContactLastName(), customers.getContactFirstName(), customers.getPhone(),
					customers.getAddressLine1(), customers.getAddressLine2(), customers.getCity(), customers.getState(),
					customers.getPostalCode(), customers.getCountry(), customers.getSalesRepEmployeeNumber(),
					customers.getCreditLimit());
		}
		return customers2;
	}

	public boolean updateData(int id, String phone) {
		Session session = null;
		try {
			session = openSession();
			session.beginTransaction();
			String hql = "update Customers c set c.phone=:phone where c.customerNumber=:customerNumber";
			Query query = session.createQuery(hql);
			query.setParameter("phone", phone);
			query.setParameter("customerNumber", id);
			query.executeUpdate();
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return false;
	}

	public boolean deleteCustomer(int id) {
		Session session = null;
		try {
			session = openSession();
			session.beginTransaction();
			String hql = "delete from Customers where customerNumber=:customerNumber";
			Query query = session.createQuery(hql);
			query.setParameter("customerNumber", id);
			query.executeUpdate();
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return false;

	}
}
