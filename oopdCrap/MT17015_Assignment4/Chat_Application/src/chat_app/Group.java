package chat_app;
import java.util.*;

public class Group {
	private String name;
	private ArrayList<String> pending_list;
	private ArrayList<String> members;
	private String admin;
	private ArrayList<Message> chat;
	
	
	public Group(String name, String aname) {
		this.setName(name);
		this.setAdmin(aname);
		this.pending_list = new ArrayList<String>();
		this.members = new ArrayList<String>();
		this.chat = new ArrayList<Message>();
		
		this.addToMembers(aname);
	}
	
	public void showInfo()
	{
		System.out.println("Group name: " + name);
		System.out.println("Admin: " + admin);
		System.out.println("Memebers: " + members);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<String> getPending_list() {
		return pending_list;
	}

	public void addToPending_list(String uname) {
		if(this.members.isEmpty() || !this.members.contains(uname))
			this.pending_list.add(uname);
		else
			System.out.println("---->This user is already in the pending list of this group.");
	}
	
	public void removeFromPending_list(String uname) {
		if(!this.members.isEmpty() || this.members.contains(uname))
			this.pending_list.remove(uname);
		else
			System.out.println("---->This user is not in the pending list of this group.");
	}
	
	public Boolean pendingListIsEmpty()
	{
		return pending_list.isEmpty();
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	public ArrayList<String> getMembers() {
		return members;
	}

	public void addToMembers(String uname) {
		if(!this.members.contains(uname))
			this.members.add(uname);
		else
		System.out.println("---->This user is already member of this group.");
	}
	
	public void removeFromMembers(String uname) {
		if(this.members.contains(uname))
			this.members.remove(uname);
		else
		System.out.println("---->This user is not a member of this group.");
	}

	public void getChat() {
		for(Message m : chat)
			m.showMsg();
	}

	public void addToChat(Message msg) {
		this.chat.add(msg);
	}

	public Boolean hasMember(String uname)
	{
		return this.members.contains(uname);
	}
}
