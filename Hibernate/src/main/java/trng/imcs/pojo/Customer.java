package trng.imcs.pojo;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer_details")
public class Customer {
	@Id
	@GeneratedValue
	private Integer ids;
	@Column(name = "name")
	private String customerName;
	@Column(name = "phone")
	private String customerPhone;
	@Column(name = "credit_limit")
	private double customerCreditlimit;
	@Embedded
	private Address address;
	private Integer orderId;
}
