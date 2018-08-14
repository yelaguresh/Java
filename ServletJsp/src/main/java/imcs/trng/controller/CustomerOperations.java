package imcs.trng.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomerOperations extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CustomerOperations() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String operation = request.getParameter("operationType");
		if (operation.equals("create")) {
			RequestDispatcher rd = request.getRequestDispatcher("createCustomer.jsp");
			rd.forward(request, response);
		} else if (operation.equals("read")) {
			RequestDispatcher rd = request.getRequestDispatcher("Read.jsp");
			rd.forward(request, response);
		} else if (operation.equals("update")) {
			RequestDispatcher rd = request.getRequestDispatcher("update.jsp");
			rd.forward(request, response);
		} else if (operation.equals("delete")) {
			RequestDispatcher rd = request.getRequestDispatcher("delete.jsp");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("CustomerHome.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
