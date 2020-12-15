package Core;

public class InfoTime {
	private String timeIn;
	private String dateIn;
	private String timeOut;
	private String dateOut;
	public InfoTime() {
		super();
	}
	public InfoTime(String timeIn, String dateIn, String timeOut, String dateOut) {
		super();
		this.timeIn = timeIn;
		this.dateIn = dateIn;
		this.timeOut = timeOut;
		this.dateOut = dateOut;
	}
	public String getTimeIn() {
		return timeIn;
	}
	public void setTimeIn(String timeIn) {
		this.timeIn = timeIn;
	}
	public String getdateIn() {
		return dateIn;
	}
	public void setdateIn(String dateIn) {
		this.dateIn = dateIn;
	}
	public String getTimeOut() {
		return timeOut;
	}
	public void setTimeOut(String timeOut) {
		this.timeOut = timeOut;
	}
	public String getdateOut() {
		return dateOut;
	}
	public void setdateOut(String dateOut) {
		this.dateOut = dateOut;
	}
	@Override
	public String toString() {
		return "InfoTime [timeIn=" + timeIn + ", dateIn=" + dateIn + ", timeOut=" + timeOut + ", dateOut=" + dateOut
				+ "]";
	}
	public String getStringIn() {
		return timeIn+" "+dateIn;
	}
	public String getStringOut() {
		return timeOut+" "+ dateOut;
	}
}
