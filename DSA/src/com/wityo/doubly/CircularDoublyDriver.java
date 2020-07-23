package com.wityo.doubly;

public class CircularDoublyDriver {

	public static void main(String[] args) {
		CircularDoublyList list = new CircularDoublyList();
		list.insert(1);
		list.insert(2);
		list.insert(3);
		list.insert(4);
		list.delete(0);
		list.display();
		
	}

}
