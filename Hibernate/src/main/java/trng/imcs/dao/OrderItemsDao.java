package trng.imcs.dao;

import trng.imcs.pojo.OrderItems;

public interface OrderItemsDao {
	OrderItems getOrders(int id);

	void createOrder(OrderItems items);

	void updateOrder(OrderItems items);

	boolean deleteOrderItems(int id);
}
