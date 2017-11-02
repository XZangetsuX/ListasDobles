package NODO;

public class nodo <T> implements Comparable<T>{
	
	private T value=null;
	private nodo<T> next;
	private nodo<T> back;
	private long index=0;
	
	
	

	public nodo(){
		this.value=null;
	}
	
	public nodo(T value) {
		this.value=value;
	}
	
	
	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}
	public nodo<T> getNext() {
		return next;
	}
	public void setNext(nodo<T> next) {
		this.next = next;
	}
	public nodo<T> getBack() {
		return back;
	}
	public void setBack(nodo<T> back) {
		this.back = back;
	}
	
	public long getIndex() {
		return index;
	}

	public void setIndex(long index) {
		this.index = index;
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	@Override
	public int compareTo(T o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	

	

}
