class Nodez{
	int data;
	Nodez next;
}

class Queue{
	int data;
	Nodez front = null;
	Nodez rear = null;
	
	public void enQueue(int data) {
		Nodez temp = new Nodez();
		temp.data = data;
		temp.next = null;
		if(front == null && rear == null) {
			front = rear = temp;
			return;
		} 
		rear.next = temp;
		rear = temp;
	}
	
	public void deQueue() {
		if(front == null) {
			return;
		}
		if(front == rear) {
			front = rear = null;
			return;
		}
		front = front.next;
	}
	
	public void printQueue() {
		Nodez temp = front;
		System.out.print("<--Front--| ");
		while(temp.next!=null) {
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
		System.out.print(temp.data);
		System.out.print("--End--| ");
	}
}

public class QueueImpl {
	public static void main(String[] args) {
		int n = 10;
		Queue q = new Queue();
		for(int i = 0; i<10; i++) {
			q.enQueue(i);
		}
		q.printQueue();
	}
}
