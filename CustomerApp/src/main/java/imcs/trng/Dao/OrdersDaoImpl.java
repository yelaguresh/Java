package imcs.trng.Dao;

import static imcs.trng.util.HibernateUtil.openSession;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;

import imcs.trng.pojo.Customers;
import imcs.trng.pojo.OrderDetails;
import imcs.trng.pojo.Orders;

public class OrdersDaoImpl implements OrdersDao {

	public void createOrders(Orders orders) {

		Session session = null;
		try {
			session = openSession();
			session.beginTransaction();
			session.save(orders);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public Map<String, Double> getMonthlySales(int year) {
		Session session = null;
		Map<String, Double> map = new HashMap<>();
		try {
			session = openSession();
			session.beginTransaction();
			String hql = "select month(o.orderDate),sum(ord.quantityOrdered*ord.priceEach) from Orders as o inner join o.orderDetails as ord where  year(o.orderDate)=:year group by month(o.orderDate)";
			Query query = session.createQuery(hql);
			query.setParameter("year", year);
			List<Object[]> list = query.list();
			for (Object[] object : list) {
				String value1 = object[0].toString();// ((String) object[0]);
				Double value2 = (Double) object[1];
				map.put(value1, value2);
			}

			return map;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	public List<Orders> readOrders(int orderId) {
		List<Orders> list1 = new ArrayList<>();
		Session session = null;
		session = openSession();
		session.beginTransaction();
		String hql = "FROM Orders o WHERE o.orderNumber = :orderNumber";
		Query query = session.createQuery(hql);
		query.setParameter("orderNumber", orderId);
		List<Object[]> list = query.list();
		for (Iterator it = query.iterate(); it.hasNext();) {
			Orders orders = (Orders) it.next();
			Orders orders2 = new Orders(orders.getOrderNumber(), orders.getOrderDate(), orders.getRequiredDate(),
					orders.getShippedDate(), orders.getStatus(), orders.getComments(), orders.getCustomerNumber(),
					orders.getOrderDetails());
			list1.add(orders2);
		}
		return list1;
	}

	public void updateOrders(Orders orders) {
		Session session = null;
		try {
			session = openSession();
			session.beginTransaction();
			session.save(orders);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	public void deleteOrders(int orderId) {
		Session session = null;
		try {
			session = openSession();
			session.beginTransaction();
			String hql = "delete from Orders where orderNumber = :orderNumber";// FROM Orders o WHERE o.orderNumber =
																				// :orderNumber"
			Query query = session.createQuery(hql);// delete Stock where stockCode = :stockCode"
			query.setParameter("orderNumber", orderId);
			query.executeUpdate();
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
		}

	}
}
