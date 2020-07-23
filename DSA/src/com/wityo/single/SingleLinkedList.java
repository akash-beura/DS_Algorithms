package com.wityo.single;

import java.util.Stack;

public class SingleLinkedList<T> {

	SNode<T> head;

	public void insert(T data) {
		SNode<T> temp = new SNode<>();
		temp.data = data;
		if (head == null) {
			head = temp;
		} else {
			SNode<T> temp2 = head;
			while (temp2.next != null) {
				temp2 = temp2.next;
			}
			temp2.next = temp;
		}
	}

	public void insert(T data, int pos) {
		SNode<T> temp = new SNode<>();
		temp.data = data;
		if (pos <= 1) {
			temp.next = head;
			head = temp;
		} else {
			SNode<T> temp2 = head;
			for (int i = 0; i < pos - 2; i++) {
				temp2 = temp2.next;
				if (temp2 == null) {
					throw new RuntimeException("Enter valid position");
				}
			}
			temp2.next = temp;
		}
	}

	public void delete(int pos) {
		if (pos <= 1) {
			head = head.next;
		} else {
			SNode<T> temp = head;
			for (int i = 0; i < pos - 2; i++) {
				temp = temp.next;
				if (temp == null || temp.next == null) {
					throw new RuntimeException("Enter valid position");
				}
			}
			temp.next = temp.next.next;
		}
	}

	public void reverseLinkedList(SNode<T> p) {
		if (p.next == null) {
			head = p;
			return;
		}
		reverseLinkedList(p.next);
		SNode<T> q = p.next;
		q.next = p;
		p.next = null;
	}

	public void reverse() {
		SNode<T> current = head;
		SNode<T> prev = null;
		SNode<T> next = null;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head = prev;
	}

	public void findAll() {
		SNode<T> temp = head;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

	public void search(SNode<T> element, T data) {
		if (element.data == data) {
			System.out.println("Found");
			return;
		}
		search(element.next, data);
	}

	public Boolean checkPallindrome() {
		Stack<T> stack = new Stack<>();
		Boolean isPallindrome = true;
		SNode<T> temp = head;
		while (temp != null) {
			stack.push(temp.data);
			temp = temp.next;
		}
		temp = head;
		while (temp != null) {
			T data = stack.pop();
			if (temp.data != data) {
				isPallindrome = false;
				break;
			} else {
				temp = temp.next;
			}
		}
		return isPallindrome;

	}

	public void swapPosition(T data1, T data2) {

		if (data1 == data2)
			return;

		SNode<T> a = null, b = null;

		SNode<T> traverser = this.head;

		while (traverser.next != null) {
			if (traverser == head) {
				if (traverser.data == data1) {
					a = traverser;
				} else if (traverser.data == data2) {
					b = traverser;
				}
			}
			if (traverser.next.data == data1) {
				a = traverser;
			} else if (traverser.next.data == data2) {
				b = traverser;
			}

			traverser = traverser.next;
		}

		if (a != null && b != null) {
			if (a == head) {
				SNode<T> temp, temp2;
				temp = b.next;
				b.next = a;
				temp2 = temp.next;
				temp.next = a.next;
				a.next = temp2;
				head = temp;
			} else if (b == head) {
				SNode<T> temp, temp2;
				temp = a.next;
				a.next = b;
				temp2 = temp.next;
				temp.next = b.next;
				b.next = temp2;
				head = temp;
			} else {
				SNode<T> c = a.next;
				a.next = b.next;
				b.next = c;
				c = a.next.next;
				a.next.next = b.next.next;
				b.next.next = c;
			}

		}

	}

}
