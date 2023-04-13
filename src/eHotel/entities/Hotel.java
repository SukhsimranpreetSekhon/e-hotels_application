package eHotel.entities;

public class Hotel {
	
	int hotel_id;
	String hotel_chain_name;
	int number_of_rooms;
	int star_rating;
	String email;
	String street_name;
	int street_number;
	String city;
	String zip_postal;
	String province;
	int manager_ssn_sin;
	
	public int getHotel_id() {
		return hotel_id;
	}
	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
	}
	public String getHotel_chain_name() {
		return hotel_chain_name;
	}
	public void setHotel_chain_name(String hotel_chain_name) {
		this.hotel_chain_name = hotel_chain_name;
	}
	public int getNumber_of_rooms() {
		return number_of_rooms;
	}
	public void setNumber_of_rooms(int number_of_rooms) {
		this.number_of_rooms = number_of_rooms;
	}
	public int getStar_rating() {
		return star_rating;
	}
	public void setStar_rating(int star_rating) {
		this.star_rating = star_rating;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStreet_name() {
		return street_name;
	}
	public void setStreet_name(String street_name) {
		this.street_name = street_name;
	}
	public int getStreet_number() {
		return street_number;
	}
	public void setStreet_number(int street_number) {
		this.street_number = street_number;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZip_postal() {
		return zip_postal;
	}
	public void setZip_postal(String zip_postal) {
		this.zip_postal = zip_postal;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public int getManager_ssn_sin() {
		return manager_ssn_sin;
	}
	public void setManager_ssn_sin(int manager_ssn_sin) {
		this.manager_ssn_sin = manager_ssn_sin;
	}
	
	public String toString(){
		return (hotel_chain_name+" (" +star_rating+"), "+street_number+" "+street_name+" "+zip_postal);
	}
}
