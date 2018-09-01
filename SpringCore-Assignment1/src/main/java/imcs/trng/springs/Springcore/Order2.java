package imcs.trng.springs.Springcore;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component

public class Order2 implements OrderInterface {

	@Override
	public void OrderDetails() {
		System.out.println("Order2");

	}

}
