package eHotel.entities;

public class Room {
	
	private int room_no;
	private boolean reserved;
	private String customer_ssn;
	private String view;
	private int price;
	private String capacity;
	private boolean extendable;
	private int hotel_id;
	
	//Hotel Information:
	private String chain_name;
	private int rating;
	private String email;
	private String street_name;
	private int street_number;
	private String city;
	private String zip_postal;
	private String state_province;
	
	
	public Room() {
		
	}


	public int getRoom_no() {
		return room_no;
	}
	
	public String toString(){
		return ("Room: "+room_no+", Capacity: "+capacity);
	}

	public void setRoom_no(int room_no) {
		this.room_no = room_no;
	}


	public boolean isReserved() {
		return reserved;
	}


	public void setReserved(boolean reserved) {
		this.reserved = reserved;
	}


	public String getCustomer_ssn() {
		return customer_ssn;
	}


	public void setCustomer_ssn(String customer_ssn) {
		this.customer_ssn = customer_ssn;
	}


	public String getView() {
		return view;
	}


	public void setView(String view) {
		this.view = view;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getCapacity() {
		return capacity;
	}


	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}


	public boolean isExtendable() {
		return extendable;
	}


	public void setExtendable(boolean extendable) {
		this.extendable = extendable;
	}


	public int getHotel_id() {
		return hotel_id;
	}


	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
	}


	public String getChain_name() {
		return chain_name;
	}


	public void setChain_name(String chain_name) {
		this.chain_name = chain_name;
	}


	public int getRating() {
		return rating;
	}


	public void setRating(int rating) {
		this.rating = rating;
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


	public String getState_province() {
		return state_province;
	}


	public void setState_province(String state_province) {
		this.state_province = state_province;
	}
}
