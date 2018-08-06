package trng.imcs.dao;

import static trng.imcs.pojo.util.HibernateUtil.openSession;

import org.hibernate.Session;
import org.hibernate.Transaction;
import trng.imcs.pojo.OrderItems;

public class OrderItemsDaoImpl implements OrderItemsDao {

	public OrderItems getOrders(int id) {
		Session session = null;
		try {
			session = openSession();
			OrderItems orderItems = (OrderItems) session.get(OrderItems.class, id);
			return orderItems;
		} finally {
			session.close();
		}
	}

	public void createOrder(OrderItems items) {
		Session session = null;
		try {
			session = openSession();
			session.beginTransaction();
			session.save(items);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {

			session.close();
		}

	}

	public void updateOrder(OrderItems items) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = openSession();
			transaction = session.beginTransaction();
			session.update(items);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			session.close();
		}

	}

	public boolean deleteOrderItems(int id) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = openSession();
			transaction = session.beginTransaction();
			OrderItems items = (OrderItems) session.get(OrderItems.class, id);
			if (items != null)
				session.delete(items);
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
