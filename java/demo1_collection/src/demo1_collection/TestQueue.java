package demo1_collection;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;


class Person implements Comparable<Person>
{
	public  Person(String name) {
		this.name=name;
	}
	public String name;
	@Override
	public int compareTo(Person o) {
		return name.compareTo(o.name);
	}
}
public class TestQueue {

	public static void main(String[] args) {
		//简单队列
		Queue<String> queue=new LinkedList<String>();
		queue.add("a");
		queue.add("b");
		queue.add("c");
		//有容量的队列  add，peek, remove会抛异常
		while (queue.peek()!=null) {
			System.out.println(queue.peek());
			queue.remove();
		}
		System.out.println("------------------------");
		queue.clear();
		queue.offer("a");
		queue.offer("b");
		queue.offer("c");
		//有容量的队列  offer，element, poll不会会抛异常
		while (queue.peek()!=null) {
			System.out.println(queue.element());
			queue.poll();
		}
		System.out.println("------------------------");

		Queue<Person> priorityQueue=new  PriorityQueue<>();
		Person person;
		person=new Person("Tom");
		priorityQueue.add(person);
		person=new Person("Jack");
		priorityQueue.add(person);
		person=new Person("Rose");
		priorityQueue.add(person);
		priorityQueue.forEach(per->System.out.println(per.name));
		System.out.println("------------------------");
		
		
		priorityQueue=new  PriorityQueue<>(new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				// TODO Auto-generated method stub
				return -o1.name.compareTo(o2.name);
			}
		});
		person=new Person("Tom");
		priorityQueue.add(person);
		person=new Person("Jack");
		priorityQueue.add(person);
		person=new Person("Rose");
		priorityQueue.add(person);
		priorityQueue.forEach(per->System.out.println(per.name));
		
		
		//代码使用
		//Deque<E>

	}

}
