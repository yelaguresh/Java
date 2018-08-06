package trng.imcs.pojo;

import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Address {

	private int aptno;

	private String streetNumber;

	private String City;

	private String State;

	private String Country;

	private String Zip;
}
