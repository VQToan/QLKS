package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import Core.*;

public class mainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel MainPane;
	private final JPanel panelTitle = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTable tableRoom;
	private JTable tableCust;
	ArrayList<Customer> listCustomers = new ArrayList<>();
    DataFile input= new DataFile();
    ArrayList<Room> listRooms =new ArrayList<>();
    OptionSearch search= new OptionSearch();
    OptionAction action= new OptionAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainFrame frame = new mainFrame();
					frame.setVisible(true);
				    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
					  frame.setSize(screenSize.width, screenSize.height);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public mainFrame() {
		listRooms= input.importRoom();
        listCustomers=input.importCustomer();
        Timer timer = new Timer();
        int begin = 0;
        int timeInterval = 60000;
		timer.schedule(new TimerTask() {
           @Override
           public void run() {
               //call the method
        	   listRooms=action.autoCheckTime(listRooms, listCustomers);
        	   input.exportRoom(listRooms);
           }
        }, begin, timeInterval);
		setSize(1373, 788);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MainPane = new JPanel();
		MainPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(MainPane);
		MainPane.setLayout(null);
		panelTitle.setBounds(10, 0, 1337, 47);
		MainPane.add(panelTitle);
		
		JLabel lblTitle = new JLabel();
		lblTitle.setText("QUẢN LÍ KHÁCH SẠN");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panelTitle.add(lblTitle);
		
		JTabbedPane tabPaneMain = new JTabbedPane(JTabbedPane.TOP);
		tabPaneMain.setBounds(10, 46, 1337, 692);
		MainPane.add(tabPaneMain);
		
		JPanel jPInforTeam = new JPanel();
		tabPaneMain.addTab("Th\u00F4ng tin nh\u00F3m", null, jPInforTeam, null);
		
		JLabel jLabel2 = new JLabel();
		jLabel2.setText("1. Phan Hải Đăng (Nhóm trưởng)");
		
		JLabel jLabel3 = new JLabel();
		jLabel3.setText("2. Nguyễn Mạnh Linh");
		
		JLabel jLabel4 = new JLabel();
		jLabel4.setText("3. Trần Minh Bảo");
		
		JLabel jLabel5 = new JLabel();
		jLabel5.setText("4,. Nguyễn Minh Hoàng");
		
		JLabel jLabel6 = new JLabel();
		jLabel6.setText("5. Võ Quốc Toàn");
		GroupLayout gl_jPInforTeam = new GroupLayout(jPInforTeam);
		gl_jPInforTeam.setHorizontalGroup(
			gl_jPInforTeam.createParallelGroup(Alignment.LEADING)
				.addGap(0, 1332, Short.MAX_VALUE)
				.addGroup(gl_jPInforTeam.createSequentialGroup()
					.addGap(17)
					.addGroup(gl_jPInforTeam.createParallelGroup(Alignment.LEADING)
						.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 301, GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 301, GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 301, GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 301, GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 301, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(1014, Short.MAX_VALUE))
		);
		gl_jPInforTeam.setVerticalGroup(
			gl_jPInforTeam.createParallelGroup(Alignment.LEADING)
				.addGap(0, 808, Short.MAX_VALUE)
				.addGroup(gl_jPInforTeam.createSequentialGroup()
					.addGap(18)
					.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(598, Short.MAX_VALUE))
		);
		jPInforTeam.setLayout(gl_jPInforTeam);
		
		JPanel jPInforRoom = new JPanel();
		tabPaneMain.addTab("Th\u00F4ng tin ph\u00F2ng", null, jPInforRoom, null);
		jPInforRoom.setLayout(null);
		
		JScrollPane jScrollPane1 = new JScrollPane();
		jScrollPane1.setBounds(21, 237, 1290, 396);
		jPInforRoom.add(jScrollPane1);
		
		tableRoom = new JTable();
		jScrollPane1.setViewportView(tableRoom);
		if (tableRoom.getColumnModel().getColumnCount() > 0) {
            tableRoom.getColumnModel().getColumn(0).setResizable(false);
            tableRoom.getColumnModel().getColumn(1).setResizable(false);
            tableRoom.getColumnModel().getColumn(2).setResizable(false);
            tableRoom.getColumnModel().getColumn(3).setResizable(false);
            tableRoom.getColumnModel().getColumn(4).setResizable(false);
    }
		
		JPanel panelSearchRoom = new JPanel();
		panelSearchRoom.setBounds(21, 11, 1300, 210);
		panelSearchRoom.setLayout(null);
		jPInforRoom.add(panelSearchRoom);
		
		JLabel lblIDsRoom = new JLabel("Mã phòng:");
		lblIDsRoom.setBounds(100, 24, 110, 30);
		panelSearchRoom.add(lblIDsRoom);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(220, 24, 180, 30);
		panelSearchRoom.add(textField);
		
		JLabel lblTypeRoom = new JLabel("Loại phòng:");
		lblTypeRoom.setBounds(100, 78, 110, 30);
		panelSearchRoom.add(lblTypeRoom);
		
		JComboBox cbbTypeRoom = new JComboBox();
		cbbTypeRoom.setBounds(220, 78, 180, 30);
		panelSearchRoom.add(cbbTypeRoom);
		
		JLabel lblStatus = new JLabel("Tình trạng:");
		lblStatus.setBounds(100, 132, 110, 30);
		panelSearchRoom.add(lblStatus);
		
		JComboBox cbbStatus = new JComboBox();
		cbbStatus.setBounds(220, 132, 180, 30);
		panelSearchRoom.add(cbbStatus);
		
		JLabel lblPrice = new JLabel("Giá thuê :");
		lblPrice.setBounds(500, 24, 110, 30);
		panelSearchRoom.add(lblPrice);
		
		textField_1 = new JTextField();
		textField_1.setBounds(620, 24, 180, 30);
		panelSearchRoom.add(textField_1);
		
		JLabel lblTypeRent1 = new JLabel("Giá thuê ( qua đêm):");
		lblTypeRent1.setBounds(500, 78, 110, 30);
		panelSearchRoom.add(lblTypeRent1);
		
		JComboBox cbbTypeRent1 = new JComboBox();
		cbbTypeRent1.setBounds(620, 78, 180, 30);
		panelSearchRoom.add(cbbTypeRent1);
		
		JLabel lblBeds = new JLabel("Số giường");
		lblBeds.setBounds(500, 132, 110, 30);
		panelSearchRoom.add(lblBeds);
		
		JComboBox cbbBeds = new JComboBox();
		cbbBeds.setBounds(620, 132, 180, 30);
		panelSearchRoom.add(cbbBeds);
		
		JButton btnSearchRoom = new JButton("Tìm kiếm");
		btnSearchRoom.setBounds(914, 28, 198, 70);
		panelSearchRoom.add(btnSearchRoom);
		
		JButton btnResetRoomSearchForm = new JButton("Nhập lại");
		btnResetRoomSearchForm.setBounds(914, 122, 89, 30);
		panelSearchRoom.add(btnResetRoomSearchForm);
		
		JButton btnShowAllRoom = new JButton("Xem tất cả");
		btnShowAllRoom.setBounds(1023, 122, 89, 30);
		panelSearchRoom.add(btnShowAllRoom);
		
		JPanel jPInforCustomer = new JPanel();
		jPInforCustomer.setLayout(null);
		tabPaneMain.addTab("Th\u00F4ng tin kh\u00E1ch h\u00E0ng", null, jPInforCustomer, null);
		
		JScrollPane SPCust = new JScrollPane();
		SPCust.setBounds(0, 222, 1326, 443);
		jPInforCustomer.add(SPCust);
		
		tableCust = new JTable();
		SPCust.setViewportView(tableCust);
		
		JPanel SearchRoom = new JPanel();
		SearchRoom.setLayout(null);
		SearchRoom.setBounds(0, 0, 1326, 209);
		jPInforCustomer.add(SearchRoom);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(123, 23, 296, 30);
		SearchRoom.add(textField_2);
		
		JLabel lblMaKH = new JLabel("Mã khách hàng:");
		lblMaKH.setBounds(36, 31, 97, 14);
		SearchRoom.add(lblMaKH);
		
		JLabel lblTimeIn = new JLabel("Thời gian thuê:");
		lblTimeIn.setBounds(620, 31, 97, 14);
		SearchRoom.add(lblTimeIn);
		
		textField_3 = new JTextField();
		textField_3.setText("dd-mm-yyyy");
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setColumns(10);
		textField_3.setBounds(810, 23, 211, 30);
		SearchRoom.add(textField_3);
		
		JLabel lblFullName = new JLabel("Họ và tên:");
		lblFullName.setBounds(36, 81, 97, 14);
		SearchRoom.add(lblFullName);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(123, 73, 296, 30);
		SearchRoom.add(textField_4);
		
		JLabel lblTimeOut = new JLabel("Thời gian trả:");
		lblTimeOut.setBounds(620, 81, 97, 14);
		SearchRoom.add(lblTimeOut);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(123, 122, 296, 30);
		SearchRoom.add(textField_5);
		
		JLabel lblIDPersonal = new JLabel("CMND/CCCD:");
		lblIDPersonal.setBounds(36, 130, 97, 14);
		SearchRoom.add(lblIDPersonal);
		
		JLabel lblIDRoom = new JLabel("Mã phòng:");
		lblIDRoom.setBounds(620, 130, 97, 14);
		SearchRoom.add(lblIDRoom);
		
		JLabel lblPhoneNumber = new JLabel("Số điện thoại:");
		lblPhoneNumber.setBounds(32, 180, 97, 14);
		SearchRoom.add(lblPhoneNumber);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(125, 172, 296, 30);
		SearchRoom.add(textField_6);
		
		JLabel lblMaKH_7 = new JLabel("Hình thức thuê:");
		lblMaKH_7.setBounds(620, 180, 97, 14);
		SearchRoom.add(lblMaKH_7);
		
		JComboBox cbbHinhThuc = new JComboBox();
		cbbHinhThuc.setBounds(727, 172, 294, 30);
		SearchRoom.add(cbbHinhThuc);
		
		textField_7 = new JTextField();
		textField_7.setText("dd-mm-yyyy");
		textField_7.setHorizontalAlignment(SwingConstants.CENTER);
		textField_7.setColumns(10);
		textField_7.setBounds(810, 74, 211, 30);
		SearchRoom.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(729, 122, 296, 30);
		SearchRoom.add(textField_8);
		
		JComboBox cbbTimIn = new JComboBox();
		cbbTimIn.setBounds(730, 23, 76, 30);
		SearchRoom.add(cbbTimIn);
		
		JComboBox<String> cbbTimeOut = new JComboBox<String>();
		cbbTimeOut.setBounds(730, 73, 76, 30);
		SearchRoom.add(cbbTimeOut);
		
		JButton btnSearchCustomer = new JButton("Tìm Kiếm");
		btnSearchCustomer.setBounds(1107, 31, 183, 68);
		SearchRoom.add(btnSearchCustomer);
		
		JButton btnResetCustSearchForm = new JButton("Nhập lại");
		btnResetCustSearchForm.setBounds(1107, 120, 90, 30);
		SearchRoom.add(btnResetCustSearchForm);
		
		JButton btnShowAllCust = new JButton("Xem tất cả");
		btnShowAllCust.setBounds(1200, 120, 90, 30);
		SearchRoom.add(btnShowAllCust);
		
		JPanel jPRegister = new JPanel();
		tabPaneMain.addTab("\u0110\u1EB7t ph\u00F2ng", null, jPRegister, null);
		
		JLabel jLabel7 = new JLabel();
		jLabel7.setText("Tên KH: ");
		
		JLabel jLabel8 = new JLabel();
		jLabel8.setText("CMND: ");
		
		JLabel jLabel9 = new JLabel();
		jLabel9.setText("SĐT: ");
		
		JLabel jLabel14 = new JLabel();
		jLabel14.setText("Mã KH: ");
		
		textField_9 = new JTextField();
		
		textField_10 = new JTextField();
		
		JLabel jLabel11 = new JLabel();
		jLabel11.setText("Chọn loại phòng: ");
		
		JLabel jLabel12 = new JLabel();
		jLabel12.setText("Số giường: ");
		
		JLabel jLabel13 = new JLabel();
		jLabel13.setText("Phòng: ");
		
		JLabel jLabel16 = new JLabel();
		jLabel16.setText("Hình thức thuê: ");
		
		JComboBox<String> jComboBox1 = new JComboBox<String>();
		
		JComboBox<String> jComboBox2 = new JComboBox<String>();
		
		JLabel jLabel15 = new JLabel();
		jLabel15.setText("Tới: ");
		
		JComboBox<String> jComboBox5 = new JComboBox<String>();
		
		JLabel jLabel10 = new JLabel();
		jLabel10.setText("Từ: ");
		
		JComboBox<String> jComboBox4 = new JComboBox<String>();
		
		JComboBox<String> jComboBox6 = new JComboBox<String>();
		
		JComboBox<String> jComboBox3 = new JComboBox<String>();
		
		textField_11 = new JTextField();
		
		textField_12 = new JTextField();
		
		JButton jButton3 = new JButton();
		jButton3.setText("Kiểm tra");
		
		JButton jButton1 = new JButton();
		jButton1.setText("Đặt");
		
		JButton jButton2 = new JButton();
		jButton2.setText("Hủy");
		GroupLayout gl_jPRegister = new GroupLayout(jPRegister);
		gl_jPRegister.setHorizontalGroup(
			gl_jPRegister.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 1332, Short.MAX_VALUE)
				.addGroup(gl_jPRegister.createSequentialGroup()
					.addGap(120)
					.addGroup(gl_jPRegister.createParallelGroup(Alignment.TRAILING)
						.addComponent(jLabel7)
						.addComponent(jLabel8)
						.addComponent(jLabel9)
						.addComponent(jLabel14))
					.addGap(18)
					.addGroup(gl_jPRegister.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_jPRegister.createSequentialGroup()
							.addGroup(gl_jPRegister.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_10, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
							.addGroup(gl_jPRegister.createParallelGroup(Alignment.LEADING)
								.addComponent(jLabel11)
								.addComponent(jLabel12, Alignment.TRAILING)
								.addComponent(jLabel13, Alignment.TRAILING)
								.addComponent(jLabel16, Alignment.TRAILING))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_jPRegister.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_jPRegister.createSequentialGroup()
									.addGroup(gl_jPRegister.createParallelGroup(Alignment.LEADING)
										.addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
										.addComponent(jComboBox2, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE))
									.addGap(115)
									.addGroup(gl_jPRegister.createParallelGroup(Alignment.LEADING, false)
										.addGroup(gl_jPRegister.createSequentialGroup()
											.addComponent(jLabel15)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(jComboBox5, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addGroup(gl_jPRegister.createSequentialGroup()
											.addComponent(jLabel10)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(jComboBox4, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE))))
								.addGroup(gl_jPRegister.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(jComboBox6, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(jComboBox3, Alignment.LEADING, 0, 173, Short.MAX_VALUE)))
							.addGap(0, 240, Short.MAX_VALUE))
						.addGroup(gl_jPRegister.createSequentialGroup()
							.addGroup(gl_jPRegister.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_11, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_12, GroupLayout.PREFERRED_SIZE, 258, GroupLayout.PREFERRED_SIZE))
							.addGap(0, 894, Short.MAX_VALUE))))
				.addGroup(gl_jPRegister.createSequentialGroup()
					.addContainerGap(668, Short.MAX_VALUE)
					.addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
					.addGap(107)
					.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
					.addGap(92)
					.addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
					.addGap(105))
		);
		gl_jPRegister.setVerticalGroup(
			gl_jPRegister.createParallelGroup(Alignment.LEADING)
				.addGap(0, 808, Short.MAX_VALUE)
				.addGroup(gl_jPRegister.createSequentialGroup()
					.addGap(36)
					.addGroup(gl_jPRegister.createParallelGroup(Alignment.BASELINE)
						.addComponent(jLabel7)
						.addComponent(jLabel11)
						.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
						.addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel10)
						.addComponent(jComboBox4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_jPRegister.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_jPRegister.createSequentialGroup()
							.addGap(67)
							.addGroup(gl_jPRegister.createParallelGroup(Alignment.BASELINE)
								.addComponent(jLabel12)
								.addComponent(jComboBox2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel15)
								.addComponent(jComboBox5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(65)
							.addGroup(gl_jPRegister.createParallelGroup(Alignment.BASELINE)
								.addComponent(jComboBox3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel13)))
						.addGroup(gl_jPRegister.createSequentialGroup()
							.addGap(77)
							.addGroup(gl_jPRegister.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_10, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel8))))
					.addGap(17)
					.addGroup(gl_jPRegister.createParallelGroup(Alignment.BASELINE)
						.addComponent(jLabel9)
						.addComponent(textField_11, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_jPRegister.createParallelGroup(Alignment.BASELINE)
						.addComponent(jComboBox6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel16))
					.addGap(49)
					.addGroup(gl_jPRegister.createParallelGroup(Alignment.BASELINE)
						.addComponent(jLabel14)
						.addComponent(textField_12, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 190, Short.MAX_VALUE)
					.addGroup(gl_jPRegister.createParallelGroup(Alignment.BASELINE)
						.addComponent(jButton3)
						.addComponent(jButton1)
						.addComponent(jButton2))
					.addGap(160))
		);
		jPRegister.setLayout(gl_jPRegister);
	}
	 public void resetTableCus() {
     	String[] colTableCus= { "STT", "Mã Kh", "Họ và tên", "CMND", "Số điện thoại", "Thời gian nhận", "Thời gian trả",
                 "Mã phòng", "Hình thức thuê", "Thành tiền" };
     	DefaultTableModel tableModel = new DefaultTableModel(colTableCus, 0);
     	tableCust.setModel(tableModel);
		}
     public void ShowOnTableRoom(ArrayList<Core.Room> listRooms) {
			String[] colTableRoom= {"STT", "Mã phòng","Trạng thái","Số giường","Loại phòng","Giá thuê (theo giờ )","Giá thuê (qua đêm)"};
			DefaultTableModel tableModel = new DefaultTableModel(colTableRoom,0);
			for (int i=0; i< listRooms.size();i++) {
				Object[] data = {i+1,
									listRooms.get(i).getiDsRoom(),
									listRooms.get(i).getStatus(),
									listRooms.get(i).getBeds(),
									listRooms.get(i).getTypeRoom(),
									listRooms.get(i).getPrice1Hour(),
									listRooms.get(i).getPriceOverNight()};
				tableModel.addRow(data);
				}
			tableRoom.setModel(tableModel);
			}
     public void ResetTableRoom() {
			String[] colTableRoom= {"STT", "Mã phòng","Trạng thái","Số giường","Loại phòng","Giá thuê (theo giờ )","Giá thuê (qua đêm)"};
			DefaultTableModel tableModel = new DefaultTableModel(colTableRoom,0);
			tableRoom.setModel(tableModel);
			}
     public void ShowOnTableCus(ArrayList<Core.Customer> listCustomers, ArrayList<Core.Room> listRooms) {
     	String[] colTableCus= { "STT", "Mã Kh", "Họ và tên", "CMND", "Số điện thoại", "Thời gian nhận", "Thời gian trả",
                 "Mã phòng", "Hình thức thuê", "Thành tiền" };
         DefaultTableModel tableModel = new DefaultTableModel(colTableCus, 0);
         for (int i=0; i< listCustomers.size();i++) {
         	Object[] data= {i+1,
         					  listCustomers.get(i).getRollNo(),
         					  listCustomers.get(i).getFullName(),
         					  listCustomers.get(i).getiD(),
         					  listCustomers.get(i).getPhoneNumber(),
         					  listCustomers.get(i).getInOut().getdateIn(),
         					  listCustomers.get(i).getInOut().getdateOut(),
         					  listCustomers.get(i).getTypeRent(),
         					  listCustomers.get(i).getiDRoom(),
         					  listCustomers.get(i).payment(listRooms)};
         	tableModel.addRow(data);
         	}
         tableCust.setModel(tableModel);
		}
     public String[] setOptionBeds(ArrayList<Core.Room> dataRooms) {
			String[] option = new String[] {""};
			for (Core.Room room : dataRooms) {
				if (checkList(option, room.getBeds())) {
					option=addElement(option, room.getBeds());
				}
			}
			return option;
		}
     public String[] setOptionTypeRoom(ArrayList<Core.Room> dataRooms) {
			String[] optionType = new String[] {""};
			for (Core.Room room : dataRooms) {
				if (checkList(optionType, room.getTypeRoom())) {
					optionType=addElement(optionType, room.getTypeRoom());
				}
			}
			return optionType;
		}
     static String[] addElement(String[] a, String e) {
         a  = Arrays.copyOf(a, a.length + 1);
         a[a.length - 1] = e;
         return a;
     }
     public boolean checkList(String[] List, String key) {
			for (String string : List) {
				if (key.equals(string)) {
					return false;
				}
			}
			return true;
		}
}
