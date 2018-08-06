package imcs.trng.Hibernate;

import java.util.ArrayList;
import java.util.List;
import trng.imcs.dao.CustomerDao;
import trng.imcs.dao.CustomerDaoImpl;
import trng.imcs.dao.OrderDetailsDao;
import trng.imcs.dao.OrderDetailsDaoImpl;
import trng.imcs.dao.OrderItemsDao;
import trng.imcs.dao.OrderItemsDaoImpl;
import trng.imcs.pojo.Address;
import trng.imcs.pojo.Customer;
import trng.imcs.pojo.OrderItems;
import trng.imcs.pojo.Orders;

public class App {
	public static void main(String[] args) {
		// Initializing and create Methods of all implementation
		OrderItemsDao itemsDao = new OrderItemsDaoImpl();
		OrderItems items = new OrderItems(null, "6789", 1, null);
		itemsDao.createOrder(items);
		OrderDetailsDao detailsDao = new OrderDetailsDaoImpl();
		Orders orders = new Orders(null, "Approved", null, items.getItemNo());
		detailsDao.createOrder(orders);
		CustomerDao cuDao = new CustomerDaoImpl();
		List<Customer> list = new ArrayList<Customer>();
		Address address = new Address(3116, "N Macarthur", "Irving", "Texas", "USA", "45420");
		Customer customer = new Customer(1, "Deshpande", "123456789", 4000.00, address, orders.getOrderId());
		Customer customer2 = new Customer(1, "Yelaguresh", "123456789", 4000.00, address, orders.getOrderId());
		list.add(customer);
		cuDao.createCustomer(customer);
		cuDao.createCustomer(customer2);
		// Display Methods of all implementation
		Customer customer1 = cuDao.getCustomer(customer.getIds());
		System.out.println(customer1.toString());

		Orders orders2 = detailsDao.getOrders(customer.getIds());
		System.out.println("Orders " + orders2.toString());

		OrderItems items2 = itemsDao.getOrders(orders.getOrderId());
		System.out.println(items2.toString());
		// Update Methods of all implementation
		cuDao.updateCustomer(customer1);
		detailsDao.updateOrder(orders2);
		itemsDao.updateOrder(items2);
		// Delete Methods of all implementation
		boolean flag = cuDao.deleteCustomer(customer2.getIds());
		if (flag == true) {
			System.out.println("record deleted");
		} else {
			System.out.println("failed to delete");
		}
		/*
		 * boolean flag1=detailsDao.deleteOrder(customer2.getIds()); if(flag1==true) {
		 * System.out.println("record deleted"); } else {
		 * System.out.println("failed to delete"); }
		 */
		/*
		 * boolean flag2=itemsDao.deleteOrderItems(orders.getItemNo()); if(flag2==true)
		 * { System.out.println("record deleted"); } else {
		 * System.out.println("failed to delete"); }
		 */
	}
}
