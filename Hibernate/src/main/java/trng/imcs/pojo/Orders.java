package trng.imcs.pojo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "order_details")
public class Orders {
	@Id
	@GeneratedValue
	@Column(name = "orderId")
	private Integer orderId;

	@Column(name = "orderStatus")
	private String orderStatus;
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "orderId")
	private List<Customer> customers;
	private Integer itemNo;
}
