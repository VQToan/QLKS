package Core;

import java.util.HashMap;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;



public class LoginUserHandler extends DefaultHandler{
	HashMap<String, String> listUserHashMap = new HashMap<>();
	LoginUser currentUser= null;
	boolean isUserName= false,
			isPassWord= false;
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if (qName.equalsIgnoreCase("User")) {
			currentUser=new LoginUser();
		}else if (qName.equalsIgnoreCase("userName")) {
			isUserName=true;
		}else if (qName.equalsIgnoreCase("passWord")) {
			isPassWord=true;
		}
		super.startElement(uri, localName, qName, attributes);
	}
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equalsIgnoreCase("User")) {
			listUserHashMap.put(currentUser.getUserName(), currentUser.getPassWord());
			currentUser=null;
		}else if (qName.equalsIgnoreCase("userName")) {
			isUserName=false;
		}else if (qName.equalsIgnoreCase("passWord")) {
			isPassWord=false;
		}
		super.endElement(uri, localName, qName);
	}
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String value = new String(ch,start,length);
		if (isUserName) {
			currentUser.setUserName(value);
		}if (isPassWord) {
			currentUser.setPassWord(value);
		}
		super.characters(ch, start, length);
	}
	public HashMap<String, String> getUserList() {
		return listUserHashMap;
	}
}
