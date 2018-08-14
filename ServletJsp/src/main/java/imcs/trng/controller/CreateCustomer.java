package imcs.trng.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import imcs.trng.pojo.Customers;
import imcs.trng.service.CustomerService;

public class CreateCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CreateCustomer() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int customerNumber = Integer.parseInt(request.getParameter("customerNumber"));
		String customerName = request.getParameter("customerName");
		String contactLastName = request.getParameter("contactLastName");
		String contactFirstName = request.getParameter("contactFirstName");
		String phone = request.getParameter("phone");
		String addressLine1 = request.getParameter("addressLine1");
		String addressLine2 = request.getParameter("addressLine2");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String postalCode = request.getParameter("postalCode");
		String country = request.getParameter("country");
		int salesRepNumber = Integer.parseInt(request.getParameter("salesRepEmployeeNumber"));
		double creditLimit = Double.parseDouble(request.getParameter("creditLimit"));
		Customers customers = new Customers(customerNumber, customerName, contactLastName, contactFirstName, phone,
				addressLine1, addressLine2, city, state, postalCode, country, salesRepNumber, creditLimit);
		CustomerService service = new CustomerService();
		boolean flag = service.checkCreateCustomer(customers);
		if (flag == true) {
			System.out.println("Records created successfully");
			request.setAttribute("Success", "Record successsfully created");
			request.getRequestDispatcher("createCustomer.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("createCustomer.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
