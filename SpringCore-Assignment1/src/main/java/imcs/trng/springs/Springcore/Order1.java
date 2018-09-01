package imcs.trng.springs.Springcore;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Order1 implements OrderInterface{
	@Autowired
	OrderItems orderItems;
	private int orderId;
	private Date orderDate;
	@Value("Order Details")
	String message;

	@Override
	public void OrderDetails() {
		System.out.println("Order1 details");
		orderItems.orderItems();
	}
	@PostConstruct
	public void init() {
		System.out.println("message is: " + message);
	}
}
