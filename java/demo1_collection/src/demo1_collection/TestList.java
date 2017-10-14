package demo1_collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.Iterator;


import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;
class User
{
	public String name;
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof User)
		{
			return ((User) obj).name.equals(this.name);
		}
		return false;
	}
}
public class TestList {

	
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add(0, "tom");
		list.add(1, "rose");
		list.add(1, "jack");
		list.add(3, "vincent");
		list.forEach(System.out::println);
		System.out.println(list.lastIndexOf("tom"));
		System.out.println(list.indexOf("tom"));

		ListIterator<String> listIterator = list.listIterator();
		while (listIterator.hasNext()) {
			System.out.println(listIterator.next());
		}
		System.out.println("-------------");
		while (listIterator.hasPrevious()) {
			System.out.println(listIterator.previous());
		}
		
		List<User> users=new ArrayList<User>();
		User u1=new User();
		u1.name="tom";
		User u2=new User();
		u2.name="jack";
		User u3=new User();
		u3.name="rose";
		users.add(u1);
		users.add(u2);
		users.add(u3);
		
		
		User cUser=new User();
		cUser.name="tom";
		System.out.println(users.contains(cUser));
		Iterator<User>	iterator=users.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next().name);
			
		}
	}

}
