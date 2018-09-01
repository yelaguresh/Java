package imcs.trng.springs.Springcore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Component
public class Customer {
	
@Autowired
@Qualifier("order1")
OrderInterface ord1;

private int customerId;
private String customerName;
private int age;

public void details(Customer customer) {
	System.out.println(customer.toString());
	ord1.OrderDetails();
}
}
