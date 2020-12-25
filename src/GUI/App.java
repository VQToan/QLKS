package GUI;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

public class App {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					loginFrame frameLogin = new loginFrame();
//					frameLogin.setVisible(true);
					mainFrame frame= new mainFrame();
					Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
					frame.setSize(screenSize.width, screenSize.height-30);
					frame.setVisible(true);
					}
				 catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

