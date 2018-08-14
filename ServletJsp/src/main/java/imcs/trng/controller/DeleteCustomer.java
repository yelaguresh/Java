package imcs.trng.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import imcs.trng.service.CustomerService;

public class DeleteCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteCustomer() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("customerNumber"));
		CustomerService service = new CustomerService();
		boolean flag = service.checkDeleteCustomer(id);
		if (flag == true) {
			request.setAttribute("delete", "Deleted Successfully");
			request.getRequestDispatcher("delete.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("delete.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
