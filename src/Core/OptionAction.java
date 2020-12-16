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
		if (((date1.getTime()-date2.getTime())/(1000*60))<=0) {
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
	public InfoTime getInforTimeReg(String startTime,  String endTime) {
		InfoTime dateTimeInfor=new InfoTime();
		DateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		Date currentDate = new Date();
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(new Date());
	    cal.add(Calendar.HOUR, 24);
	    Date date1 = null,date2=null;
	    String[] current = simpleDateFormat.format(currentDate).split(" ");
	    String[] tomorrow= simpleDateFormat.format(cal.getTime()).split(" ");
	    cal.add(Calendar.DAY_OF_MONTH, 1);
	    String[] nextTomorrow= simpleDateFormat.format(cal.getTime()).split(" ");
	    if (startTime.equals("") && endTime.equals("")) {
			dateTimeInfor.setdateIn(current[0]);
			dateTimeInfor.setTimeIn(current[1]);
			dateTimeInfor.setdateOut(tomorrow[0]);
			dateTimeInfor.setTimeOut(current[1]);
			}
		else {
				try {
					date1=simpleDateFormat.parse(current[0]+" "+ startTime);
					date2=simpleDateFormat.parse(current[0]+" "+ endTime);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if ((date1.getTime()-currentDate.getTime())<0) {
					if ((date2.getTime()-date1.getTime())<0) {
						dateTimeInfor.setdateIn(tomorrow[0]);
						dateTimeInfor.setTimeIn(startTime);
						dateTimeInfor.setdateOut(nextTomorrow[0]);
						dateTimeInfor.setTimeOut(endTime);
					}else {
					dateTimeInfor.setdateIn(tomorrow[0]);
					dateTimeInfor.setdateOut(tomorrow[0]);
					dateTimeInfor.setTimeIn(startTime);
					dateTimeInfor.setTimeOut(endTime);
					}
				}else if ((date2.getTime()-currentDate.getTime())<0) {
					dateTimeInfor.setdateIn(current[0]);
					dateTimeInfor.setTimeIn(startTime);
					dateTimeInfor.setdateOut(tomorrow[0]);
					dateTimeInfor.setTimeOut(endTime);
				}
				else{
					dateTimeInfor.setdateIn(current[0]);
					dateTimeInfor.setdateOut(current[0]);
					dateTimeInfor.setTimeIn(startTime);
					dateTimeInfor.setdateOut(endTime);
			}
		}
		return dateTimeInfor;
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
}
