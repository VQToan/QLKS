package GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;



import Core.Customer;
import Core.DataFile;
import Core.OptionAction;
import Core.OptionSearch;
import Core.Room;


import java.awt.FlowLayout;

public class mainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel MainPane;
	private final JPanel panelTitle = new JPanel();
	private JTextField txtIDsRoom;
	private JTextField txtPrice;
	private JTextField txtID;
	private JTextField txtDayIn;
	private JTextField txtFullName;
	private JTextField txtIDPersonal;
	private JTextField txtPhone;
	private JTextField txtDayOut;
	private JTextField txtIDRoom;
	private JTextField txtFullName2;
	private JTextField txtIDPersonal2;
	private JTextField txtPhone2;
	private JTable tableRoom;
	private JTable tableCust;
	ArrayList<Customer> listCustomers = new ArrayList<>();
    DataFile input= new DataFile();
    ArrayList<Room> listRooms =new ArrayList<>();
    OptionSearch search= new OptionSearch();
    OptionAction action= new OptionAction();
	ArrayList<Room> roomSuggest = new ArrayList<>();
	HashMap<String, Customer> hashMapCustHashMap = new HashMap<>();
	HashMap<String, Room> hashMapRoomHashMap = new HashMap<>();
	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */

	public mainFrame() {
		listRooms= input.importRoom();
        listCustomers=input.importCustomer();
        listRooms=action.autoCheckTime(listRooms, listCustomers);
 	   	input.exportRoom(listRooms);
 	   	//ShowOnTableRoom(listRooms);
		for (Customer customer : listCustomers) {
			hashMapCustHashMap.put(customer.getiD(), customer);
		}
		for (Room room : listRooms) {
			hashMapRoomHashMap.put(room.getiDsRoom(), room);
		}
        Timer timer = new Timer();
        int begin = 0;
        int timeInterval = 60000;
		timer.schedule(new TimerTask() {
           @Override
           public void run() {
               //call the method
        	   listRooms=action.autoCheckTime(listRooms, listCustomers);
        	   input.exportRoom(listRooms);
        	   //ShowOnTableRoom(listRooms);
           }
        }, begin, timeInterval);
		setSize(1373, 788);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MainPane = new JPanel();
		MainPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(MainPane);
		MainPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		MainPane.add(panelTitle);
		
		JLabel lblTitle = new JLabel();
		lblTitle.setText("QUẢN LÍ KHÁCH SẠN");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panelTitle.add(lblTitle);
		
		JTabbedPane tabPaneMain = new JTabbedPane(JTabbedPane.TOP);
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
		ShowOnTableRoom(listRooms);
		JPanel panelSearchRoom = new JPanel();
		panelSearchRoom.setBounds(21, 11, 1300, 210);
		panelSearchRoom.setLayout(null);
		jPInforRoom.add(panelSearchRoom);
		
		JLabel lblIDsRoom = new JLabel("Mã phòng:");
		lblIDsRoom.setBounds(100, 24, 110, 30);
		panelSearchRoom.add(lblIDsRoom);
		
		txtIDsRoom = new JTextField();
		txtIDsRoom.setColumns(10);
		txtIDsRoom.setBounds(220, 24, 180, 30);
		panelSearchRoom.add(txtIDsRoom);
		
		JLabel lblTypeRoom = new JLabel("Loại phòng:");
		lblTypeRoom.setBounds(100, 78, 110, 30);
		panelSearchRoom.add(lblTypeRoom);
		
		JComboBox<String> cbbTypeRoom = new JComboBox<String>();
		cbbTypeRoom.setBounds(220, 78, 180, 30);
		panelSearchRoom.add(cbbTypeRoom);
		cbbTypeRoom.setModel(new DefaultComboBoxModel<String>(setOptionTypeRoom(listRooms)));
		
		JLabel lblStatus = new JLabel("Tình trạng:");
		lblStatus.setBounds(100, 132, 110, 30);
		panelSearchRoom.add(lblStatus);
		
		JComboBox<String> cbbStatus = new JComboBox<String>();
		cbbStatus.setBounds(220, 132, 180, 30);
		panelSearchRoom.add(cbbStatus);
        cbbStatus.setModel(new DefaultComboBoxModel<String>(new String[] {"", "Đầy", "Trống"}));

		
		JLabel lblPrice = new JLabel("Giá thuê :");
		lblPrice.setBounds(500, 24, 110, 30);
		panelSearchRoom.add(lblPrice);
		
		txtPrice = new JTextField();
		txtPrice.setBounds(620, 24, 180, 30);
		panelSearchRoom.add(txtPrice);
		
		JLabel lblTypeRent1 = new JLabel("Giá thuê ( qua đêm):");
		lblTypeRent1.setBounds(500, 78, 110, 30);
		panelSearchRoom.add(lblTypeRent1);
		
		JComboBox<String> cbbTypeRent1 = new JComboBox<String>();
		cbbTypeRent1.setBounds(620, 78, 180, 30);
        cbbTypeRent1.setModel(new DefaultComboBoxModel<String>(new String[] {"", "Tăng dần theo giá thuê giờ", "Tăng dần theo giá thuê qua đêm", "Giảm dần theo giá thuê giờ", "Giảm dần theo giá thuê qua đêm"}));
		panelSearchRoom.add(cbbTypeRent1);
		
		JLabel lblBeds = new JLabel("Số giường");
		lblBeds.setBounds(500, 132, 110, 30);
		panelSearchRoom.add(lblBeds);
		
		JComboBox<String> cbbBeds = new JComboBox<String>();
		cbbBeds.setBounds(620, 132, 180, 30);
		panelSearchRoom.add(cbbBeds);
        cbbBeds.setModel(new DefaultComboBoxModel<String>(setOptionBeds(listRooms)));
		
		JButton btnSearchRoom = new JButton("Tìm kiếm");
		btnSearchRoom.setBounds(914, 28, 209, 70);
		panelSearchRoom.add(btnSearchRoom);
		JPanel panel3 = (JPanel) getContentPane();
		btnSearchRoom.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<Room> listEndSearchRooms = new ArrayList<>();
				listEndSearchRooms= search.SearchRoom(listRooms, txtIDsRoom.getText(),cbbStatus.getItemAt(cbbStatus.getSelectedIndex()), cbbBeds.getItemAt(cbbBeds.getSelectedIndex()), cbbTypeRoom.getItemAt(cbbTypeRoom.getSelectedIndex()).toString(),txtPrice.getText());
				//listEndSearchRooms= search.SearchRoom(listRooms, "", "", cbbBeds.getItemAt(cbbBeds.getSelectedIndex()), "", "");
				ResetTableRoom();
				System.out.println(listEndSearchRooms.get(0).toString());
				System.out.println(cbbBeds.getItemAt(cbbBeds.getSelectedIndex()));
				System.out.println(cbbStatus.getItemAt(cbbStatus.getSelectedIndex()));
				System.out.println(cbbTypeRent1.getItemAt(cbbTypeRent1.getSelectedIndex()));
				System.out.println(cbbTypeRoom.getItemAt(cbbTypeRoom.getSelectedIndex()));
				if (cbbTypeRent1.getSelectedIndex()==1) {
				        Collections.sort(listEndSearchRooms, new Comparator<Room>() {
				        	@Override
				            public int compare(Room r1, Room r2) {
				                if (r1.getPrice1Hour() > r2.getPrice1Hour()) {
				                    return 1;
				                } else {
				                    if (r1.getPrice1Hour() == r2.getPrice1Hour()) {
				                        return 0;
				                    } else {
				                        return -1;
				                    }
				                }
				            }
				        });
					}
				if (cbbTypeRent1.getSelectedIndex()==2) {
					Collections.sort(listEndSearchRooms, new Comparator<Room>() {
						@Override
			            public int compare(Room r1, Room r2) {
			                if (r1.getPriceOverNight() > r2.getPriceOverNight()) {
			                    return 1;
			                } else {
			                    if (r1.getPriceOverNight() == r2.getPriceOverNight()) {
			                        return 0;
			                    } else {
			                        return -1;
			                    }
			                }
			            }
					});
					
				}
				if (cbbTypeRent1.getSelectedIndex()==3) {
			        Collections.sort(listEndSearchRooms, new Comparator<Room>() {
			        	@Override
			            public int compare(Room r1, Room r2) {
			                if (r1.getPrice1Hour() < r2.getPrice1Hour()) {
			                    return 1;
			                } else {
			                    if (r1.getPrice1Hour() == r2.getPrice1Hour()) {
			                        return 0;
			                    } else {
			                        return -1;
			                    }
			                }
			            }
			        });
				}
				if (cbbTypeRent1.getSelectedIndex()==4) {
					Collections.sort(listEndSearchRooms, new Comparator<Room>() {
						@Override
			            public int compare(Room r1, Room r2) {
			                if (r1.getPriceOverNight() < r2.getPriceOverNight()) {
			                    return 1;
			                } else {
			                    if (r1.getPriceOverNight() == r2.getPriceOverNight()) {
			                        return 0;
			                    } else {
			                        return -1;
			                    }
			                }
			            }
					});
					
				}
				if (listEndSearchRooms.get(0).getiDsRoom().equals("NoneItem")) {
					JOptionPane.showMessageDialog(panel3,"Không tìm thấy!" , ":(", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
				ShowOnTableRoom(listEndSearchRooms);}
				listEndSearchRooms=null;
				}
		});
		
		
		JButton btnResetRoomSearchForm = new JButton("Nhập lại");
		btnResetRoomSearchForm.setBounds(914, 122, 100, 30);
		panelSearchRoom.add(btnResetRoomSearchForm);
        btnResetRoomSearchForm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				txtIDsRoom.setText("");
				txtPrice.setText("");
				cbbStatus.setSelectedIndex(0);
				cbbBeds.setSelectedIndex(0);
				cbbTypeRent1.setSelectedIndex(0);
				cbbTypeRoom.setSelectedIndex(0);
			}
		});
		
		JButton btnShowAllRoom = new JButton("Xem tất cả");
		btnShowAllRoom.setBounds(1023, 122, 100, 30);
		panelSearchRoom.add(btnShowAllRoom);
		 btnShowAllRoom.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					ResetTableRoom();
					ShowOnTableRoom(listRooms);
				}
			});
//============================tab CUSTOMER==================================//		
		JPanel jPInforCustomer = new JPanel();
		jPInforCustomer.setLayout(null);
		tabPaneMain.addTab("Th\u00F4ng tin kh\u00E1ch h\u00E0ng", null, jPInforCustomer, null);
		
		JScrollPane SPCust = new JScrollPane();
		SPCust.setBounds(0, 222, 1326, 443);
		jPInforCustomer.add(SPCust);
		
		tableCust = new JTable();
		SPCust.setViewportView(tableCust);
		ShowOnTableCus(listCustomers, listRooms);
		
		JPanel SearchRoom = new JPanel();
		SearchRoom.setLayout(null);
		SearchRoom.setBounds(0, 0, 1326, 209);
		jPInforCustomer.add(SearchRoom);
		
		txtID = new JTextField();
		txtID.setColumns(10);
		txtID.setBounds(123, 23, 296, 30);
		SearchRoom.add(txtID);
		
		JLabel lblMaKH = new JLabel("Mã khách hàng:");
		lblMaKH.setBounds(36, 31, 97, 14);
		SearchRoom.add(lblMaKH);
		
		JLabel lblTimeIn = new JLabel("Thời gian thuê:");
		lblTimeIn.setBounds(620, 31, 97, 14);
		SearchRoom.add(lblTimeIn);
		
		txtDayIn = new JTextField();
		txtDayIn.setText("dd-mm-yyyy");
		txtDayIn.setHorizontalAlignment(SwingConstants.CENTER);
		txtDayIn.setColumns(10);
		txtDayIn.setBounds(810, 23, 211, 30);
		SearchRoom.add(txtDayIn);
		
		JLabel lblFullName = new JLabel("Họ và tên:");
		lblFullName.setBounds(36, 81, 97, 14);
		SearchRoom.add(lblFullName);
		
		txtFullName = new JTextField();
		txtFullName.setColumns(10);
		txtFullName.setBounds(123, 73, 296, 30);
		SearchRoom.add(txtFullName);
		
		JLabel lblTimeOut = new JLabel("Thời gian trả:");
		lblTimeOut.setBounds(620, 81, 97, 14);
		SearchRoom.add(lblTimeOut);
		
		txtIDPersonal = new JTextField();
		txtIDPersonal.setColumns(10);
		txtIDPersonal.setBounds(123, 122, 296, 30);
		SearchRoom.add(txtIDPersonal);
		
		JLabel lblIDPersonal = new JLabel("CMND/CCCD:");
		lblIDPersonal.setBounds(36, 130, 97, 14);
		SearchRoom.add(lblIDPersonal);
		
		JLabel lblIDRoom = new JLabel("Mã phòng:");
		lblIDRoom.setBounds(620, 130, 97, 14);
		SearchRoom.add(lblIDRoom);
		
		JLabel lblPhoneNumber = new JLabel("Số điện thoại:");
		lblPhoneNumber.setBounds(32, 180, 97, 14);
		SearchRoom.add(lblPhoneNumber);
		
		txtPhone = new JTextField();
		txtPhone.setColumns(10);
		txtPhone.setBounds(125, 172, 296, 30);
		SearchRoom.add(txtPhone);
		
		JLabel lblTypeRent = new JLabel("Hình thức thuê:");
		lblTypeRent.setBounds(620, 180, 97, 14);
		SearchRoom.add(lblTypeRent);
		
		JComboBox<String> cbbTypeRent = new JComboBox<String>();
		cbbTypeRent.setBounds(727, 172, 294, 30);
		SearchRoom.add(cbbTypeRent);
		cbbTypeRent.setModel(new DefaultComboBoxModel<String>(new String[] {"", "Theo giờ", "Qua đêm"}));
		
		txtDayOut = new JTextField();
		txtDayOut.setText("dd-mm-yyyy");
		txtDayOut.setHorizontalAlignment(SwingConstants.CENTER);
		txtDayOut.setColumns(10);
		txtDayOut.setBounds(810, 74, 211, 30);
		SearchRoom.add(txtDayOut);
		
		txtIDRoom = new JTextField();
		txtIDRoom.setColumns(10);
		txtIDRoom.setBounds(729, 122, 296, 30);
		SearchRoom.add(txtIDRoom);
		
		JComboBox<String> cbbTimeIn = new JComboBox<String>();
		cbbTimeIn.setBounds(730, 23, 76, 30);
		SearchRoom.add(cbbTimeIn);
        cbbTimeIn.setModel(new DefaultComboBoxModel<String>(new String[] {"", "0:00 AM", "1:00 AM", "2:00 AM", "3:00 AM", "4:00 AM", "5:00 AM", "6:00 AM", "7:00 AM", "8:00 AM", "9:00 AM", "10:00 AM", "11:00 AM", "12:00 AM", "1:00 PM", "2:00 PM", "3:00 PM", "4:00 PM", "5:00 PM", "6:00 PM", "7:00 PM", "8:00 PM", "9:00 PM", "10:00 PM", "11:00 PM"}));

		
		JComboBox<String> cbbTimeOut = new JComboBox<String>();
		cbbTimeOut.setBounds(730, 73, 76, 30);
		SearchRoom.add(cbbTimeOut);
        cbbTimeOut.setModel(new DefaultComboBoxModel<String>(new String[] {"", "0:00 AM", "1:00 AM", "2:00 AM", "3:00 AM", "4:00 AM", "5:00 AM", "6:00 AM", "7:00 AM", "8:00 AM", "9:00 AM", "10:00 AM", "11:00 AM", "12:00 AM", "1:00 PM", "2:00 PM", "3:00 PM", "4:00 PM", "5:00 PM", "6:00 PM", "7:00 PM", "8:00 PM", "9:00 PM", "10:00 PM", "11:00 PM"}));

		
		JButton btnSearchCustomer = new JButton("Tìm Kiếm");
		btnSearchCustomer.setBounds(1107, 31, 209, 68);
		SearchRoom.add(btnSearchCustomer);
		JPanel panel2 = (JPanel) getContentPane();
		btnSearchCustomer.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					ArrayList<Core.Customer> listInforSearchArrayList = new ArrayList<>();
					listInforSearchArrayList=search.searchCustomers(listCustomers, txtID.getText(),
																					txtPhone.getText(),
																					cbbTypeRent.getItemAt(cbbTypeRent.getSelectedIndex()).toString(),
																					txtFullName.getText(),
																					txtIDPersonal.getText(),
																					txtIDRoom.getText(),
																					txtDayIn.getText(), 
																					txtDayOut.getText(), 
																					convertTime(cbbTimeIn.getItemAt(cbbTimeIn.getSelectedIndex())), 
																					convertTime(cbbTimeOut.getItemAt(cbbTimeOut.getSelectedIndex())));
					resetTableCus();
					//System.out.println(txtID.getText());
					if (listInforSearchArrayList.get(0).getRollNo().equals("NoneItem")) {
						JOptionPane.showMessageDialog(panel2,"Không tìm thấy!" , ":(", JOptionPane.INFORMATION_MESSAGE);
					}
					
						else {
							ShowOnTableCus(listCustomers, listRooms);
						}
					listInforSearchArrayList=null;
					//System.out.println(listInforSearchArrayList.get(0).toString());
				}
			});
		
		JButton btnResetCustSearchForm = new JButton("Nhập lại");
		btnResetCustSearchForm.setBounds(1107, 120, 100, 30);
		SearchRoom.add(btnResetCustSearchForm);
        btnResetCustSearchForm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				txtID.setText("");
				txtFullName.setText("");
				txtIDPersonal.setText("");
				txtPhone.setText("");
				txtIDRoom.setText("");
				txtDayIn.setText("dd-mm-yyyy");
				txtDayOut.setText("dd-mm-yyyy");
				cbbTypeRent.setSelectedIndex(0);
				cbbTimeOut.setSelectedIndex(0);
				cbbTypeRent.setSelectedIndex(0);
			}
		});
		
		
		JButton btnShowAllCust = new JButton("Xem tất cả");
		btnShowAllCust.setBounds(1216, 120, 100, 30);
		SearchRoom.add(btnShowAllCust);
        btnShowAllCust.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				resetTableCus();
				ShowOnTableCus(listCustomers, listRooms);
				
			}
		});
//=================================================================================//
//===================================tab REGISTER====================================//
        
		JPanel jPRegister = new JPanel();
		tabPaneMain.addTab("\u0110\u1EB7t ph\u00F2ng", null, jPRegister, null);
		
		JLabel lblFullName1 = new JLabel();
		lblFullName1.setBounds(120, 40, 80, 30);
		lblFullName1.setText("Tên khách hàng:");
		
		JLabel lblIDPersonal1 = new JLabel();
		lblIDPersonal1.setBounds(120, 100, 80, 30);
		lblIDPersonal1.setText("CMND:");
		
		JLabel lblPhone1 = new JLabel();
		lblPhone1.setBounds(120, 160, 80, 30);
		lblPhone1.setText("SĐT:");
		
		txtFullName2 = new JTextField();
		txtFullName2.setBounds(218, 40, 260, 30);
		
		txtIDPersonal2 = new JTextField();
		txtIDPersonal2.setBounds(218, 100, 260, 30);
		
		JLabel jLabel11 = new JLabel();
		jLabel11.setBounds(580, 40, 100, 30);
		jLabel11.setText("Chọn loại phòng:");
		
		JLabel jLabel12 = new JLabel();
		jLabel12.setBounds(580, 100, 100, 30);
		jLabel12.setText("Số giường:");
		
		JLabel jLabel13 = new JLabel();
		jLabel13.setBounds(580, 160, 100, 30);
		jLabel13.setText("Phòng:");
		
		JLabel jLabel16 = new JLabel();
		jLabel16.setBounds(580, 220, 100, 30);
		jLabel16.setText("Hình thức thuê:");
		

		JComboBox<String> cbbTypeRoom2 = new JComboBox<String>();
		cbbTypeRoom2.setBounds(680, 40, 180, 30);
		
		JComboBox<String> cbbBeds2 = new JComboBox<String>();
		cbbBeds2.setBounds(680, 100, 180, 30);
		
		JLabel jLabel15 = new JLabel();
		jLabel15.setBounds(980, 160, 20, 30);
		jLabel15.setText("Tới:");
		
		JComboBox<String> cbbTimeOut2 = new JComboBox<String>();
		cbbTimeOut2.setModel(new DefaultComboBoxModel<String>(new String[] {"", "0:00 AM", "1:00 AM", "2:00 AM", "3:00 AM", "4:00 AM", "5:00 AM", "6:00 AM", "7:00 AM", "8:00 AM", "9:00 AM", "10:00 AM", "11:00 AM", "12:00 AM", "1:00 PM", "2:00 PM", "3:00 PM", "4:00 PM", "5:00 PM", "6:00 PM", "7:00 PM", "8:00 PM", "9:00 PM", "10:00 PM", "11:00 PM"}));
		cbbTimeOut2.setBounds(1000, 160, 130, 30);
		
		JLabel jLabel10 = new JLabel();
		jLabel10.setBounds(980, 40, 20, 30);
		jLabel10.setText("Từ: ");
		
		JComboBox<String> cbbTimeIn2 = new JComboBox<String>();
		cbbTimeIn2.setModel(new DefaultComboBoxModel<String>(new String[] {"", "0:00 AM", "1:00 AM", "2:00 AM", "3:00 AM", "4:00 AM", "5:00 AM", "6:00 AM", "7:00 AM", "8:00 AM", "9:00 AM", "10:00 AM", "11:00 AM", "12:00 AM", "1:00 PM", "2:00 PM", "3:00 PM", "4:00 PM", "5:00 PM", "6:00 PM", "7:00 PM", "8:00 PM", "9:00 PM", "10:00 PM", "11:00 PM"}));
		cbbTimeIn2.setBounds(1000, 40, 130, 30);
		
		JComboBox<String> cbbTypeRent2 = new JComboBox<String>();
		cbbTypeRent2.setBounds(680, 220, 180, 30);
		
		JComboBox<String> cbbIDRoom2 = new JComboBox<String>();
		cbbIDRoom2.setBounds(680, 160, 180, 30);
		
		txtPhone2 = new JTextField();
		txtPhone2.setBounds(218, 160, 260, 30);
		
		JButton btnRegister = new JButton();
		btnRegister.setBounds(950, 450, 130, 50);
		btnRegister.setText("Đặt");
		
		JButton btnCancel = new JButton();
		btnCancel.setBounds(1100, 450, 130, 50);
		btnCancel.setText("Hủy");
		jPRegister.setLayout(null);
		jPRegister.add(lblFullName1);
		jPRegister.add(lblIDPersonal1);
		jPRegister.add(lblPhone1);
		jPRegister.add(txtFullName2);
		jPRegister.add(txtIDPersonal2);
		jPRegister.add(jLabel11);
		jPRegister.add(jLabel12);
		jPRegister.add(jLabel13);
		jPRegister.add(jLabel16);
		jPRegister.add(cbbTypeRoom2);
		jPRegister.add(cbbBeds2);
		jPRegister.add(jLabel15);
		jPRegister.add(cbbTimeOut2);
		jPRegister.add(jLabel10);
		jPRegister.add(cbbTimeIn2);
		jPRegister.add(cbbTypeRent2);
		jPRegister.add(cbbIDRoom2);
		jPRegister.add(txtPhone2);
		jPRegister.add(btnRegister);
		jPRegister.add(btnCancel);
		roomSuggest=search.SearchRoom(listRooms, "", "Trống", "", "", "");
		cbbTypeRoom2.setModel(new DefaultComboBoxModel<>(setOptionTypeRoom(roomSuggest)));
		cbbBeds2.setModel(new DefaultComboBoxModel<>(setOptionBeds(roomSuggest)));
		cbbIDRoom2.setModel(new DefaultComboBoxModel<>(setOptionID(roomSuggest)));
		cbbTypeRent2.setModel(new DefaultComboBoxModel<>(new String[] {"","Theo giờ","Qua đêm"}));
		
		JPanel pPriceSuggest = new JPanel();
		pPriceSuggest.setBounds(244, 333, 330, 221);
		jPRegister.add(pPriceSuggest);
		pPriceSuggest.setLayout(null);
		
		JLabel lblTitlePrice = new JLabel("Thông tin thanh toán");
		lblTitlePrice.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTitlePrice.setBounds(10, 5, 310, 23);
		lblTitlePrice.setHorizontalAlignment(SwingConstants.CENTER);
		pPriceSuggest.add(lblTitlePrice);
		
		
		JLabel lblDetail = new JLabel("");
		lblDetail.setHorizontalAlignment(SwingConstants.LEFT);
		lblDetail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDetail.setBounds(10, 39, 310, 59);
		pPriceSuggest.add(lblDetail);
		
		JLabel lblDetail2 = new JLabel("");
		lblDetail2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDetail2.setBounds(10, 109, 310, 52);
		pPriceSuggest.add(lblDetail2);
		
		
		cbbTypeRoom2.addItemListener(new  ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				roomSuggest=search.SearchRoom(roomSuggest,"","Trống" ,"",cbbTypeRoom2.getItemAt(cbbTypeRoom2.getSelectedIndex()), "");
//				cbbBeds2.setModel(new DefaultComboBoxModel<>(setOptionBeds(roomSuggest)));
				cbbIDRoom2.setModel(new DefaultComboBoxModel<>(setOptionID(roomSuggest)));
				if (cbbTimeIn2.getSelectedIndex()==0 | cbbTimeOut2.getSelectedIndex()==0) {
					if(cbbTypeRent2.getItemAt(cbbTypeRent2.getSelectedIndex()).equals(""))
					{
					String min1h = search.searchMinPrice(roomSuggest, "Theo giờ");
					String minOver= search.searchMinPrice(roomSuggest, "Qua đêm");
					lblDetail.setText("Giá theo giờ thấp nhất: "+min1h);
					lblDetail2.setText(	"Giá qua đêm thấp nhất: " +minOver);
					}
					if (cbbTypeRent2.getItemAt(cbbTypeRent2.getSelectedIndex()).equals("Theo giờ")) {
						String min = search.searchMinPrice(roomSuggest, "Theo giờ");
						lblDetail.setText("Giá theo giờ thấp nhất: "+min);
					}
					if (cbbTypeRent2.getItemAt(cbbTypeRent2.getSelectedIndex()).equals("Qua đêm")) {
						String min = search.searchMinPrice(roomSuggest, "Qua đêm");
						lblDetail.setText("Giá qua đêm thấp nhất: "+min);
					}
				}else {
					int value= calTime(cbbTimeIn2.getItemAt(cbbTimeIn2.getSelectedIndex()), cbbTimeOut2.getItemAt(cbbTimeOut2.getSelectedIndex()));
					if(cbbTypeRent2.getItemAt(cbbTypeRent2.getSelectedIndex()).equals(""))
					{
					String min1h = search.searchMinPrice(roomSuggest, "Theo giờ");
					String minOver= search.searchMinPrice(roomSuggest, "Qua đêm");
					lblDetail.setText("Giá theo giờ thấp nhất: "+String.valueOf(Integer.valueOf(min1h)*value));
					lblDetail2.setText("Giá qua đêm thấp nhất: " +String.valueOf(Integer.valueOf(minOver)*value));
					}
					if (cbbTypeRent2.getItemAt(cbbTypeRent2.getSelectedIndex()).equals("Theo giờ")) {
						String min = search.searchMinPrice(roomSuggest, "Theo giờ");
						lblDetail.setText("Giá theo giờ thấp nhất: "+String.valueOf(Integer.valueOf(min)*value));
					}
					if (cbbTypeRent2.getItemAt(cbbTypeRent2.getSelectedIndex()).equals("Qua đêm")) {
						String min = search.searchMinPrice(roomSuggest, "Qua đêm");
						lblDetail.setText("Giá qua đêm thấp nhất: "+String.valueOf(Integer.valueOf(min)*value));
					}
				}
			}
		});
		cbbBeds2.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				roomSuggest=search.SearchRoom(roomSuggest, "", "Trống",cbbBeds2.getItemAt(cbbBeds2.getSelectedIndex()), "","");
//				cbbTypeRoom2.setModel(new DefaultComboBoxModel<>(setOptionTypeRoom(roomSuggest)));
				cbbIDRoom2.setModel(new DefaultComboBoxModel<>(setOptionID(roomSuggest)));
				if (cbbTimeIn2.getSelectedIndex()==0 | cbbTimeOut2.getSelectedIndex()==0) {
					if(cbbTypeRent2.getItemAt(cbbTypeRent2.getSelectedIndex()).equals(""))
					{
					String min1h = search.searchMinPrice(roomSuggest, "Theo giờ");
					String minOver= search.searchMinPrice(roomSuggest, "Qua đêm");
					lblDetail.setText("Giá theo giờ thấp nhất: "+min1h);
					lblDetail2.setText(	"Giá qua đêm thấp nhất: " +minOver);
					}
					if (cbbTypeRent2.getItemAt(cbbTypeRent2.getSelectedIndex()).equals("Theo giờ")) {
						String min = search.searchMinPrice(roomSuggest, "Theo giờ");
						lblDetail.setText("Giá theo giờ thấp nhất: "+min);
					}
					if (cbbTypeRent2.getItemAt(cbbTypeRent2.getSelectedIndex()).equals("Qua đêm")) {
						String min = search.searchMinPrice(roomSuggest, "Qua đêm");
						lblDetail.setText("Giá qua đêm thấp nhất: "+min);
					}
				}else {
					int value= calTime(cbbTimeIn2.getItemAt(cbbTimeIn2.getSelectedIndex()), cbbTimeOut2.getItemAt(cbbTimeOut2.getSelectedIndex()));
					if(cbbTypeRent2.getItemAt(cbbTypeRent2.getSelectedIndex()).equals(""))
					{
					String min1h = search.searchMinPrice(roomSuggest, "Theo giờ");
					String minOver= search.searchMinPrice(roomSuggest, "Qua đêm");
					lblDetail.setText("Giá theo giờ thấp nhất: "+String.valueOf(Integer.valueOf(min1h)*value));
					lblDetail2.setText("Giá qua đêm thấp nhất: " +String.valueOf(Integer.valueOf(minOver)*value));
					}
					if (cbbTypeRent2.getItemAt(cbbTypeRent2.getSelectedIndex()).equals("Theo giờ")) {
						String min = search.searchMinPrice(roomSuggest, "Theo giờ");
						lblDetail.setText("Giá theo giờ thấp nhất: "+String.valueOf(Integer.valueOf(min)*value));
					}
					if (cbbTypeRent2.getItemAt(cbbTypeRent2.getSelectedIndex()).equals("Qua đêm")) {
						String min = search.searchMinPrice(roomSuggest, "Qua đêm");
						lblDetail.setText("Giá qua đêm thấp nhất: "+String.valueOf(Integer.valueOf(min)*value));
					}
				}
			}
		});
		cbbTypeRent2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (cbbTimeIn2.getSelectedIndex()==0 | cbbTimeOut2.getSelectedIndex()==0) {
					if(cbbTypeRent2.getItemAt(cbbTypeRent2.getSelectedIndex()).equals(""))
					{
					String min1h = search.searchMinPrice(roomSuggest, "Theo giờ");
					String minOver= search.searchMinPrice(roomSuggest, "Qua đêm");
					lblDetail.setText("Giá theo giờ thấp nhất: "+min1h);
					lblDetail2.setText(	"Giá qua đêm thấp nhất: " +minOver);
					}
					if (cbbTypeRent2.getItemAt(cbbTypeRent2.getSelectedIndex()).equals("Theo giờ")) {
						String min = search.searchMinPrice(roomSuggest, "Theo giờ");
						lblDetail.setText("Giá theo giờ thấp nhất: "+min);
					}
					if (cbbTypeRent2.getItemAt(cbbTypeRent2.getSelectedIndex()).equals("Qua đêm")) {
						String min = search.searchMinPrice(roomSuggest, "Qua đêm");
						lblDetail.setText("Giá qua đêm thấp nhất: "+min);
					}
				}else {
					int value= calTime(cbbTimeIn2.getItemAt(cbbTimeIn2.getSelectedIndex()), cbbTimeOut2.getItemAt(cbbTimeOut2.getSelectedIndex()));
					if(cbbTypeRent2.getItemAt(cbbTypeRent2.getSelectedIndex()).equals(""))
					{
					String min1h = search.searchMinPrice(roomSuggest, "Theo giờ");
					String minOver= search.searchMinPrice(roomSuggest, "Qua đêm");
					lblDetail.setText("Giá theo giờ thấp nhất: "+String.valueOf(Integer.valueOf(min1h)*value));
					lblDetail2.setText("Giá qua đêm thấp nhất: " +String.valueOf(Integer.valueOf(minOver)*value));
					}
					if (cbbTypeRent2.getItemAt(cbbTypeRent2.getSelectedIndex()).equals("Theo giờ")) {
						String min = search.searchMinPrice(roomSuggest, "Theo giờ");
						lblDetail.setText("Giá theo giờ thấp nhất: "+String.valueOf(Integer.valueOf(min)*value));
					}
					if (cbbTypeRent2.getItemAt(cbbTypeRent2.getSelectedIndex()).equals("Qua đêm")) {
						String min = search.searchMinPrice(roomSuggest, "Qua đêm");
						lblDetail.setText("Giá qua đêm thấp nhất: "+String.valueOf(Integer.valueOf(min)*value));
					}
				}
			}
		});
		cbbIDRoom2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (cbbTimeIn2.getSelectedIndex()==0 | cbbTimeOut2.getSelectedIndex()==0) {
					if(cbbTypeRent2.getItemAt(cbbTypeRent2.getSelectedIndex()).equals(""))
					{
					String min1h = search.searchMinPrice(roomSuggest, "Theo giờ");
					String minOver= search.searchMinPrice(roomSuggest, "Qua đêm");
					lblDetail.setText("Giá theo giờ thấp nhất: "+min1h);
					lblDetail2.setText(	"Giá qua đêm thấp nhất: " +minOver);
					}
					if (cbbTypeRent2.getItemAt(cbbTypeRent2.getSelectedIndex()).equals("Theo giờ")) {
						String min = search.searchMinPrice(roomSuggest, "Theo giờ");
						lblDetail.setText("Giá theo giờ thấp nhất: "+min);
					}
					if (cbbTypeRent2.getItemAt(cbbTypeRent2.getSelectedIndex()).equals("Qua đêm")) {
						String min = search.searchMinPrice(roomSuggest, "Qua đêm");
						lblDetail.setText("Giá qua đêm thấp nhất: "+min);
					}
				}else {
					int value= calTime(cbbTimeIn2.getItemAt(cbbTimeIn2.getSelectedIndex()), cbbTimeOut2.getItemAt(cbbTimeOut2.getSelectedIndex()));
					System.out.println(cbbTimeIn2.getItemAt(cbbTimeIn2.getSelectedIndex()));
					if(cbbTypeRent2.getItemAt(cbbTypeRent2.getSelectedIndex()).equals(""))
					{
					String min1h = search.searchMinPrice(roomSuggest, "Theo giờ");
					String minOver= search.searchMinPrice(roomSuggest, "Qua đêm");
					lblDetail.setText("Giá theo giờ thấp nhất: "+String.valueOf(Integer.valueOf(min1h)*value));
					lblDetail2.setText("Giá qua đêm thấp nhất: " +String.valueOf(Integer.valueOf(minOver)*value));
					}
					if (cbbTypeRent2.getItemAt(cbbTypeRent2.getSelectedIndex()).equals("Theo giờ")) {
						String min = search.searchMinPrice(roomSuggest, "Theo giờ");
						lblDetail.setText("Giá theo giờ thấp nhất: "+String.valueOf(Integer.valueOf(min)*value));
					}
					if (cbbTypeRent2.getItemAt(cbbTypeRent2.getSelectedIndex()).equals("Qua đêm")) {
						String min = search.searchMinPrice(roomSuggest, "Qua đêm");
						lblDetail.setText("Giá qua đêm thấp nhất: "+String.valueOf(Integer.valueOf(min)*value));
					}
				}
			}
				
		});
		JPanel panel1 = (JPanel) getContentPane();
		btnRegister.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String check=checkInputReg(txtFullName2.getText(),txtIDPersonal2.getText(), txtPhone2.getText(),cbbIDRoom2.getItemAt(cbbIDRoom2.getSelectedIndex()));

					if (check.equals("")) {
						if (cbbTimeIn2.getSelectedIndex()==0 | cbbTimeOut2.getSelectedIndex()==0) {
							int n= JOptionPane.showConfirmDialog(panel1, "Bạn không nhập thời gian thuê ( mặc định qua đêm)?","Xác nhận",JOptionPane.YES_NO_OPTION);
							if(n==JOptionPane.YES_OPTION) {
								cbbTypeRent2.setSelectedIndex(2);
								int n1= JOptionPane.showConfirmDialog(panel1, "Bạn chắc chắn về thông tin đã nhập không?","Xác nhận",JOptionPane.YES_NO_OPTION);
								if(n1==JOptionPane.YES_OPTION) {
								Customer temp= new Customer();
								String rollNo= createRollNo(hashMapCustHashMap);
								temp.setFullName(txtFullName2.getText());
								temp.setiD(txtIDPersonal2.getText());
								temp.setPhoneNumber(txtPhone2.getText());
								temp.setiDRoom(cbbIDRoom2.getItemAt(cbbIDRoom2.getSelectedIndex()));
								temp.setTypeRent(cbbTypeRent2.getItemAt(2));
								temp.setInOut(action.getInforTimeReg("","" ));
								temp.setRollNo(rollNo);
								hashMapCustHashMap.put(rollNo, temp);
								listCustomers.add(temp);
								String iDRoomString= cbbIDRoom2.getItemAt(cbbIDRoom2.getSelectedIndex());
								listRooms=action.setStautus(listRooms, iDRoomString);
								input.exportRoom(listRooms);
								ShowOnTableCus(listCustomers, listRooms);
								ShowOnTableRoom(listRooms);
								JOptionPane.showMessageDialog(panel1,  "ID của bạn: "+rollNo+"\nID phòng bạn là: "+iDRoomString+
																		"\nLoại phòng: "+cbbTypeRoom2.getItemAt(cbbTypeRoom2.getSelectedIndex())+
																		"\nSố giường: "+cbbBeds2.getItemAt(cbbBeds2.getSelectedIndex())+
																		"\nHình thức thuê: "+temp.getTypeRent()
																		, "About", 
			                              JOptionPane.INFORMATION_MESSAGE);
							}	
						}
						}else {
						int n1= JOptionPane.showConfirmDialog(panel1, "Bạn chắc chắn về thông tin đã nhập không?","Xác nhận",JOptionPane.YES_NO_OPTION);
						if(n1==JOptionPane.YES_OPTION) {
						Customer temp= new Customer();
						String rollNo= createRollNo(hashMapCustHashMap);
						temp.setFullName(txtFullName2.getText());
						temp.setiD(txtIDPersonal2.getText());
						temp.setPhoneNumber(txtPhone2.getText());
						temp.setiDRoom(cbbIDRoom2.getItemAt(cbbIDRoom2.getSelectedIndex()));
						temp.setTypeRent(cbbTypeRent2.getItemAt(cbbTypeRent2.getSelectedIndex()));
						temp.setInOut(action.getInforTimeReg("","" ));
						temp.setRollNo(rollNo);
						hashMapCustHashMap.put(rollNo, temp);
						listCustomers.add(temp);
						input.exportCustomer(listCustomers);
						String iDRoomString= cbbIDRoom2.getItemAt(cbbIDRoom2.getSelectedIndex());
						listRooms=action.setStautus(listRooms, iDRoomString);
						input.exportRoom(listRooms);
						ShowOnTableCus(listCustomers, listRooms);
						ShowOnTableRoom(listRooms);
						JOptionPane.showMessageDialog(panel1,  "ID của bạn: "+rollNo+"\nID phòng bạn là: "+iDRoomString+
																"\nLoại phòng: "+cbbTypeRoom2.getItemAt(cbbTypeRoom2.getSelectedIndex())+
																"\nSố giường: "+cbbBeds2.getItemAt(cbbBeds2.getSelectedIndex())+
																"\nHình thức thuê: "+temp.getTypeRent()+
																"\nTổng số tiền: "+temp.payment(listRooms)
																
																, "About", 
	                              JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}else {
				JOptionPane.showMessageDialog(panel1,check, "About", 
                        JOptionPane.INFORMATION_MESSAGE);
			}
		}
		});
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int n1= JOptionPane.showConfirmDialog(panel1, "Bạn chắc chắn xóa hết thông tin đã nhập không?","Xác nhận",JOptionPane.YES_NO_OPTION);
				if(n1==JOptionPane.YES_OPTION) {
				txtFullName2.setText("");
				txtIDPersonal2.setText("");
				cbbBeds2.setSelectedIndex(0);
				cbbIDRoom2.setSelectedIndex(0);
				cbbTimeIn2.setSelectedIndex(0);
				cbbTimeOut2.setSelectedIndex(0);
				cbbTypeRent2.setSelectedIndex(0);
				cbbTypeRoom2.setSelectedIndex(0);
				}
			}
		});
		
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
         					  listCustomers.get(i).getInOut().getdateIn()+" "+listCustomers.get(i).getInOut().getTimeIn(),
         					  listCustomers.get(i).getInOut().getdateOut()+" "+listCustomers.get(i).getInOut().getTimeOut() ,
         					  listCustomers.get(i).getTypeRent(),
         					  listCustomers.get(i).getiDRoom(),
         					  listCustomers.get(i).payment(listRooms)};
         	tableModel.addRow(data);
         	}
         tableCust.setModel(tableModel);
		}
     public String[] setOptionBeds(ArrayList<Room> dataRooms) {
			String[] option = new String[] {""};
			for (Room room : dataRooms) {
				if (checkList(option, room.getBeds())) {
					option=addElement(option, room.getBeds());
				}
			}
			return option;
		}
     public String[] setOptionID(ArrayList<Room> dataRooms) {
			String[] option = new String[] {""};
			for (Room room : dataRooms) {
				if (checkList(option, room.getiDsRoom())) {
					option=addElement(option, room.getiDsRoom());
				}
			}
			return option;
		}
     public String[] setOptionTypeRoom(ArrayList<Room> dataRooms) {
			String[] optionType = new String[] {""};
			for (Room room : dataRooms) {
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
     public String convertTime(String dataTime) {
		if(dataTime.equals("")) return "0";
		else {
    	 String[] split= dataTime.split(" ");
    	 if (split[1].equals("PM")) {
    		String[] split1= split[0].split(":");
    		split1[0]=String.valueOf(Integer.valueOf(split1[0])+12);
    		return (split1[0]+":"+split1[1]);
    	 	}else return split[0];
    	 }
	}
     public int calTime(String startTime, String endTime) {
    	 int Time=0;
    	 String[] start=convertTime(startTime).split(":"), end= convertTime(endTime).split(":");
    	 
		if (Integer.valueOf(end[0])<Integer.valueOf(start[0])) {
			Time=24-Integer.valueOf(start[0])+ Integer.valueOf(end[0]);
		}else {
			Time=Integer.valueOf(end[0])- Integer.valueOf(start[0]);
		}
		return Time;
	}
     public String checkInputReg(String txtFullName, String txtIDPersonal, String txtPhone,  String IDRoom) {
		String resutl="";
		if (txtFullName.length()<2) {
			resutl="Họ và tên";
		}
		if (txtIDPersonal.length()<8 ) {
			resutl=resutl+", CMND/CCCD";
		}
		if (txtPhone.length()<10 && !isNumeric(txtPhone)) {
			resutl=resutl+", Số điện thoại(đủ 10 số)";
		}
		if (IDRoom.equals("")) {
			resutl= resutl+", ID phòng";
		}
		if (resutl.equals("")) return resutl;
		else return resutl="Vui lòng nhập: "+ resutl+".";
	}
     public String createRollNo(HashMap<String, Customer> dataHashMap) {
    	 String endString="";
		for (int i = 0; i < 1000; i++) {
			if(dataHashMap.containsKey("KH"+String.valueOf(i))) {}
			else return endString="KH"+String.valueOf(i);
		}
		return endString;
     }
     public boolean isNumeric(String str)
     {
         for (char c : str.toCharArray())
         {
             if (!Character.isDigit(c)) return false;
         }
         return true;
     }
}
