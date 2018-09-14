package imcs.trng.Dao;

import org.hibernate.Query;
import org.hibernate.Session;
import static imcs.trng.util.HibernateUtil.openSession;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import imcs.trng.pojo.OrderDetails;
import imcs.trng.pojo.Orders;

public class OrderDetailsDaoImpl implements OrderDetailsDao {

	public void createOrderDetails(OrderDetails orderDetails) {
		Session session = null;
		try {
			session = openSession();
			session.beginTransaction();
			session.save(orderDetails);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}

	}

	public List<OrderDetails> readOrders() {
		List<OrderDetails> list1 = new ArrayList<>();
		Session session = null;
		try {
			session = openSession();
			session.beginTransaction();
			String hql = "from OrderDetails o where (o.priceEach*o.quantityOrdered)>200";
			Query query = session.createQuery(hql);
			List<Object[]> list = query.list();
			for (Iterator it = query.iterate(); it.hasNext();) {
				OrderDetails orders = (OrderDetails) it.next();
				OrderDetails details = new OrderDetails(orders.getOrderNumber(), orders.getProductCode(),
						orders.getQuantityOrdered(), orders.getPriceEach());
				list1.add(details);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list1;
	}

}
