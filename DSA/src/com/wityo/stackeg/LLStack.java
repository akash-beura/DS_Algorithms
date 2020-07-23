package com.wityo.stackeg;

class Node {
	Node next;
	int data;
}

public class LLStack {

	private Node top;

	public void push(int data) {
		Node node = new Node();
		node.data = data;
		if (top == null) {
			top = node;
		} else {
			node.next = top;
			top = node;
		}
	}

	public int pop() {
		if (top == null) {
			System.out.println("Stack is empty..");
			return -999;
		} else {
			int temp = top.data;
			top = top.next;
			return temp;
		}
	}

	public Integer peek() {
		if (top == null) {
			return null;
		} else {
			return top.data;
		}
	}

}
