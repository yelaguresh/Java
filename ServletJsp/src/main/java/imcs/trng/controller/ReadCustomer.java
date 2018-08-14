package imcs.trng.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import imcs.trng.pojo.Customers;
import imcs.trng.service.CustomerService;

public class ReadCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ReadCustomer() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		CustomerService service = new CustomerService();
		Customers customers = new Customers();
		customers = service.read(id);
		request.setAttribute("Customers", customers);
		request.getRequestDispatcher("Read.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
