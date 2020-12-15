package Core;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class MainRun {
	public static void main(String[] args) throws IOException, ParseException{
//		ArrayList<Customer> a = new ArrayList<>();
//		ArrayList<Room> b,c = new ArrayList<Room>();
		//DateFormat simpleDateFormat = new SimpleDateFormat("dd-mm-yyyy HH:mm");
//		b.add(new Room("002", true, 2, "2", 524000));
//		b.add(new Room("003", false, 1, "3", 84864132));
//		b.add(new Room("004", true, 2, "1", 525424000));
		//a.add(new Customer("01", "Võ Quốc Toàn", "26145716489", "0983243953", "1Hour", "001", new InfoTime("10:25", "22-06-2020","9:00" ,"23-06-2020" )));
//		b.add(new Room("001", true, 2, "normal", 7524000, 544563));
//		DataFile outFile= new DataFile();
		//outFile.exportCustomer(a);
//		a=outFile.importCustomer();
//		b=outFile.importRoom();
//		OptionSearch search =new OptionSearch();
//		System.out.println(a.get(0).getInOut().getdateIn()+" "+a.get(0).getInOut().getTimeIn());
//		c= search.SearchRoom(b, "001", "None", "None",  "None",  "None",  "None");
//		System.out.println(b.get(0).getiDsRoom());
//		if(b.get(0).getiDsRoom().equals("001")){
//			System.out.println("1");
//		} else {
//			System.out.println("2");
//		}
//		Customer k = a.get(0);
//		System.out.println(k.toString());
		//System.out.println(c.get(0).getPriceOverNight());
		//System.out.println(search.SearchRoom(b, a.get(0).getiDRoom(), "None", "None",  "None",  "None",  "None").get(0).getPriceOverNight());
		//System.out.println(k.calTime());
//		System.out.println();
//		System.out.println(search.SearchRoom(b, "1", "None", "None",  "None",  "None",  "None").get(0).toString());
		DateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		Date currentDate = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.HOUR, 24);
        String endDate = simpleDateFormat.format(currentDate);
        System.out.println(endDate);
        String startDate = "20-10-2020 17:05";
        System.out.println(startDate);
        Date date1,date2;
        date1 = simpleDateFormat.parse(startDate);
        date2 = simpleDateFormat.parse(endDate);
        long getdiff= (date2.getTime()-date1.getTime())/(1000*60);
        System.out.println(String.valueOf(getdiff));
	}
	public static boolean check(Room data, String method, String key) {
		boolean flag= false;
		if (key=="None") flag= true;
		else {
			if (method== "iDsRoom" && data.getiDsRoom()==key ) flag= true;
			if (method== "status" && String.valueOf(data.getStatus())==key) flag= true;
			if (method== "beds" && String.valueOf(data.getBeds())==key) flag= true;
			if(method== "typeRoom" && data.getTypeRoom()==key) flag= true;
			if (method=="price1Hour" && String.valueOf(data.getPrice1Hour())==key) flag= true;
			if (method=="priceOverNight" && String.valueOf(data.getPriceOverNight())==key) flag= true; 
			}
		return flag;
	}
}

