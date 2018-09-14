package imcs.trng.pojo;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "orders")
public class Orders {
	@Id
	@Column(name = "orderNumber")
	private int orderNumber;

	private Date orderDate;

	private Date requiredDate;

	private Date shippedDate;

	private String status;

	private String comments;

	private int customerNumber;

	@OneToMany
	@JoinColumn(name = "orderNumber")
	private List<OrderDetails> orderDetails;

}
