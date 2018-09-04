package imcs.trng.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import imcs.trng.pojo.Customers;
import imcs.trng.service.CustomerOperationsServiceImpl;


@Controller
public class CustomerController {

@RequestMapping("/login")
public ModelAndView add(@RequestParam("t1") String Username,@RequestParam("t2") String Password) {
	ModelAndView mv=new ModelAndView();
	CustomerOperationsServiceImpl serviceImpl=new CustomerOperationsServiceImpl();
	boolean flag=serviceImpl.login(Username,Password);
	if(flag==true) {
		mv.setViewName("Home");
	}
	else {
		mv.setViewName("Login");
		//mv.addObject("result", "login failed.");
	}
	return mv;
}
@RequestMapping("/home")
public ModelAndView home(@RequestParam("operationType") String Choice) {
	ModelAndView mv=new ModelAndView();
	
	if(Choice.equals("create"))
		mv.setViewName("createCustomer");
	
	else if(Choice.equals("read"))
		mv.setViewName("Read");
	
	else if (Choice.equals("update")) {
		mv.setViewName("update");
	}
	else if (Choice.equals("delete")) {
		mv.setViewName("delete");
	}
	else {
		mv.setViewName("Home");
	}

	return mv;
}
@RequestMapping("/createCustomer")
public ModelAndView create(@RequestParam("customerNumber") int CustomerId,@RequestParam("customerName") String CustomerName,
		@RequestParam("contactLastName") String contactLastName,@RequestParam("contactFirstName") String contactFirstName,
		@RequestParam("phone") String phone,@RequestParam("addressLine1") String AddressLine1,@RequestParam("addressLine2") String AddressLine2,
		@RequestParam("city") String city,@RequestParam("state") String state,@RequestParam("postalCode") String postalCode,
		@RequestParam("country") String country,@RequestParam("salesRepEmployeeNumber") int salesRepEmployeeNumber,@RequestParam("creditLimit") double creditLimit)
{
	ModelAndView mv=new ModelAndView();
	Customers customers=new Customers(CustomerId, CustomerName, contactLastName, contactFirstName, phone, AddressLine1, AddressLine2, city, state, postalCode, country, salesRepEmployeeNumber, creditLimit);
	CustomerOperationsServiceImpl serviceImpl=new CustomerOperationsServiceImpl();
	boolean flag=serviceImpl.checkCreateCustomer(customers);
	if(flag==true) {
		mv.setViewName("createCustomer");
		mv.addObject("result", "Record Successfully inserted");
	}
	else {
		mv.setViewName("createCustomer");
		mv.addObject("result", "Record not inserted");
	}
	return mv;
	
}
@RequestMapping("/readCustomer")
public ModelAndView read(@RequestParam("id") int CustomerId) {
	ModelAndView mv=new ModelAndView();
	CustomerOperationsServiceImpl serviceImpl=new CustomerOperationsServiceImpl();
	Customers customers=serviceImpl.read(CustomerId);
	System.out.println(customers.toString());
	mv.setViewName("Read");
	mv.addObject("result", customers.toString());
	return mv;
}
@RequestMapping("/updateCustomer")
public ModelAndView update(@RequestParam("customerNumber")int CustomerId,@RequestParam("phone")String phone) {
	ModelAndView mv=new ModelAndView();
	CustomerOperationsServiceImpl serviceImpl=new CustomerOperationsServiceImpl();
	boolean flag=serviceImpl.checkUpdateCustomer(CustomerId, phone);
	if(flag==true)
	{
		mv.setViewName("update");
		mv.addObject("result", "updated");
	}
	else {
		mv.setViewName("update");
	}
	return mv;
}
@RequestMapping("/deleteCustomer")
public ModelAndView delete(@RequestParam("customerNumber")int CustomerId) {
	ModelAndView mv=new ModelAndView();
	CustomerOperationsServiceImpl serviceImpl=new CustomerOperationsServiceImpl();
	boolean flag=serviceImpl.checkDeleteCustomer(CustomerId);
	if(flag==true)
	{
		mv.setViewName("delete");
		mv.addObject("result", "deleted");
	}
	else {
		mv.setViewName("delete");
	}
	return mv;
}
}


