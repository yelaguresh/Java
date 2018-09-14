package trng.json.domain;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
 
@Getter
@Setter
@Data
@JsonIgnoreProperties("dateOfBirth")
public class Employee {
 
    private int id;
    private String name;
    private boolean permanent;
    private List<Address> addresses;
    private long[] phoneNumbers;
    private String role;
    private List<String> cities;
    @JsonProperty("salary")
    private Map<String, Integer> salaryMap;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isPermanent() {
		return permanent;
	}
	public void setPermanent(boolean permanent) {
		this.permanent = permanent;
	}
	public List<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	public long[] getPhoneNumbers() {
		return phoneNumbers;
	}
	public void setPhoneNumbers(long[] phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public List<String> getCities() {
		return cities;
	}
	public void setCities(List<String> cities) {
		this.cities = cities;
	}
	public Map<String, Integer> getSalaryMap() {
		return salaryMap;
	}
	public void setSalaryMap(Map<String, Integer> salaryMap) {
		this.salaryMap = salaryMap;
	}
}