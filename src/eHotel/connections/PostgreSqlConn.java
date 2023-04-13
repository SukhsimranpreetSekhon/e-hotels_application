package eHotel.connections;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import eHotel.entities.Hotel;
import eHotel.entities.Room;
import eHotel.entities.booking; 


public class  PostgreSqlConn{
	
		Connection db = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    Statement st = null;
	    String sql;


		public void getConn(){
			
			try {
				
				Class.forName("org.postgresql.Driver"); 
								
				db = DriverManager.getConnection("jdbc:postgresql://web0.site.uottawa.ca:15432/",
						"mgood062", "MaMaChew1234567");
															
			}catch(Exception e) {
				System.out.print("error catched");
			}
						
		}
		
		public void closeDB() {
				try {
					if(rs != null){
						rs.close();
					}
					if(ps!=null){
						ps.close();
					}
					if(st!=null){
						st.close();
					}
					if(db!=null){
						db.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}

		
		public String[] getpwdbyUname(String param){
			getConn();
			String[] pwd = new String[2];
			
	        try{
	            ps = db.prepareStatement("select * from project.employee where ssn_sin=?");
	            
	            ps.setInt(1, Integer.parseInt(param));	               
	            rs = ps.executeQuery();
	
				while(rs.next()) {
					pwd[0] = rs.getString("password");
					pwd[1] = rs.getString("first_name");
				}
				
	            //System.out.println(pwd[1]);
	            
	        }catch(SQLException e){
	            e.printStackTrace();
	        }finally {
	        	closeDB();
	        }
			return pwd;       
	    }
		
		public  ArrayList<Room> getWalkInRooms(String employeeSSN, String start_date, String end_date){
			
			getConn();
			
			ArrayList<Room> Rooms = new ArrayList<Room>();
			
			try {
				ps = db.prepareStatement("select distinct(project.room.room_number), project.room.hotel_id, project.room.view_type, project.room.extendable, project.room.price, project.room.capacity, project.room.reserved "
						+ "from (((project.employee left outer join project.hotel on (project.employee.hotel_id = project.hotel.hotel_id)) "
						+ "right outer join project.room on (project.room.hotel_id = project.hotel.hotel_id)) right outer join project.booking on (project.booking.room_number = project.room.room_number)) "
						+ " where ssn_sin = "+employeeSSN+" and (not((start_date <= '"+end_date+"') and ('"+start_date+"' <= end_date)) or start_date is null);");
				
				rs = ps.executeQuery();
				
				while(rs.next()){
					
					Room room = new Room();
					room.setCapacity(rs.getString("capacity"));
					room.setExtendable(rs.getBoolean("extendable"));
					room.setPrice(rs.getInt("price"));
					room.setReserved(rs.getBoolean("reserved"));
					room.setHotel_id(rs.getInt("hotel_id"));
					room.setView(rs.getString("view_type"));
					room.setRoom_no(rs.getInt("room_number"));
					Rooms.add(room);
					
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
	        	closeDB();
	        }
						
			return Rooms;
			
		}
		
		public String[] getuserinforbycustSSN(int param){
			getConn();

			String[] pwd = new String[2];
			
	        try{
	            ps = db.prepareStatement("select * from project.customer where ssn_sin=?");
	            
	            ps.setInt(1, param);	               
	            rs = ps.executeQuery();
	
				while(rs.next()) {
					pwd[0] = rs.getString("first_name");
					pwd[1] = rs.getString("password");
					
				}
	            
	        }catch(SQLException e){
	            e.printStackTrace();
	        }finally{ 
	        	closeDB();
	        }
			return pwd;       
	    }
		public String[] manPass(int param){
			getConn();

			String[] pwd = new String[2];
			
	        try{
	            ps = db.prepareStatement("select * from project.managers where ssn_sin=?");
	            
	            ps.setInt(1, param);	               
	            rs = ps.executeQuery();
	
				while(rs.next()) {
					pwd[0] = rs.getString("first_name");
					pwd[1] = rs.getString("password");
					
				}
	            
	        }catch(SQLException e){
	            e.printStackTrace();
	        }finally{ 
	        	closeDB();
	        }
			return pwd;       
	    }
		
		public void insertNewCustomer(String custStreetName,String custStreetNumber,String custCity,String custZipPostal,String custProvince,String custFirstName,String custMiddleInitial,String custLastName,int custSSN,String custPwd,String date){
			getConn();

			
	        try{
	        	st = db.createStatement();
	        	sql = "insert into project.customer(street_name, street_number, city, zip_postal, state_province, first_name, middle_initial, last_name, ssn_sin, password, registration_date) values ('"+custStreetName+"','"+custStreetNumber+"','"+custCity+"','"+custZipPostal+"','"+custProvince+"','"+custFirstName+"','"+custMiddleInitial+"','"+custLastName+"','"+custSSN+"','"+custPwd+"','"+date+"');";
	        	
	        	//System.out.print(sql);
	            
	            st.executeQuery(sql);
	            

	        }catch(SQLException e){
	            e.printStackTrace();
	           
	        }finally {
	        	closeDB();
	        }	       
	    }
		public void employee(String hotel_id,String custStreetName,String custStreetNumber,String custCity,String custZipPostal,String custProvince,String custFirstName,String custMiddleInitial,String custLastName,int custSSN,String custPwd){
			getConn();

			
	        try{
	        	st = db.createStatement();
	        	sql = "insert into project.employee(hotel_id,street_name, street_number, city, zip_postal, state_province, first_name, middle_initial, last_name, ssn_sin, password) values ('"+hotel_id+"','"+custStreetName+"',"+custStreetNumber+",'"+custCity+"','"+custZipPostal+"','"+custProvince+"','"+custFirstName+"','"+custMiddleInitial+"','"+custLastName+"','"+custSSN+"','"+custPwd+"');";
	        	
	        	//System.out.print(sql);
	            
	            st.executeQuery(sql);
	            

	        }catch(SQLException e){
	            e.printStackTrace();
	           
	        }finally {
	        	closeDB();
	        }	       
	    }
		
		public  ArrayList<Room> getAvailRooms(String start, String end, String city, String capacity, int rating, int price){
			
			getConn();
			
			ArrayList<Room> Rooms = new ArrayList<Room>();
			
			try {
				ps = db.prepareStatement("select * from ((project.room left outer join project.booking on (project.room.room_number = project.booking.room_number) and (project.room.hotel_id = project.booking.hotel_id)) "
						+ "left outer join project.hotel on (project.room.hotel_id = project.hotel.hotel_id))  where (not((start_date <='"+end+"') and ('"+start+"' <= end_date)) or start_date is null) "
								+ "and city='"+city+"' and capacity='"+capacity+"' and star_rating>="+rating+"and price<="+price);
				rs = ps.executeQuery();
				while(rs.next()){
					Room room = new Room();
					room.setCapacity(rs.getString("capacity"));
					room.setExtendable(rs.getBoolean("extendable"));
					room.setPrice(rs.getInt("price"));
					room.setReserved(rs.getBoolean("reserved"));
					room.setHotel_id(rs.getInt("hotel_id"));
					room.setView(rs.getString("view_type"));
					room.setRoom_no(rs.getInt("room_number"));
					
					//Hotel Information:
					room.setChain_name(rs.getString("hotel_chain_name"));
					room.setCity(rs.getString("city"));
					room.setRating(rs.getInt("star_rating"));
					room.setState_province(rs.getString("state_province"));
					room.setStreet_name(rs.getString("street_name"));
					room.setStreet_number(rs.getInt("street_number"));
					room.setZip_postal(rs.getString("zip_postal"));
					room.setEmail(rs.getString("email"));
					
					
					Rooms.add(room);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
	        	closeDB();
	        }
						
			return Rooms;
			
		}
		
		public  ArrayList<Room> getAllAvailRooms(){
			
			getConn();
			
			ArrayList<Room> Rooms = new ArrayList<Room>();
			
			try {
				ps = db.prepareStatement("select * from project.room" );
				rs = ps.executeQuery();
				while(rs.next()){
					Room room = new Room();
					room.setCapacity(rs.getString("capacity"));
					room.setExtendable(rs.getBoolean("extendable"));
					room.setPrice(rs.getInt("price"));
					room.setReserved(rs.getBoolean("reserved"));
					room.setHotel_id(rs.getInt("hotel_id"));
					room.setView(rs.getString("view_type"));
					room.setRoom_no(rs.getInt("room_number"));
					
					Rooms.add(room);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
	        	closeDB();
	        }
						
			return Rooms;
			
		}
		
		public  ArrayList<String> getCities(){
			
			getConn();
			
			ArrayList<String> cities = new ArrayList<String>();
			
			try {
				ps = db.prepareStatement("select distinct city from project.hotel" );
				rs = ps.executeQuery();
				while(rs.next()){
					String city = rs.getString("city");
					//System.out.println(city);
					cities.add(city);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
	        	closeDB();
	        }
						
			return cities;
			
		}
		public  String getCityCount(String city){
					
					getConn();
					
					String num = "";
					
					try {
						
						ps = db.prepareStatement("select sum(project.hotel.number_of_rooms) from project.hotel where project.hotel.city = '"+city+"';" );
						rs = ps.executeQuery();
						
						while(rs.next()){
							
							num = "City: " + city + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Number of Rooms: " + rs.getString(1);
							
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} finally {
			        	closeDB();
			        }
								
					return num;
					
				}
		
		public ArrayList<booking> getbookedRooms(int custSSN){
			
			getConn();
			
			ArrayList<booking> bookings = new ArrayList<booking>();
			
			try {
				ps = db.prepareStatement("select * from project.booking left outer join project.hotel on (project.booking.hotel_id = project.hotel.hotel_id) where customer_ssn_sin='"+custSSN+"'");
				rs = ps.executeQuery();
				while(rs.next()){
					booking booking = new booking();
					booking.setRoom_no(rs.getString("room_number"));
					booking.setHotel_id(rs.getString("hotel_id"));
					booking.setStart(rs.getString("start_date"));
					booking.setEnd(rs.getString("end_date"));
					booking.setBooking_id(rs.getString("booking_id"));
					booking.setCustomer_ssn(custSSN);
					booking.setHotel_name(rs.getString("hotel_chain_name"));
					booking.setStreet_name(rs.getString("street_name"));
					booking.setStreet_number(rs.getInt("street_number"));
					booking.setCity(rs.getString("city"));
					booking.setPostal(rs.getString("zip_postal"));
					booking.setProvince(rs.getString("state_province"));
					bookings.add(booking);
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
	        	closeDB();
	        }
						
			return bookings;
			
		}
		
		public ArrayList<Hotel> getHotelsByArea(String area){
			
			getConn();
			
			ArrayList<Hotel> hotels = new ArrayList<Hotel>();
			
			try {
				
				ps = db.prepareStatement("select * from project.hotel where city='"+area+"'");
				
				rs = ps.executeQuery();
				
				while(rs.next()){
					
					Hotel hotel = new Hotel();
					
					hotel.setHotel_id(rs.getInt("hotel_id"));
					hotel.setEmail(rs.getString("email"));
					hotel.setManager_ssn_sin(rs.getInt("manager_ssn_sin"));
					hotel.setNumber_of_rooms(rs.getInt("number_of_rooms"));
					hotel.setHotel_chain_name(rs.getString("hotel_chain_name"));
					hotel.setStar_rating(rs.getInt("star_rating"));
					
					hotel.setStreet_name(rs.getString("street_name"));
					hotel.setStreet_number(rs.getInt("street_number"));
					hotel.setCity(rs.getString("city"));
					hotel.setProvince(rs.getString("state_province"));
					hotel.setZip_postal(rs.getString("zip_postal"));
			
					hotels.add(hotel);
				
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
	        	closeDB();
	        }
						
			return hotels;
			
		}
		
		public void bookRoom(int booking_id, int hotel_id, int customer_ssn, String start, String end, int room){
			getConn();
			
	        try{
	        	
	        	ps = db.prepareStatement("INSERT INTO project.booking(booking_id, hotel_id, customer_ssn_sin, start_date, end_date, room_number)VALUES ("+booking_id+","+hotel_id+","+customer_ssn+", '"+start+"', '"+end+"',"+room+");");
				rs = ps.executeQuery();

	        }catch(SQLException e){
	            e.printStackTrace();
	           
	        }finally {
	        	closeDB();
	        }
			      
	    }
		
		public int getBookingId(){
			getConn();
			int id=0;
	        try{
	        	
	        	ps = db.prepareStatement("select MAX(booking_id) from project.booking");
				rs = ps.executeQuery();
				while(rs.next()){
				id= rs.getInt(1);
				return id;
				}
				
				
	        }catch(SQLException e){
	            e.printStackTrace();
	           
	        }finally {
	        	closeDB();
	        }
			
			return id;     
	    }
		
		public int getmaxrent(){
			getConn();
			int id=0;
	        try{
	        	
	        	ps = db.prepareStatement("select MAX(renting_id) from project.renting");
				rs = ps.executeQuery();
				while(rs.next()){
				id= rs.getInt(1);
				return id;
				}
				
				
	        }catch(SQLException e){
	            e.printStackTrace();
	           
	        }finally {
	        	closeDB();
	        }
			
			return id;     
	    }
		
		public void checkin(int max,int booking_id,int employee_ssn,int customer_ssn,String start,String end,int room_number,int hotel_id){
			getConn();
	        try{
	        	
	        	ps = db.prepareStatement("insert into project.renting(renting_id, booking_id, employee_ssn_sin, customer_ssn_sin, start_date, end_date, room_number, hotel_id)"
	        			+ "values ("+max+","+booking_id+","+employee_ssn+","+customer_ssn+",'"+start+"', '"+end+"',"+room_number+","+hotel_id+")");
				rs = ps.executeQuery();
				
				
	        }catch(SQLException e){
	            e.printStackTrace();
	           
	        }finally {
	        	closeDB();
	        }
			
		}

		public ArrayList<Room> getHotelRooms(String hotel) {
				getConn();
				
				ArrayList<Room> Rooms = new ArrayList<Room>();
				
				try {
					ps = db.prepareStatement("select * from project.room where project.room.hotel_id ="+hotel+";" );
					rs = ps.executeQuery();
					while(rs.next()){
						Room room = new Room();
						room.setCapacity(rs.getString("capacity"));
						room.setExtendable(rs.getBoolean("extendable"));
						room.setPrice(rs.getInt("price"));
						room.setReserved(rs.getBoolean("reserved"));
						room.setHotel_id(rs.getInt("hotel_id"));
						room.setView(rs.getString("view_type"));
						room.setRoom_no(rs.getInt("room_number"));
						
						Rooms.add(room);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
		        	closeDB();
		        }
							
				return Rooms;
		}
		
		
//		public static void main(String []args) {
//			PostgreSqlConn con = new PostgreSqlConn();
//			con.getConn();
//			String pwd = con.getpwdbyUname("8366341");
//			
//			System.out.println(pwd);
//				
//			
//			
//		}

		
	}