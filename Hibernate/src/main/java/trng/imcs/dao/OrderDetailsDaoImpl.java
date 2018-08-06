package trng.imcs.dao;

import static trng.imcs.pojo.util.HibernateUtil.openSession;
import org.hibernate.Session;
import org.hibernate.Transaction;

import trng.imcs.pojo.Orders;

public class OrderDetailsDaoImpl implements OrderDetailsDao {

	public Orders getOrders(int id) {
		Session session = null;
		try {
			session = openSession();
			Orders orders = (Orders) session.get(Orders.class, id);
			return orders;
		} finally {
			session.close();
		}
	}

	public void createOrder(Orders orders) {
		Session session = null;
		try {
			session = openSession();
			session.beginTransaction();
			session.save(orders);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		} finally {
			session.close();
		}

	}

	public void updateOrder(Orders orders) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = openSession();
			transaction = session.beginTransaction();
			session.update(orders);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			session.close();
		}

	}

	public boolean deleteOrder(int id) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = openSession();
			transaction = session.beginTransaction();
			Orders orders = (Orders) session.get(Orders.class, id);
			if (orders != null)
				session.delete(orders);
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
