package imcs.trng.HIbernateAssignment2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import imcs.trng.Dao.CustomerDaoImpl;
import imcs.trng.Dao.OrderDetailsDaoImpl;
import imcs.trng.Dao.OrdersDaoImpl;
import imcs.trng.pojo.Customers;
import imcs.trng.pojo.OrderDetails;
import imcs.trng.pojo.Orders;

public class App {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		try {
			Customers customers = new Customers(100, "Yelaguresh Deshpande", "Deshpande", "Yelaguresh", "9478976577",
					"3116", "N MacArthur", "Irving", "Texas", "75063", "USA", 1370, 23456.00, null);
			CustomerDaoImpl customerDaoImpl = new CustomerDaoImpl();

			List<Customers> list = new ArrayList<Customers>();

			list = customerDaoImpl.getCustomers(customers.getPostalCode());
			for (Customers customers2 : list) {
				System.out.println("Customers based on zip code: " + customers2.toString());
			}

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/mm/dd");
			Date orderDate;
			orderDate = sdf.parse("2017/12/05");
			Date requiredDate = sdf.parse("2018/01/31");
			Date shippedDate = sdf.parse("2018/01/26");
			Orders orders = new Orders(1, orderDate, requiredDate, shippedDate, "Shipped", "Shipped to right address",
					1, null);
			OrdersDaoImpl daoImpl = new OrdersDaoImpl();
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(orderDate);
			int Year = calendar.get(Calendar.YEAR);
			int Month = calendar.get(Calendar.MONTH);
			Map<String, Double> map = new HashMap<String, Double>();
			map = daoImpl.getMonthlySales(Year);
			for (Map.Entry<String, Double> entry : map.entrySet()) {
				System.out.println("Monthly sales in given year: Month :" + entry.getKey() + "\tTotalOrderPrice :"
						+ entry.getValue());
			}
			List<Orders> list2 = new ArrayList<Orders>();
			list2 = daoImpl.readOrders(orders.getOrderNumber());
			for (Orders orders2 : list2) {
				System.out.println("Display orders " + orders2.toString());
			}
			Orders orders1 = new Orders(2, orderDate, requiredDate, shippedDate, "Shipped", "Shipped to right address",
					1, null);
			// daoImpl.updateOrders(orders1);
			daoImpl.deleteOrders(orders1.getOrderNumber());

			List<OrderDetails> list3 = new ArrayList<OrderDetails>();
			// OrderDetails details=new OrderDetails(1, "S18_1749", 20, 63.12);
			OrderDetailsDaoImpl detailsDaoImpl = new OrderDetailsDaoImpl();
			list3 = detailsDaoImpl.readOrders();
			for (OrderDetails orderDetails : list3) {
				System.out.println("OrderDetails " + orderDetails.toString());
			}

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
