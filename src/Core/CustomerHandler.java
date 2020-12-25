package Core;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class CustomerHandler extends DefaultHandler{
	ArrayList<Customer> customerList= new ArrayList<>();
	Customer currentCustomer = null;
	InfoTime tempInfoTime = null;
	boolean isRollNo= false,  
			isFullName= false,
			isID= false,
			isPhoneNumber=false,
			isIDRoom = false,
			isTypeRent=false,
			isAmountPaid = false,
			isInOut= false,
			isTimeIn = false,
			isTimeOut= false,
			isDateIn = false,
			isDateOut = false;
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if (qName.equalsIgnoreCase("Customer")) {
			currentCustomer = new Customer();
		}else if (qName.equalsIgnoreCase("rollNo")) {
			isRollNo= true;
		}else if (qName.equalsIgnoreCase("fullName")) {
			isFullName= true;
		}else if (qName.equalsIgnoreCase("iD")) {
			isID= true;
		}else if(qName.equalsIgnoreCase("phoneNumber")) {
			isPhoneNumber=true;
		}else if (qName.equalsIgnoreCase("iDRoom")) {
			isIDRoom= true;
		}else if(qName.equalsIgnoreCase("typeRent")){
			isTypeRent=true;
		}else if(qName.equalsIgnoreCase("amountPaid")){
			isAmountPaid=true;
		}else if (qName.equalsIgnoreCase("inOut")) {
			isInOut=true;
			tempInfoTime = new InfoTime();
		}else if (qName.equalsIgnoreCase("timeIn")) {
			isTimeIn= true;
		}else if (qName.equalsIgnoreCase("dateIn")) {
			isDateIn= true;
		}else if (qName.equalsIgnoreCase("timeOut")) {
			isTimeOut= true;
		}else if (qName.equalsIgnoreCase("dateOut")) {
			isDateOut= true;
		}
		super.startElement(uri, localName, qName, attributes);
	}
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equalsIgnoreCase("Customer")) {
			customerList.add(currentCustomer);
			currentCustomer=null;
		}else if (qName.equalsIgnoreCase("rollNo")) {
			isRollNo= false;
		}else if (qName.equalsIgnoreCase("fullName")) {
			isFullName= false;
		}else if (qName.equalsIgnoreCase("iD")) {
			isID= false;
		}else if (qName.equalsIgnoreCase("phoneNumber")) {
			isPhoneNumber=false;
		}else if (qName.equalsIgnoreCase("iDRoom")) {
			isIDRoom= false;
		}else if(qName.equalsIgnoreCase("typeRent")){
			isTypeRent=false;
		}else if(qName.equalsIgnoreCase("amountPaid")){
			isAmountPaid=false;
		}else if (qName.equalsIgnoreCase("inOut")) {
				isInOut=false;
				currentCustomer.setInOut(tempInfoTime);
				tempInfoTime = null;
		}else if (qName.equalsIgnoreCase("timeIn")) {
			isTimeIn= false;
		}else if (qName.equalsIgnoreCase("dateIn")) {
			isDateIn= false;
		}else if (qName.equalsIgnoreCase("timeOut")) {
			isTimeOut= false;
		}else if (qName.equalsIgnoreCase("dateOut")) {
			isDateOut= false;
		}
		super.endElement(uri, localName, qName);
	}
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String value = new String(ch,start, length);
		if (isRollNo) {
			currentCustomer.setRollNo(value);
		}else if (isFullName) {
			currentCustomer.setFullName(value);
		}else if (isID) {
			currentCustomer.setiD(value);
		}else if (isPhoneNumber) {
			currentCustomer.setPhoneNumber(value);
		}else if (isIDRoom) {
			currentCustomer.setiDRoom(value);
		}else if (isTypeRent) {
			currentCustomer.setTypeRent(value);
		}else if(isAmountPaid){
			currentCustomer.setPayment(value);
		}else if (isTimeIn) {
			tempInfoTime.setTimeIn(value);
		}else if (isDateIn) {
			tempInfoTime.setdateIn(value);
		}else if (isTimeOut) {
			tempInfoTime.setTimeOut(value);
		}else if (isDateOut) {
			tempInfoTime.setdateOut(value);
		}
		super.characters(ch, start, length);
	}
	public ArrayList<Customer> getCustomerList() {
		return customerList;
	}
	
}
