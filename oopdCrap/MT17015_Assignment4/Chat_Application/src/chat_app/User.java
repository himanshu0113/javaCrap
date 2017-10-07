package chat_app;

import java.util.ArrayList;

public class User extends entity{
	private ArrayList<String> list_of_groups;

	public User(String username, String pno, String address) {
		super(username, pno, address);
		this.list_of_groups = new ArrayList<String>();
	}
	
	public ArrayList<String> getList_of_groups() {
		return list_of_groups;
	}

	public void addToGroupList(String group) {
		this.list_of_groups.add(group);
	}
	
	public void removeFromGroupList(String group) {
		if(this.list_of_groups.contains(group))
			this.list_of_groups.remove(group);
	}
	
	public void list_groups()
	{
		System.out.println("List of groups:\n" + getList_of_groups());
	}
	
	
}
