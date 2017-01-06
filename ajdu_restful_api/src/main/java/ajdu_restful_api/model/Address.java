package ajdu_restful_api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Address {

	@Id
	@GeneratedValue
	private Integer id;
	private String city;
	private String postalCode;
	private String country;
	private String region;
	private String line1;
	private String line2;
	
	@OneToOne(mappedBy="address")
	private Organization organization;
	
	
	public Address(){}

	public Address(String city, String postalCode, String country,
			String region, String line1, String line2) {
		super();
		this.city = city;
		this.postalCode = postalCode;
		this.country = country;
		this.region = region;
		this.line1 = line1;
		this.line2 = line2;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getLine1() {
		return line1;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public String getLine2() {
		return line2;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", city=" + city + ", postalCode="
				+ postalCode + ", country=" + country + ", region=" + region
				+ ", line1=" + line1 + ", line2=" + line2 + "]";
	};
	
	
	
}
