package com.wityo.single;

/**
 * @author Akash Beura
 *
 */
public class CircularLinkedList<T> {

	private SNode<T> head;

	public void insert(T data) {
		SNode<T> temp = new SNode<>();
		temp.data = data;
		if (head == null) {
			head = temp;
			temp.next = head;
		} else {
			SNode<T> temp2 = head;
			while (temp2.next != head) {
				temp2 = temp2.next;
			}
			temp.next = head;
			temp2.next = temp;

		}
	}

	public void insert(T data, int pos) {
		SNode<T> temp = new SNode<>();
		temp.data = data;
		SNode<T> temp2 = head;
		if (pos == 1) {
			while (temp2.next != head) {
				temp2 = temp2.next;
			}
			temp.next = head;
			head = temp;
			temp2.next = head;
		} else {
			for (int i = 0; i < pos - 2; i++) {
				temp2 = temp2.next;
			}
			temp.next = temp2.next;
			temp2.next = temp;
		}
	}

	public void delete(int pos) {
		SNode<T> temp = head;
		if (pos <= 1) {
			while (temp.next != head) {
				temp = temp.next;
			}
			head = head.next;
			temp.next = head;
		} else {

			for (int i = 0; i < pos - 2; i++) {
				temp = temp.next;
			}
			if (temp.next == head) {
				head = temp.next.next;
			}
			temp.next = temp.next.next;
		}

	}

	public void findAll() {
		SNode<T> temp = head;
		do {
			System.out.println(temp.data);
			temp = temp.next;
		} while (temp != head);
	}

}
