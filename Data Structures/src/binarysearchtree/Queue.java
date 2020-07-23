package binarysearchtree;

class QueueNode{
	Node data;
	QueueNode next;
}

public class Queue {

	QueueNode front;
	QueueNode rear;
	
	void enQueue(Node node) {
		QueueNode temp = new QueueNode();
		temp.data= node;
		temp.next = null;
		
		if(rear == null && front == null) {
			rear = front = temp;
			return;
		}
		rear.next = temp;
		rear = temp;
	}
	
	Node deQueue() {
		if(front == null) {
			return null;
		}
		if(front==rear) {
			Node temp = front.data;
			rear = front = null;
			return temp;
		}
		else {
			Node temp = front.data;
			front = front.next;
			return temp;
		}
	}
	
	Node getFront() {
		if(front == null) {
			return null;
		}
		return front.data;
	}
	
}
