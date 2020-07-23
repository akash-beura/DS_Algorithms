package com.wityo.doubly;

public class DoublyLinkedList {

	private DNode head;

	public void findAll() {
		DNode temp = head;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

	public void insert(int data) {
		DNode node = new DNode();
		node.data = data;

		if (head == null) {
			head = node;
		} else {
			DNode temp = head;
			while (temp.next != null)
				temp = temp.next;
			node.prev = temp;
			temp.next = node;
		}
	}

	public void insert(int data, int pos) {
		DNode node = new DNode();
		node.data = data;

		if (pos <= 1) {
			head.prev = node;
			node.next = head;
			head = node;
		} else {
			DNode temp = head;
			// |||| |||| |||| ||||
			for (int i = 0; i < pos - 2; i++) {
				temp = temp.next;
				if (temp == null) {
					System.out.println("Wrong position");
					return;
				}

			}
			node.prev = temp;
			node.next = temp.next;
			if (node.next != null)
				node.next.prev = node;
			temp.next = node;
		}
	}

	public void delete(int pos) {
		if (head == null)
			return;
		if (pos <= 1) {
			head = head.next;
			head.prev = null;
		} else {
			DNode temp = head;
			for (int i = 0; i < pos - 2; i++) {
				temp = temp.next;
				if (temp == null) {
					System.out.println("Enter a valid position");
					return;
				}
			}
			DNode temp2 = temp.next;
			if (temp2.next != null)
				temp2.next.prev = temp;
			temp.next = temp2.next;
		}
	}

}
