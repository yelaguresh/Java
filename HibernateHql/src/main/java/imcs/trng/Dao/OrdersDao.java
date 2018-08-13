package imcs.trng.Dao;

import java.util.List;
import java.util.Map;

import imcs.trng.pojo.Orders;

public interface OrdersDao {
	public void createOrders(Orders orders);

	Map<String, Double> getMonthlySales(int year);

	public List<Orders> readOrders(int orderId);

	public void updateOrders(Orders orders);

	public void deleteOrders(int orderId);
}
