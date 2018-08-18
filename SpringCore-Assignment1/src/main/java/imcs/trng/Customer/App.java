package imcs.trng.Customer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext appCntxt = new AnnotationConfigApplicationContext("imcs.trng.Customer");
//		appCntxt.refresh();
		CustomerDaoImpl bean1 = appCntxt.getBean(CustomerDaoImpl.class);
		CustomerDaoImpl bean2 = appCntxt.getBean(CustomerDaoImpl.class);

		System.out.println(bean1);
		System.out.println(bean2);
		bean1.display();
		
	}
}
