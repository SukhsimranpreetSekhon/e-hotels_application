package eHotel.entities;

public class booking {
	
	private String room_no;
	private int customer_ssn;
	private String booking_id;
	private String hotel_id;
	private String start;
	private String end;
	private String hotel_name;
	private String street_name;
	private int street_number;
	private String city;
	private String postal;
	private String province;
	
	public booking(){
		
	}
	public String getHotel_name() {
		return hotel_name;
	}
	public void setHotel_name(String hotel_name) {
		this.hotel_name = hotel_name;
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
	public String getPostal() {
		return postal;
	}
	public void setPostal(String postal) {
		this.postal = postal;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getRoom_no() {
		return room_no;
	}


	public void setRoom_no(String room_no) {
		this.room_no = room_no;
	}


	public int getCustomer_ssn() {
		return customer_ssn;
	}


	public void setCustomer_ssn(int customer_ssn) {
		this.customer_ssn = customer_ssn;
	}


	public String getBooking_id() {
		return booking_id;
	}


	public void setBooking_id(String booking_id) {
		this.booking_id = booking_id;
	}


	public String getHotel_id() {
		return hotel_id;
	}


	public void setHotel_id(String hotel_id) {
		this.hotel_id = hotel_id;
	}


	public String getStart() {
		return start;
	}


	public void setStart(String start) {
		this.start = start;
	}


	public String getEnd() {
		return end;
	}


	public void setEnd(String end) {
		this.end = end;
	}

	
	
	
}
