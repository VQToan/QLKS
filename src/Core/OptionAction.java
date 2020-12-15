package Core;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class OptionAction {
	public void Oder(String typeRoom) {
	}
	public ArrayList<Room> autoCheckTime(ArrayList<Room> dataRooms, ArrayList<Customer> dataCustomers) {
	DateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
	Date currentDate = new Date();
    Calendar cal = Calendar.getInstance();
    cal.setTime(new Date());
    cal.add(Calendar.HOUR, 24);
    Date date1 = null,date2 = null;
    String endDate = simpleDateFormat.format(currentDate);
    try {
		date2 = simpleDateFormat.parse(endDate);
	} catch (ParseException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
//    System.out.println(endDate);
    for (Customer customer : dataCustomers) {
    	String startDate= customer.getInOut().getdateOut()+" "+ customer.getInOut().getTimeOut();
    	try {
			date1 = simpleDateFormat.parse(startDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if ((date2.getTime()-date1.getTime())/(1000*60)<=0) {
			for (int i= 0;i< dataRooms.size(); i++) {
				if(customer.getiDRoom().equals(dataRooms.get(i).getiDsRoom())) {
					Room tempRoom= dataRooms.get(i);
					tempRoom.setStatus("Trống");
					dataRooms.set(i,tempRoom);
					tempRoom=null;
					}
			}
	}
		return dataRooms;
	}
	return dataRooms;
	

	}
}
