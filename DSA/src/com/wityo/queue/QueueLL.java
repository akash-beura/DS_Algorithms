package com.wityo.queue;

class Node {
	int data;
	Node next;
}

public class QueueLL {

	private Node front;
	private Node rear;

	public boolean isEmpty() {
		if (front == null && rear == null) {
			return true;
		}
		return false;
	}

	public void enqueue(int data) {
		Node node = new Node();
		node.data = data;
		if (isEmpty()) {
			front = rear = node;
		} else {
			rear.next = node;
			rear = node;
		}
	}

	public void deQueue() {
		if (!isEmpty()) {
			if (front == rear) {
				front = rear = null;
			} else {
				front = front.next;
			}
		}
	}

	public void display() {
		Node temp = front;
		while (temp != null) {
			System.out.print(temp.data + "<-");
			temp = temp.next;
		}
	}

}
