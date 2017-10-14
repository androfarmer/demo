package demo1_collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Consumer;

public class TestCollection {

	public static void main(String[] args) {
		Collection<String> collection = new ArrayList<String>();
		collection.add("a");
		collection.add("b");
		collection.add("c");
		collection.add("d");
		Iterator<String> it = collection.iterator();
		System.out.println(collection.size());
		collection.forEach(new Consumer<String>() {
			@Override
			public void accept(String t) {
				System.out.println( t+"--accept");
			}
		});
		collection.forEach(System.out::println);
		for (String string : collection) {
			System.out.println(string);
		}
		while (it.hasNext()) {
			it.next();
			it.remove();
		}
		System.out.println(collection.size());
	}

}
