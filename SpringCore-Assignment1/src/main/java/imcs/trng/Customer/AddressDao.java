package imcs.trng.Customer;

import org.springframework.beans.factory.annotation.Value;

public class AddressDao {
	@Value("${default.country}")
	String country;
	
	public String loadAddress() {
		return "ABC Street, Country=" + country;
	}
}
