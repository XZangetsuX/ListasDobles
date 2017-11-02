package APP;

import java.util.Iterator;
import java.util.ListIterator;

import doubleLinkedList.doubleLinkedList;

public class app {

	public static void main(String[] args) {
		
		doubleLinkedList<String> name=new doubleLinkedList<String>();
		ListIterator <String>lit=name.listiterator();
		
		
		name.addFirst("Kurosaki");
		name.addFirst("Matsumoto");
		name.addFirst("Ishimaru");
		name.addFirst("Toshiro");
		name.addLast("GUS");
		
		//name.Remove("GUS");
		//name.removeFirst();
		//name.removeLast();
		//name.removeBefore("Ishimaru");
		//name.removeAfter("Kurosaki");
		//System.out.println(name.size());
		//name.clear();
		//name.pronter();
		
		name.list(lit);
		
		System.out.println("-------------------");
		
		name.listB(lit);
		System.out.println("-------------------");
		
		
	}

}
