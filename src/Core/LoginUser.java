package Core;

public class LoginUser {
	private String userName;
	private String passWord;
	public LoginUser(String user, String passWord) {
		super();
		this.userName = user;
		this.passWord = passWord;
	}
	public LoginUser() {
		super();
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String user) {
		this.userName = user;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
}
