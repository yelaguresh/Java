package imcs.trng.Dao;

import java.util.List;

import imcs.trng.pojo.OrderDetails;

public interface OrderDetailsDao {
	void createOrderDetails(OrderDetails orderDetails);

	public List<OrderDetails> readOrders();

}
