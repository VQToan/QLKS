package GUI;

import java.awt.EventQueue;

public class App {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginFrame frameLogin = new loginFrame();
					frameLogin.setVisible(true);	   
					}
				 catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

