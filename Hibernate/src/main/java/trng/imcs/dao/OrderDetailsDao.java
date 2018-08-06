package trng.imcs.dao;

import trng.imcs.pojo.Orders;

public interface OrderDetailsDao {
	Orders getOrders(int id);

	void createOrder(Orders orders);

	void updateOrder(Orders orders);

	boolean deleteOrder(int id);
}
