package imcs.trng.pojo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "customers")
public class Customers implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "customerNumber")

	private int id;

	@Column(name = "customerName")
	private String customerName;

	@Column(name = "contactLastName")
	private String contactLastName;

	private String contactFirstName;

	private String phone;

	private String addressLine1;

	private String addressLine2;

	private String city;

	private String state;

	private String postalCode;

	private String country;

	private int salesRepEmployeeNumber;

	private double creditLimit;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "id")
	private List<Orders> orders;
}
