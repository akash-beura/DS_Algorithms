package com.wityo.single;

public class SingleDriver {

	public static void main(String[] args) {
		SingleLinkedList<String> list1 = new SingleLinkedList<>();
		list1.insert("A");
		list1.insert("B");
		list1.insert("C");
		list1.insert("D");
//		System.out.println(list1.checkPallindrome());
		list1.swapPosition("A", "D");
		list1.findAll();
	}
}
