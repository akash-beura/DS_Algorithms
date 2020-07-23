package com.wityo.doubly;

public class DoublyDriver {

	public static void main(String[] args) {

		DoublyLinkedList list = new DoublyLinkedList();
		list.insert(1);
		list.insert(2);
		list.insert(3);
		list.insert(4);
		list.insert(5);
		list.insert(11);
		list.delete(11);
		list.findAll();
	}

}
