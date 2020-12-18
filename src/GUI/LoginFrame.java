package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Core.DataFile;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class loginFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField fieldUser;
	private JPasswordField fieldPass;
	HashMap<String, String> UserLoginList= new HashMap<>();
	DataFile inOutDataFile= new DataFile();
	int key=0;
	

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public loginFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		UserLoginList=inOutDataFile.importUserList();
		
		JLabel lblTitle = new JLabel("ĐĂNG NHẬP");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblTitle, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblUser = new JLabel("Tên đăng nhập:");
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUser.setBounds(60, 50, 100, 40);
		panel.add(lblUser);
		
		fieldUser = new JTextField();
		fieldUser.setFont(new Font("Tahoma", Font.PLAIN, 13));
		fieldUser.setBounds(180, 50, 200, 40);
		panel.add(fieldUser);
		fieldUser.setColumns(10);
		
		JLabel lblPass = new JLabel("Mật khẩu:");
		lblPass.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPass.setBounds(60, 120, 100, 40);
		panel.add(lblPass);
		
		fieldPass = new JPasswordField();
		fieldPass.setFont(new Font("Tahoma", Font.PLAIN, 13));
		fieldPass.setBounds(180, 120, 200, 40);
		panel.add(fieldPass);
		
		JButton btnConfirm = new JButton("Đăng nhập");
		btnConfirm.setBounds(86, 178, 130, 30);
		panel.add(btnConfirm);
		JPanel panel1 = (JPanel) getContentPane();
		btnConfirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				if (fieldUser.getText().equals("")&&convertPasstoString(fieldPass.getPassword()).equals("")) {
					System.out.println("1");
					JOptionPane.showMessageDialog(panel1,"Vui lòng nhập tên đăng nhập và mật khẩu!" , "Cảnh báo!", JOptionPane.INFORMATION_MESSAGE);
				}else {
					
					if (fieldUser.getText().equals("")) {
						System.out.println("2");
						JOptionPane.showMessageDialog(panel1,"Vui lòng nhập tên đăng nhập!" , "Cảnh báo!", JOptionPane.INFORMATION_MESSAGE);
					}else if (convertPasstoString(fieldPass.getPassword()).equals("")) {
						System.out.println("3");
						JOptionPane.showMessageDialog(panel1,"Vui lòng nhập mật khẩu!" , "Cảnh báo!", JOptionPane.INFORMATION_MESSAGE);
	
					}else {
						for (String string : UserLoginList.keySet()) {
							if (fieldUser.getText().equalsIgnoreCase(string)) {
								if (convertPasstoString(fieldPass.getPassword()).equals(UserLoginList.get(string))) {
									System.out.println("4");
									mainFrame frame= new mainFrame();
									Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
									frame.setSize(screenSize.width, screenSize.height);
									frame.setVisible(true);
									setVisible(false);
								} else {
									System.out.println("5");
									JOptionPane.showMessageDialog(panel1,"Vui lòng nhập lại mật khẩu!" , "Cảnh báo!", JOptionPane.INFORMATION_MESSAGE);
									fieldPass.selectAll();
								}
							}else {
								System.out.println("6");
								JOptionPane.showMessageDialog(panel1,"Vui lòng nhập lại tên đăng nhập!" , "Cảnh báo!", JOptionPane.INFORMATION_MESSAGE);
								fieldUser.selectAll();
							}
					}
				}
				
				}
				
				
			}
		});
		
		JButton btnCancel = new JButton("Thoát");
		btnCancel.setBounds(226, 178, 130, 30);
		panel.add(btnCancel);
		setVisible(false);
		JPanel panel2 = (JPanel) getContentPane();
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int n1= JOptionPane.showConfirmDialog(panel2, "Bạn chắc chắn muốn thoát không?","Xác nhận",JOptionPane.YES_NO_OPTION);
				if(n1==JOptionPane.YES_OPTION)	{	
					System.exit(0);
				}
			}
		});
	}
	public int getKey() {
		return key;
	}
	public String convertPasstoString(char[] pass) {
		String endConvert="";
		for (char c : pass) {
			endConvert=endConvert+c;
		}
		return endConvert;
	}

}
