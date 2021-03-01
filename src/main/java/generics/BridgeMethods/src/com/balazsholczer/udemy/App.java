package generics.BridgeMethods.src.com.balazsholczer.udemy;

public class App {

	/**
	 * Bridge methods are usually occur when inheritance is used
	 * 	~ it is an additional method added during type erasure in order to avoid
	 * 			ambiguous situations !!!
	 * 
	 */

	public static void main(String[] args) {
		System.out.println("hello");
	}
}

// ------------- BEFORE TYPE ERASURE ----------------

class Node1<T> {

	private T data;

	public Node1(T data) {
		this.data = data;
	}

	public void setData(T data) {
		this.data = data;
	}
}

class MyNode1 extends Node1<Integer> {

	public MyNode1(Integer data) {
		super(data);
	}

	public void setData(Integer data) {
		super.setData(data);
	}
}

 //--------------------  AFTER TYPE ERASURE -----------------

class Node {

	private Object data;

	public Node(Object data) {
		this.data = data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}

class MyNode extends Node {

	public MyNode(Integer data) {
		super(data);
	}

	public void setData(Integer data) {
		super.setData(data);
	}
}

 //-------------------------------------------------------------

 /*as you can see after type erasure there is a problem:  the setData() method arguments do not match
		Java compiler is going to create a method in order to solve this problem --> this is the bridge method
*/
class MyNode2 extends Node {

	public MyNode2(Integer data) {
		super(data);
	}

	public void setData(Object o) {
		setData((Integer) o);					//	<----- THIS IS THE BRIDGE METHOD !!!
	}

	public void setData(Integer data) {
		super.setData(data);
	}
}
