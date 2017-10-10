package demo1_collection;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
class User
{
	public String name;
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
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
	}

}
