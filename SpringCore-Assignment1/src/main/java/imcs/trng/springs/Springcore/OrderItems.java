package imcs.trng.springs.Springcore;

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
public class OrderItems {
private int itemId;
private int orderId;
private int numberOfItems;
public void orderItems() {
	System.out.println("OrderItem Class");
}
}
