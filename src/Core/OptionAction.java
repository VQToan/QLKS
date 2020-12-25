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
		e1.printStackTrace();
	}
//    System.out.println(endDate);
    for (Customer customer : dataCustomers) {
    	String startDate= customer.getInOut().getdateOut()+" "+ customer.getInOut().getTimeOut();
    	try {
			date1 = simpleDateFormat.parse(startDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (((date1.getTime()-date2.getTime())/(1000*60))<=0) {
			for (int i= 0;i< dataRooms.size(); i++) {
				if(customer.getiDRoom().equals(dataRooms.get(i).getiDsRoom())) {
					Room tempRoom= dataRooms.get(i);
					tempRoom.setStatus("Trống");
					dataRooms.set(i,tempRoom);
					tempRoom=null;
					}
			}
	}else {
		for (int i= 0;i< dataRooms.size(); i++) {
			if(customer.getiDRoom().equals(dataRooms.get(i).getiDsRoom())) {
				Room tempRoom= dataRooms.get(i);
				tempRoom.setStatus("Đã đặt");
				dataRooms.set(i,tempRoom);
				tempRoom=null;
				}
		}
	}
	}
	return dataRooms;
	}
	public ArrayList<Room> setStautus(ArrayList<Room> dataRooms, String key) {
		for (int i = 0; i < dataRooms.size(); i++) {
			if(key.equals(dataRooms.get(i).getiDsRoom())) {
				Room tempRoom= dataRooms.get(i);
				tempRoom.setStatus("Đã đặt");
				dataRooms.set(i,tempRoom);
				tempRoom=null;
				}
		}
		return dataRooms;
	}
	public InfoTime TotalTime(String endTime) {
		InfoTime infoTime = new InfoTime();
		SimpleDateFormat simplpDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("HH:mm");
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		if (Integer.parseInt(endTime)%24==0) {
			String dateFormat = simplpDateFormat.format(date);
			String dateFormat1 = simpleDateFormat1.format(date);
			infoTime.setdateIn(dateFormat);
			infoTime.setTimeIn(dateFormat1);
			calendar.add(Calendar.DAY_OF_MONTH, (Integer.parseInt(endTime))/24);
			date = calendar.getTime();
			String dateFormat2 = simplpDateFormat.format(date);
			dateFormat1 = simpleDateFormat1.format(date);
			infoTime.setdateOut(dateFormat2);
			infoTime.setTimeOut(dateFormat1);
		}
		else {
			String dateFormat = simplpDateFormat.format(date);
			String dateFormat1 = simpleDateFormat1.format(date);
			infoTime.setdateIn(dateFormat);
			infoTime.setTimeIn(dateFormat1);
			calendar.add(Calendar.HOUR_OF_DAY, Integer.parseInt(endTime));
			date = calendar.getTime();
			String dateFormat2 = simpleDateFormat1.format(date);
			dateFormat = simplpDateFormat.format(date);
			infoTime.setdateOut(dateFormat);
			infoTime.setTimeOut(dateFormat2);
		}
		return infoTime;
	}
	public String getHourString(String time) {
		String[] splitTimeStrings  = time.split(":");
//		System.out.println(splitTimeStrings[0]+":00");
		return splitTimeStrings[0]+":00";
	}
}

