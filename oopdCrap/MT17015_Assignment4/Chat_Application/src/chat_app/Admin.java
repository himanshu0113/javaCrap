package chat_app;
import java.util.*;

public class Admin extends entity{
	private ArrayList<Group> groups;
	
	public Admin(String username, String pno, String address) {
		super(username, pno, address);
		this.groups = new ArrayList<Group>();
	}
	
	public String getAdminName()
	{
		return this.getUsername();
	}
	
	public void createGroup(String gname)
	{
		Group g = new Group(gname, this.getUsername());
		if(!groups.contains(g))
			this.groups.add(g);
		else
			System.out.println("---->Same name group exist with the same admin.");
	}
	
	public void deleteGroup(String gname)
	{
		Boolean flag = false;
		for(Group g : groups)
		{
			if(g.getName().compareTo(gname) == 0)
			{
				flag = true;
				this.groups.remove(g);
				break;
			}
		}
		if(!flag)
			System.out.println("---->Group doesn't exists.");
	}
	
	public void addRequest(String gname, String uname)
	{
		Boolean flag = false;
		for(Group g : this.groups)
		{
			if(g.getName().compareTo(gname) == 0)
			{
				flag = true;
				//System.out.println(g.getName());
				g.addToPending_list(uname);
			}
		}
		if(!flag)
			System.out.println("---->Group doesn't exists.");
	}
	
	public void showPendingRequests()
	{
		for(Group g : this.groups)
		{
			if(!g.pendingListIsEmpty())
			{
				System.out.println("Group: " + g.getName());
				System.out.println(g.getPending_list());
				System.out.println("");
			}
		}
	}
	
	public void acceptPendingRequests(String gname, String uname)
	{
		Boolean flag = false;
		for(Group g : groups)
		{
			if(g.getName().compareTo(gname) == 0)
			{
				flag = true;
				g.addToMembers(uname);
				g.removeFromPending_list(uname);
			}
		}
		if(!flag)
			System.out.println("---->Admin/Group mismatch.");
	}
	
	public void removeFromGroup(String gname, String uname)
	{
		Boolean flag = false;
		for(Group g : groups)
		{
			if(g.getName().compareTo(gname) == 0)
			{
				flag = true;
				g.removeFromMembers(uname);
			}
		}
		if(!flag)
			System.out.println("Group doesn't exists.");
	}
	
	public void addMessageToGroup(String uname, String gname, String msg)
	{
		Message m = new Message(msg, uname, gname);
		for(Group g : groups)
		{
			if(g.getName().compareTo(gname) == 0)
				g.addToChat(m);
		}
	}
	
	public void showGroupChat(String gname, String uname)
	{
		for(Group g : groups)
		{
			if(g.getName().compareTo(gname) == 0 && g.hasMember(uname))
			{
				System.out.println(g.getName() + ": ");
				g.getChat();
				break;
			}
		}
	}
	
	public void showGroups()
	{
		for(Group g : groups)
		{
			g.showInfo();
		}
	}
}
