package imcs.trng.springs.Springcore;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App 
{

    public static void main( String[] args ) throws ParseException
    {
    	String s = "09/22/2006";
        SimpleDateFormat sd = new SimpleDateFormat("MM/dd/yyyy");
        Date date1 = sd.parse(s);
    	ApplicationContext factory=new AnnotationConfigApplicationContext(Appconfig.class);
        Customer customer =factory.getBean(Customer.class);
        Order1 order1=factory.getBean(Order1.class);
        OrderItems items=factory.getBean(OrderItems.class);
        items.setItemId(1);
        items.setItemId(1);
        items.setNumberOfItems(5);
        Date mydate = new Date();
        order1.setOrderId(1);
        order1.setOrderDate(date1);
        customer.setCustomerName("Rama");
        customer.setCustomerId(1);
        customer.setAge(23);
        customer.details(customer);
        System.out.println(customer);
        order1.OrderDetails();
        
    }
}
