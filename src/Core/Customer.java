package Core;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
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
	DateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
	
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
				+ "		<inOut>\r\n"
				+ "			<timeIn>"+inOut.getTimeIn()+"</timeIn>\r\n"
				+ "			<dateIn>"+inOut.getdateIn()+"</dateIn>\r\n"
				+ "			<timeOut>"+inOut.getTimeOut()+"</timeOut>\r\n"
				+ "			<dateout>"+inOut.getdateOut()+"</dateout>\r\n"
				+ "		</inOut>\r\n"
				+ "	</Customer>";
	}

	public long calTime() {
		try {
			return (long) Math.ceil((double)(simpleDateFormat.parse(inOut.getdateOut()+" "+ inOut.getTimeOut()).getTime()- simpleDateFormat.parse(inOut.getdateIn()+" "+ inOut.getTimeIn()).getTime())/(1000*60*60));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	public long payment(ArrayList<Room> dataRoom) {
		long amountPaid = 0;
		if(typeRent.equals("1Hour")) amountPaid= valueSearch(dataRoom)*calTime();
		else {
			amountPaid= valueSearch2(dataRoom);
		}
		return amountPaid;
	}
	
	public int valueSearch(ArrayList<Room> dataRoom) {
		OptionSearch search = new OptionSearch();
		if (search.SearchRoom(dataRoom, iDRoom, "", "", "", "").size()>1) {
			return search.SearchRoom(dataRoom, iDRoom, "", "", "", "").get(0).getPrice1Hour();
		}else return 0;
		
		
	}
	public int valueSearch2(ArrayList<Room> dataRoom) {
		OptionSearch search = new OptionSearch();
		if (search.SearchRoom(dataRoom, iDRoom, "", "", "", "").size()>1) {
			return search.SearchRoom(dataRoom, iDRoom, "", "", "", "").get(0).getPriceOverNight();
		}else return 0;
	}
}
