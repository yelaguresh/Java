package imcs.trng.Customer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan({"trng.imcs.spring.core", "trng.some"})
@PropertySource("classpath:country.properties")

public class AppConfig {

	@Bean
	public AddressDao addressDao() {
		return new AddressDao();
	}
	
	@Bean
	public CustomerDaoImpl employeeDaoImpl() {
		return new CustomerDaoImpl();
	}
}
