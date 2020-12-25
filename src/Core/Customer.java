package Core;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Customer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String rollNo;
	private String fullName;
	private String iD;
	private String phoneNumber;
	private String typeRent;
	private String iDRoom;
	private InfoTime inOut;
	private String Payment;
	DateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
	DataFile input = new DataFile();
	
	public String getRollNo() {
		return rollNo;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}
	public Customer(String rollNo, String fullName, String iD, String phoneNumber, String typeRent, String iDRoom,
			InfoTime inOut) {
		super();
		this.rollNo = rollNo;
		this.fullName = fullName;
		this.iD = iD;
		this.phoneNumber = phoneNumber;
		this.typeRent = typeRent;
		this.iDRoom = iDRoom;
		this.inOut = inOut;
	}
	public String getiD() {
		return iD;
	}
	public void setiD(String iD) {
		this.iD = iD;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	} 
	public String getTypeRent() {
		return typeRent;
	}
	public void setTypeRent(String typeRent) {
		this.typeRent = typeRent;
	}
	public String getiDRoom() {
		return iDRoom;
	}
	public void setiDRoom(String iDRoom) {
		this.iDRoom = iDRoom;
	}
	public InfoTime getInOut() {
		return inOut;
	}
	public void setInOut(InfoTime inOut) {
		this.inOut = inOut;
	}
	public Customer() {
		super();
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getPayment() {
		return Payment;
	}

	public void setPayment(String payment) {
		this.Payment = payment;
	}
	
	@Override
	public String toString() {
		return "Customer [rollNo=" + rollNo + ", fullName=" + fullName + ", iD=" + iD + ", phoneNumber=" + phoneNumber
				+ ", typeRent=" + typeRent + ", iDRoom=" + iDRoom + ", inOut=" + inOut + "]";
	}
	public String getXMLStringofCustomer() {
		return "<Customer>\r\n"
				+ "		<rollNo>"+rollNo+"</rollNo>\r\n"
				+ "		<fullName>"+fullName+" </fullName>\r\n"
				+ "		<iD>"+iD+"</iD>\r\n"
				+ "		<phoneNumber>"+phoneNumber+"</phoneNumber>\r\n"
				+ "		<iDRoom>"+iDRoom+"</iDRoom>\r\n"
				+ "		<typeRent>"+typeRent+"</typeRent>\r\n"
				+ "		<amountPaid>"+Payment+"</amountPaid>\r\n"
				+ "		<inOut>\r\n"
				+ "			<timeIn>"+inOut.getTimeIn()+"</timeIn>\r\n"
				+ "			<dateIn>"+inOut.getdateIn()+"</dateIn>\r\n"
				+ "			<timeOut>"+inOut.getTimeOut()+"</timeOut>\r\n"
				+ "			<dateout>"+inOut.getdateOut()+"</dateout>\r\n"
				+ "		</inOut>\r\n"
				+ "	</Customer>";
	}

	public String Cost(String time){
		ArrayList<Room> dataRoom = new ArrayList<Room>();
		int amountPaid=0;
		if(typeRent.equals("Theo giờ")){
			amountPaid=valueSearch(dataRoom)*Integer.parseInt(time);
		} else if (typeRent.equals("Qua đêm")) {
			amountPaid = valueSearch2(dataRoom)*Integer.parseInt(time);
		}
		Payment = String.valueOf(amountPaid) + " VNĐ";
		return Payment;
	}

	public int valueSearch2(ArrayList<Room> dataRoom) {
		int value =0;
		dataRoom = input.importRoom();
		for (Room room : dataRoom) {
			if (iDRoom.equals(room.getiDsRoom())) {
				value=room.getPriceOverNight();
			}
		}
		return value;
	}
	public int valueSearch(ArrayList<Room> dataRoom) {
		int value =0;
		dataRoom = input.importRoom();
		for (Room room : dataRoom) {
			if (iDRoom.equals(room.getiDsRoom())) {
				value=room.getPrice1Hour();
			}
		}
		return value;
	}	
}
