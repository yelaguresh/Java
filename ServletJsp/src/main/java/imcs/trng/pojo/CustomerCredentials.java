package imcs.trng.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customercredentials")
public class CustomerCredentials implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "Username")
	private String Username;

	@Column(name = "Password")
	private String Password;

}
