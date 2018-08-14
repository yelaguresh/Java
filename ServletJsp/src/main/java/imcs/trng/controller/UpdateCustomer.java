package imcs.trng.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import imcs.trng.pojo.Customers;
import imcs.trng.service.CustomerService;

public class UpdateCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateCustomer() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int customerNumber = Integer.parseInt(request.getParameter("customerNumber"));
		String phone = request.getParameter("phone");
		CustomerService service = new CustomerService();
		boolean flag = service.checkUpdateCustomer(customerNumber, phone);
		if (flag == true) {
			request.setAttribute("update", "Updated Successfully");
			request.getRequestDispatcher("update.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("update.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
