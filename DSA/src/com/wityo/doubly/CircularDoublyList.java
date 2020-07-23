package com.wityo.doubly;

public class CircularDoublyList {

	private DNode head;

	void insert(int data) {
		DNode node = new DNode();
		node.data = data;
		if (head == null) {
			head = node;
			head.next = head.prev = head;
		} else {
			DNode temp = head;
			while (temp.next != head) {
				temp = temp.next;
			}
			node.prev = temp;
			node.next = temp.next;
			head.prev = node;
			temp.next = node;
		}
	}

	void insert(int data, int pos) {
		DNode node = new DNode();
		node.data = data;
		if (pos <= 1) {
			if (head == null) {
				head = node;
				head.next = head.prev = head;
			} else {
				node.prev = head.prev;
				node.next = head;
				head.prev.next = node;
				head.prev = node;
			}
		} else {
			DNode temp = head;
			for (int i = 0; i < pos - 2; i++) {
				temp = temp.next;
			}
			if (temp.next == head) {
				node.prev = temp;
				node.next = head;
				head.prev = node;
				temp.next = node;
			} else {
				node.prev = temp;
				node.next = temp.next;
				temp.next.prev = node;
				temp.next = node;
			}
		}
	}

	void display() {
		DNode temp = head;
		do {
			System.out.println(temp.data);
			temp = temp.next;
		} while (temp != head);
	}

	int size() {
		DNode node = head;
		int i = 0;
		do {
			node = node.next;
			i++;
		} while (node != head);
		return i;
	}

	void delete(int pos) {

		int actualPos = pos % size();
		if (actualPos == 1) {
			if (head == null) {
				System.out.println("List is empty");
			} else {
				DNode temp = head;
				while (temp.next != head) {
					temp = temp.next;
				}
				temp.next = head.next;
				head.next.prev = temp;
				head = head.next;
			}
		} else {
			DNode temp = head;
			if (actualPos == 0) {
				for (int i = 0; i < pos - 1 % size() - 1; i++) {
					temp = temp.next;
				}
				temp.next = head;
				head.prev = temp;
			} else {
				for (int i = 0; i < actualPos - 2; i++) {
					temp = temp.next;
				}
				// if node at center
				DNode temp2 = temp.next;
				temp2.next = temp.next;
				temp.next.prev = temp2;
			}
		}

	}

}
