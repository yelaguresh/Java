package imcs.trng.pojo;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReportBean implements Serializable {

	private static final long serialVersionUID = 1L;
	int CustomerId;
	String CustomerName;
	double priceEach;
	int QuantityOrdered;
}
