package demo1_collection;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class TestSet {
	public static class Dept  
	{
		public  Dept(String name) {
			this.name=name;
		}
		@Override
		public boolean equals(Object obj) {
			// TODO Auto-generated method stub
			return ((Dept)obj).name.equals(name);
		}
		@Override
		public int hashCode() {
			return name.hashCode();
		}
		public String name;
	
	}
	public static void main(String[] args) {
		
		
		//元素不能重复, 通过复写 hashCode equals 来判断元素是否重复
		Set<Dept> depts=new HashSet<>();
		Dept d1=new Dept("部门1");
		Dept d2=new Dept("部门1");
		depts.add(d1);
		depts.add(d2);
		depts.forEach(dept->System.out.println(dept.name));
		
		//无序，内部实现是数组
		Set<String> hashSet=new HashSet<String>();
		hashSet.add("d");
		hashSet.add("a");
		hashSet.add("c");
		hashSet.add("b");
		hashSet.forEach(str->System.out.println(str));
		System.out.println("--------------------");
		
		//有序，内部实现是链表
		Set<String> linkHashSet=new LinkedHashSet<String>();
		linkHashSet.add("d");
		linkHashSet.add("a");
		linkHashSet.add("c");
		linkHashSet.add("b");
		linkHashSet.forEach(str->System.out.println(str));
		System.out.println("--------------------");

		
		Set<String> treeSet=new TreeSet<String>();
		treeSet.add("d");
		treeSet.add("a");
		treeSet.add("c");
		treeSet.add("b");
		treeSet.forEach(str->System.out.println(str));
		System.out.println("--------------------");
		
		Set<Dept> treeSetDepts=new TreeSet<>(new Comparator<Dept>() {

			@Override
			public int compare(Dept o1, Dept o2) {
				// TODO Auto-generated method stub
				return -o1.name.compareTo(o2.name);
			}
		});
		treeSetDepts.add(new Dept("dept1"));
		treeSetDepts.add(new Dept("dept2"));
		treeSetDepts.add(new Dept("dept3"));
		treeSetDepts.add(new Dept("dept4"));
		treeSetDepts.forEach(dept->System.out.println(dept.name));
		System.out.println("--------------------");

	}

}
