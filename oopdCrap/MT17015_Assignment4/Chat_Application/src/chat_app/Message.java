package chat_app;

public class Message {
	private String msg;
	private String mid;
	private String uname;
	private String gname;
	
	public Message(String msg, String uname, String gname) {
		this.setMsg(msg);
		this.setUname(uname);
		this.setGid(gname);
		this.setMid(null);	//add id
	}

	public void showMsg() {
		System.out.println(uname + ": " + msg);
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getGname() {
		return gname;
	}

	public void setGid(String gname) {
		this.gname = gname;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

}
