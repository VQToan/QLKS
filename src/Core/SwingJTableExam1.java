package Core;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
 
public class SwingJTableExam1 {
    JFrame f;
 
    SwingJTableExam1() {
        f = new JFrame();
        ArrayList<Customer> listcusCustomers = new ArrayList<>();
    	ArrayList<Room> listRooms = new ArrayList<>();
        ArrayList<Core.Customer> listCustomers = new ArrayList<>();
        DataFile input= new DataFile();
        listCustomers=input.importCustomer();
        listRooms= input.importRoom();
        classtest a= new classtest();
        String data[][]= a.name();
        String column[] = { "ID", "NAME", "SALARY" };
 
        JTable jt = new JTable(data, column);
        jt.setBounds(30, 40, 200, 300);
 
        JScrollPane sp = new JScrollPane(jt);
        f.add(sp);
 
        f.setSize(500, 300);
        f.setVisible(true);
    }
 
    public static void main(String[] args) {
    	
        new SwingJTableExam1();
    }
}