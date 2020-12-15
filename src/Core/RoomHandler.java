package Core;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class RoomHandler extends DefaultHandler{
	ArrayList<Room> roomlList =new ArrayList<>();
	Room currentRoom = null;
	boolean isIDsRoom = false,
			isStatus = false,
			isBeds = false,
			isTypeRoom = false,
			isPrice1Hour = false,
			isPriceOverNight= false;
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if (qName.equalsIgnoreCase("Room")) {
			currentRoom = new Room();
		}else if (qName.equalsIgnoreCase("iDsRoom")) {
			isIDsRoom=true;
		}else if (qName.equalsIgnoreCase("status")) {
			isStatus=true;
		}else if (qName.equalsIgnoreCase("beds")) {
			isBeds=true;
		}else if (qName.equalsIgnoreCase("typeRoom")) {
			isTypeRoom=true;
		}else if (qName.equalsIgnoreCase("price1Hour")) {
			isPrice1Hour=true;
		}else if (qName.equalsIgnoreCase("priceOverNight")) {
			isPriceOverNight= true;
		}
		super.startElement(uri, localName, qName, attributes);
	}
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equalsIgnoreCase("Room")) {
			roomlList.add(currentRoom);
			currentRoom = null;
		}else if (qName.equalsIgnoreCase("iDsRoom")) {
			isIDsRoom=false;
		}else if (qName.equalsIgnoreCase("status")) {
			isStatus=false;
		}else if (qName.equalsIgnoreCase("beds")) {
			isBeds=false;
		}else if (qName.equalsIgnoreCase("typeRoom")) {
			isTypeRoom=false;
		}else if (qName.equalsIgnoreCase("price1Hour")) {
			isPrice1Hour=false;
		}else if (qName.equalsIgnoreCase("priceOverNight")) {
			isPriceOverNight= false;
		}
		super.endElement(uri, localName, qName);
	}
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String value = new String(ch,start,length);
		if(isIDsRoom) {
			currentRoom.setiDsRoom(value);
		}else if (isStatus) {
			currentRoom.setStatus(value);
		}else if (isBeds) {
			currentRoom.setBeds(value);
		}else if (isTypeRoom) {
			currentRoom.setTypeRoom(value);
		}else if (isPrice1Hour) {
			currentRoom.setPrice1Hour(Integer.valueOf(value));
		}else if (isPriceOverNight) {
			currentRoom.setPriceOverNight(Integer.valueOf(value));
		}
		super.characters(ch, start, length);
	}
	public ArrayList<Room> getRoomlList() {
		return roomlList;
	}
}
