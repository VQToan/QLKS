package Core;

import java.util.ArrayList;
/*
 * Lưu ý về dữ liệu vào phải là String
 * 
 * giá trị mặc định của biến vào phải là chuỗi "None"
 * TimeIn và TimeOut dùng hệ 24h để thuận lợi cho tìm kiếm
 * 
 * */
public class OptionSearch {
//	ArrayList<Customer> dataCustomers;
//	String rollNo;
//	String firstName;
//	String fullName;
//	String iD;
//	String iDRom;
//	String dateIn;
//	String dateOut;
//	String timeIn;
//	String timeOut;
//	ArrayList<Room> dataRooms;
//	String iDRoom, status, beds, typeRoom, prices;
//	
//	public OptionSearch(ArrayList<Customer> dataCustomers, String rollNo, String firstName, String fullName, String iD,
//			String iDRom, String dateIn, String dateOut, String timeIn, String timeOut) {
//		super();
//		this.dataCustomers = dataCustomers;
//		this.rollNo = rollNo;
//		this.firstName = firstName;
//		this.fullName = fullName;
//		this.iD = iD;
//		this.iDRom = iDRom;
//		this.dateIn = dateIn;
//		this.dateOut = dateOut;
//		this.timeIn = timeIn;
//		this.timeOut = timeOut;
//	}
	//================ TIM THEO THONG TIN KHAC HANG======================//
	public boolean check1(Customer data, String method, String key) {
		boolean flag = false;
		if (key.equals("")) flag= true; 
		else {
			if (method.equals("rollNo") && data.getRollNo().equals(key)) flag= true;
			if (method.equals("phoneNumber") && data.getPhoneNumber().equals(key)) flag = true;
			if (method.equals("fullName") && data.getFullName().equals(key)) flag = true;
			if (method.equals("iD") && data.getiD().equals(key)) flag= true;
			if(method.equals("typeRent") && data.getTypeRent().equals(key)) flag= true;
			if (method.equals("iDRoom") && data.getiDRoom().equals(key)) flag= true;
			if (method.equals("dateIn") && (data.getInOut().getdateIn().equals(key) | key.equalsIgnoreCase("dd-mm-yyyy"))) flag= true;
			if (method.equals("dateOut") && (data.getInOut().getdateOut().equals(key) | key.equalsIgnoreCase("dd-mm-yyyy"))) flag = true;
			if (method.equals("timeIn" )&& data.getInOut().getTimeIn().equals(key)|key.equals("0")) flag= true;
			if (method.equals("timeOut") && data.getInOut().getTimeOut().equals(key)|key.equals("0")) flag= true;
		}
		return flag;
	}
	public ArrayList<Customer> searchCustomers(ArrayList<Customer> dataCustomers, String rollNo, String phoneNumber,String typeRent, String fullName, String iD, String iDRom, String dateIn,String dateOut, String timeIn, String timeOut) {
		ArrayList<Customer> endSearchArrayList1 = new ArrayList<>();
		for (Customer customer : dataCustomers) {
			if(		check1(customer,"rollNo", rollNo)
				&&	check1(customer,"phoneNumber", phoneNumber)
				&&	check1(customer,"fullName", fullName)
				&&	check1(customer,"iD", iD)
				&& check1(customer, "typeRent",typeRent )
				&&	check1(customer,"iDRoom", iDRom)
				&&	check1(customer,"dateIn", dateIn)
				&&	check1(customer,"dateOut", dateOut)
				&&	check1(customer,"timeIn", timeIn)
				&&	check1(customer,"timeOut", timeOut)
					) {
				endSearchArrayList1.add(customer);
			}
		}if (endSearchArrayList1.isEmpty()) {
			endSearchArrayList1.add(new Customer("NoneItem", "", "", "", "", "", (new InfoTime("", "", "", ""))));
			return endSearchArrayList1;
		}
		//endSearchArrayList1.add(new Customer());
			return endSearchArrayList1;		
	}
	//==========TIM THEO THONG TIN PHONG==================================//
	/*status= ["true","false"]
	 * 
	 * 
	 * */
	
	public boolean check(Room data, String method, String key) {
		boolean flag= false;
		if (key.equals("")) flag= true;
		else {
			if (method.equals( "iDsRoom") && data.getiDsRoom().equals(key) ) flag= true;
			if (method.equals( "status") && data.getStatus().equals(key)) flag= true;
			if (method.equals( "beds") && data.getBeds().equals(key)) flag= true;
			if(method.equals( "typeRoom") && data.getTypeRoom().equals(key)) flag= true;
			if (method.equals("price1Hour") && String.valueOf(data.getPrice1Hour()).equals(key)) flag= true;
			if (method.equals("priceOverNight") && String.valueOf(data.getPriceOverNight()).equals(key)) flag= true; 
			}
		return flag;
	}
	
	public ArrayList<Room> SearchRoom(ArrayList<Room> dataRooms, String iDRoom, String status, String beds, String typeRoom, String price){
		ArrayList<Room> endSearchArrayList = new ArrayList<>();
		for (Room room : dataRooms) {
			if (check(room, "iDsRoom", iDRoom)
				&& check(room, "status", status)
				&& check(room, "beds", beds)
				&& (check(room, "priceOverNight", nearest(price, dataRooms, "PriceOverNight")) | check(room, "price1Hour", nearest(price, dataRooms, "Price1Hour")))
				&& check(room, "typeRoom", typeRoom))
				{
				endSearchArrayList.add(room);
			}
		}
		//endSearchArrayList.add(new Room());
		if (endSearchArrayList.isEmpty()) {
			endSearchArrayList.add(new Room("NoneItem","", "", "", 0,0));
			return endSearchArrayList;
		}
		else return endSearchArrayList;
	}
	public String nearest( String numberIn, ArrayList<Room> dataRoom, String method) {
		if (numberIn.equals("")) return "";
		else {
			int numberIn1= Integer.valueOf(numberIn);
			int nearNumber=0;
		int distance=0;
		if (method.equalsIgnoreCase("Price1Hour")) {
			nearNumber=dataRoom.get(0).getPrice1Hour();
			distance=dataRoom.get(0).getPrice1Hour();
			for (Room room : dataRoom) {
				if (Math.abs(numberIn1-room.getPrice1Hour())< distance) {
					nearNumber=room.getPrice1Hour();
				}
				
			}
		}
		if (method.equalsIgnoreCase("PriceOverNight")) {
			nearNumber=dataRoom.get(0).getPrice1Hour();
			distance=dataRoom.get(0).getPrice1Hour();
				for (Room room : dataRoom) {
					if (Math.abs(numberIn1-room.getPriceOverNight())< distance) {
						nearNumber=room.getPriceOverNight();
					}
				}
			}
			return String.valueOf(nearNumber);
			}
		}
	public String searchMinPrice(ArrayList<Room> dataRooms, String method) {
		int priceend=0;
		if (method.equals("Theo giờ")) {
			priceend= dataRooms.get(0).getPrice1Hour();
			for (Room room : dataRooms) {
				if (priceend>room.getPrice1Hour()) {
					priceend=room.getPrice1Hour();
				}
			}
		}
		if (method.equals("Qua đêm")) {
			priceend= dataRooms.get(0).getPriceOverNight();
			for (Room room : dataRooms) {
				if (priceend>room.getPriceOverNight()) {
					priceend=room.getPriceOverNight();
				}
			}
		}
		return String.valueOf(priceend);
	}
}
