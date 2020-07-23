package com.wityo.queue;

class Queue {
	private static final int MAX_SIZE = 5;
	private static final int[] queue = new int[MAX_SIZE];
	private static int front = -1, rear = -1;

	public boolean isEmpty() {
		if (front == -1 && rear == -1) {
			return true;
		}
		return false;
	}

	public boolean isFull() {
		if (rear == MAX_SIZE - 1) {
			return true;
		}
		return false;
	}

	public void enqueue(int data) {
		if (!isFull()) {
			if (isEmpty()) {
				rear = front = 0;
			} else {
				++rear;
			}
			queue[rear] = data;
		}
	}

	public void dequeue() {
		if (isEmpty()) {
			return;
		} else if (front == rear) {
			front = rear = -1;
		} else {
			front++;
		}
	}
}

public class QueueDriver {

	public static void main(String[] args) {
		QueueLL queue = new QueueLL();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.display();

	}

}
