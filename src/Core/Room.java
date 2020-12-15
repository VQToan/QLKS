package Core;

import java.io.Serializable;

public class Room implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String iDsRoom;
	private String status;
	private String beds; // sá»‘ giÆ°á»�ng (1- Ä‘Æ¡n , 2- Ä‘Ã´i, 11- 2 láº»)
	private String typeRoom; // (option : N - normal, V - vip)
	private int price1Hour;
	private int priceOverNight;
	public Room() {
		super();
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Room [iDsRoom=" + iDsRoom + ", status=" + status + ", beds=" + beds + ", typeRoom=" + typeRoom
				+ ", price1Hour=" + price1Hour + ", priceOverNight=" + priceOverNight + "]";
	}
	public String getiDsRoom() {
		return iDsRoom;
	}
	public void setiDsRoom(String iDsRoom) {
		this.iDsRoom = iDsRoom;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getBeds() {
		return beds;
	}
	public void setBeds(String beds) {
		this.beds = beds;
	}
	public String getTypeRoom() {
		return typeRoom;
	}
	public void setTypeRoom(String typeRoom) {
		this.typeRoom = typeRoom;
	}
	public int getPrice1Hour() {
		return price1Hour;
	}
	public void setPrice1Hour(int price1Hour) {
		this.price1Hour = price1Hour;
	}
	public int getPriceOverNight() {
		return priceOverNight;
	}
	public void setPriceOverNight(int priceOverNight) {
		this.priceOverNight = priceOverNight;
	}
	public Room(String iDsRoom, String status, String beds, String typeRoom, int price1Hour, int priceOverNight) {
		super();
		this.iDsRoom = iDsRoom;
		this.status = status;
		this.beds = beds;
		this.typeRoom = typeRoom;
		this.price1Hour = price1Hour;
		this.priceOverNight = priceOverNight;
	}
	public String getXMLStringofRoom() {
		return "	<Room>\r\n"
				+ "		<iDsRoom>"+iDsRoom+"</iDsRoom>\r\n"
				+ "		<status>"+status+"</status>\r\n"
				+ "		<beds>"+beds+"</beds>\r\n"
				+ "		<typeRoom>"+typeRoom+"</typeRoom>\r\n"
				+ "		<price1Hour>"+String.valueOf(price1Hour)+"</price1Hour>\r\n"
				+ "		<priceOverNight>"+String.valueOf(priceOverNight)+"</priceOverNight>\r\n"
				+ "	</Room>";
	}
}
