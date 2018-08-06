package trng.imcs.dao;

import static trng.imcs.pojo.util.HibernateUtil.openSession;

import org.hibernate.Session;
import org.hibernate.Transaction;

import trng.imcs.pojo.Customer;

public class CustomerDaoImpl implements CustomerDao {

	public void createCustomer(Customer customer) {
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

	public Customer getCustomer(int id) {
		Session session = null;
		try {
			session = openSession();
			Customer customer = (Customer) session.get(Customer.class, id);
			return customer;
		} finally {
			session.close();
		}
	}

	public void updateCustomer(Customer customer) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = openSession();
			transaction = session.beginTransaction();
			session.update(customer);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			session.close();
		}

	}

	public boolean deleteCustomer(int id) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = openSession();
			transaction = session.beginTransaction();
			Customer customer = (Customer) session.get(Customer.class, id);
			if (customer != null)
				session.delete(customer);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			return false;
		} finally {
			session.close();
		}
	}

}
