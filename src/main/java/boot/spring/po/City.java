package boot.spring.po;


import java.util.Date;

public class City {
	private short city_id;
	private String city;
	private Date last_update;
	private Country country;
	public short getCity_id() {
		return city_id;
	}
	public void setCity_id(short city_id) {
		this.city_id = city_id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}

	public Date getLast_update() {
		return last_update;
	}

	public void setLast_update(Date last_update) {
		this.last_update = last_update;
	}
}
