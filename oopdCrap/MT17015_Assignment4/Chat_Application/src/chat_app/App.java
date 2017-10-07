package chat_app;
import java.util.*;
import java.io.*;

public class App {
	private ArrayList<User> users;
	private ArrayList<Admin> admins;
	//private ArrayList<Group> groups;
	
	public App()
	{
		users = new ArrayList<User>();
		admins = new ArrayList<Admin>();
		//groups = new ArrayList<Group>();
	}
	
	public void addUser(String uname, String pno, String address)
	{
		for(User u : users)
		{
			if(u.getUsername().compareTo(uname) == 0)
			{
				System.out.println("---->Username already taken.");
				return;
			}
		}
		User u = new User(uname, pno, address);
		users.add(u);
	}
	
	public void addAdmin(String aname, String pno, String address)
	{
		for(Admin a : admins)
		{
			if(a.getAdminName().compareTo(aname) == 0)
			{
				System.out.println("---->Admin name already taken.");
				return;
			}
		}
		Admin a = new Admin(aname, pno, address);
		admins.add(a);
	}
	
	public ArrayList<User> getUsers() {
		return users;
	}

	public ArrayList<Admin> getAdmins() {
		return admins;
	}
	
	public void createGroup(String gname, String aname)
	{
		Boolean flag = false;
		for(Admin a : admins)
		{
			if(a.getAdminName().compareTo(aname) == 0)
			{
				flag = true;
				a.createGroup(gname);
				break;
			}
		}
		if(!flag)
			System.out.println("---->Admin with this name does not exists.");
	}
	
	public void deleteGroup(String gname, String aname)
	{
		Boolean flag = false;
		for(Admin a : admins)
		{
			if(a.getAdminName().compareTo(aname) == 0)
			{
				flag = true;
				for(User u : users)
				{
					u.removeFromGroupList(gname);
				}
				a.deleteGroup(gname);
				break;
			}
		}
		if(!flag)
			System.out.println("---->Admin with this name does not exists.");
	}
	
	public void addRequest(String uname, String gname, String aname)
	{
		for(User u : users)
		{
			if(u.getUsername().compareTo(uname) == 0)
			{
				//System.out.println(u.getUsername());
				for(Admin a : admins)
				{
					if(a.getAdminName().compareTo(aname) == 0)
					{
						//System.out.println(a.getAdminName());
						a.addRequest(gname, uname);
						u.addToGroupList(gname);
						//System.out.println("done");
					}
				}
				break;
			}
		}
	}
	
	public void leaveGroup(String uname, String gname, String aname)
	{
		for(User u : users)
		{
			if(u.getUsername().compareTo(uname) == 0)
				{
					for(Admin a : admins)
					{
						if(a.getAdminName().compareTo(aname) == 0)
						{
							a.removeFromGroup(gname, uname);
							u.removeFromGroupList(gname);
							break;
						}
					}
					break;
				}
		}
	}
	
	public void showPendingRequests(String aname)
	{
		for(Admin a : admins)
		{
			if(a.getAdminName().compareTo(aname) == 0)
			{
				a.showPendingRequests();
				break;
			}
		}
	}
	
	public void acceptAddRequest(String aname, String gname, String uname)
	{
		Boolean flag = false;
		for(Admin a : admins)
		{
			if(a.getAdminName().compareTo(aname) == 0)
			{
				flag = true;
				a.acceptPendingRequests(gname, uname);
				break;
			}
		}
		if(!flag)
			System.out.println("---->Admin with this name doesn't exists.");
	}
	
	public void sendMessage(String uname, String gname, String aname, String msg)
	{
		for(User u : users)
		{
			if(u.getUsername().compareTo(uname) == 0)
				{
					u.send(msg, gname);
					for(Admin a : admins)
					{
						if(a.getAdminName().compareTo(aname) == 0)
						{
							a.addMessageToGroup(uname, gname, msg);
							break;
						}
					}
					break;
				}
		}
		
		for(Admin u : admins)
		{
			if(u.getUsername().compareTo(uname) == 0)
				{
					u.send(msg, gname);
					for(Admin a : admins)
					{
						if(a.getAdminName().compareTo(aname) == 0)
						{
							a.addMessageToGroup(uname, gname, msg);
							break;
						}
					}
					break;
				}
		}
	}
	
	public void showMessages(String uname, String gname, String aname)
	{
		for(Admin a : admins)
		{
			if(a.getAdminName().compareTo(aname) == 0)
			{
				a.showGroupChat(gname, uname);
			}
		}
	}
	
	public void showAllGroups()
	{
		for(Admin a : admins)
		{
			a.showGroups();	
		}
	}
	
	public void showAllUsers()
	{
		for( User u : users)
		{
			System.out.println(u.getUsername());
		}
	}
	
	public void showAllAdmins()
	{
		for( Admin a : admins)
		{
			System.out.println(a.getAdminName());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("input.txt");
	    try{
	    	Scanner in = new Scanner(file).useDelimiter("\\s");
	        String s;
	        
	        App app = new App();
	        
	        while(in.hasNext())
	        {
	          s = in.next();
	          if(s.toLowerCase().compareTo("addu") == 0)
	          {
	        	  String uname = in.next().toLowerCase();
	        	  //System.out.println(f);
	        	  String pno = in.next().toLowerCase();
	        	  //System.out.println(l);
	        	  String address = in.next().toLowerCase();
				  //System.out.println(c);
				
				  app.addUser(uname, pno, address);
				  System.out.println("--------------------------------");
	          }
	          else if(s.toLowerCase().compareTo("adda") == 0)
	          {
				  String aname = in.next().toLowerCase();
				  //System.out.println(f);
				  String pno = in.next().toLowerCase();
				  //System.out.println(l);
				  String address = in.next().toLowerCase();
				  //System.out.println(c);
				
				  app.addAdmin(aname, pno, address);
				  System.out.println("--------------------------------");
	          }
	          else if(s.toLowerCase().compareTo("create-group") == 0)
	          {
	        	  String gname = in.next().toLowerCase();
				  //System.out.println(f);
				  String aname = in.next().toLowerCase();
				  //System.out.println(l);
				  
				  app.createGroup(gname, aname);
	        	  System.out.println("--------------------------------");
	          }
	          else if(s.toLowerCase().compareTo("delete-group") == 0)
	          {
	        	  String gname = in.next().toLowerCase();
				  //System.out.println(f);
				  String aname = in.next().toLowerCase();
				  //System.out.println(l);
				  
				  app.deleteGroup(gname, aname);
				  System.out.println("--------------------------------");
	          }
	          else if(s.toLowerCase().compareTo("add-request") == 0)
	          {
	        	  String uname = in.next().toLowerCase();
				  //System.out.println(f);
				  String gname = in.next().toLowerCase();
				  //System.out.println(l);
				  String aname = in.next().toLowerCase();
				  //System.out.println(c);
				
				  app.addRequest(uname, gname, aname);
	        	  System.out.println("--------------------------------");
	          }
	          else if(s.toLowerCase().compareTo("leave-group") == 0)
	          {
	        	  String uname = in.next().toLowerCase();
				  //System.out.println(f);
				  String gname = in.next().toLowerCase();
				  //System.out.println(l);
				  String aname = in.next().toLowerCase();
				  //System.out.println(c);
				
				  app.leaveGroup(uname, gname, aname);
	        	  System.out.println("--------------------------------");
	          }
	          else if(s.toLowerCase().compareTo("show-pending-requests") == 0)
	          {
				  String aname = in.next().toLowerCase();
				  //System.out.println(c);
				
				  app.showPendingRequests(aname);
	        	  System.out.println("--------------------------------");
	          }
	          else if(s.toLowerCase().compareTo("accept-request") == 0)
	          {
	        	  String aname = in.next().toLowerCase();
				  //System.out.println(f);
				  String gname = in.next().toLowerCase();
				  //System.out.println(l);
				  String uname = in.next().toLowerCase();
				  //System.out.println(c);
				
				  app.acceptAddRequest(aname, gname, uname);
	        	  System.out.println("--------------------------------");
	          }
	          else if(s.toLowerCase().compareTo("send-message") == 0)
	          {
	        	  String uname = in.next().toLowerCase();
				  //System.out.println(f);
				  String gname = in.next().toLowerCase();
				  //System.out.println(l);
				  String aname = in.next().toLowerCase();
				  //System.out.println(c);
				  String msg = in.nextLine();
		          //System.out.println(c);
				
				  app.sendMessage(uname, gname, aname, msg);
	        	  System.out.println("--------------------------------");
	          }
	          else if(s.toLowerCase().compareTo("show-message") == 0)
	          {
	        	  String uname = in.next().toLowerCase();
				  //System.out.println(f);
				  String gname = in.next().toLowerCase();
				  //System.out.println(l);
				  String aname = in.next().toLowerCase();
				  //System.out.println(c);
	        	  
	        	  app.showMessages(uname, gname, aname);
	        	  System.out.println("--------------------------------");
	          }
	          else if(s.toLowerCase().compareTo("show-groups") == 0)
	          {  	  
	        	  app.showAllGroups();
	        	  System.out.println("--------------------------------");
	          }
	          else if(s.toLowerCase().compareTo("show-users") == 0)
	          {  	  
	        	  app.showAllUsers();
	        	  System.out.println("--------------------------------");
	          }
	          else if(s.toLowerCase().compareTo("show-admins") == 0)
	          {  	  
	        	  app.showAllAdmins();
	        	  System.out.println("--------------------------------");
	          }
	        }

	    }
	    catch(FileNotFoundException ex)
	    {
	      System.out.println("---->Input file not found.");
	    }

	}

}
