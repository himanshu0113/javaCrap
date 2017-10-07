package chat_app;
import java.util.*;

public abstract class entity {
	
	private String username;
	private String pno;
	private String address;
	private ArrayList<Message> msg;
	
	public entity( String username, String pno, String address)
	{
		this.setUsername(username);
		this.setPno(pno);
		this.setAddress(address);
		msg = new ArrayList<Message>();
	}
	
	public void send(String msg, String gname)
	{
		Message m = new Message(msg, getUsername(), gname);
		this.addMsg(m);
	}
	
	public void displayInfo()
	{
		System.out.println("Unsername: " + this.username);
		System.out.println("Phone no.: " + this.pno);
		System.out.println("Address: " + this.address);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPno() {
		return pno;
	}

	public void setPno(String pno) {
		this.pno = pno;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public ArrayList<Message> getMsg() {
		return msg;
	}

	public void addMsg(Message m) {
		this.msg.add(m);
	}
}
