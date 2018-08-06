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
@Table(name = "order_item")
public class OrderItems {
	@Id
	@Column(name = "itemNo")
	@GeneratedValue
	private Integer itemNo;
	@Column(name = "item_price")
	private String itemPrice;
	@Column(name = "item_Quantity")
	private Integer itemQuantity;
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "itemNo")
	private List<Orders> orders;

}
