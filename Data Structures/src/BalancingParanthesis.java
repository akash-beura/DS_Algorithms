import java.util.Scanner;

class LinkedList{
	Node top = null;
	
	public void push(char data) {
		Node temp = new Node();
		temp.data = data;
		if(top == null) {
			top = temp;
		} else {
			temp.next = top;
			top = temp;
		}
	}
	
	public void pop() {
		if(top == null) {
			return;
		} else {
			top = top.next;
		}
	}
	
	 char top() {
		return top.data;
	}
}

public class BalancingParanthesis {
	
	public static void main(String[] args) {
		LinkedList stack = new LinkedList();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the parenthesis");
		String paranthesis = sc.next();
		char []x = paranthesis.toCharArray();
		boolean balanced = true;
		
		try {
			for(int i=0;i<x.length;i++) {
				if(x[i]=='{' || x[i] == '(' || x[i] == '[') {
					stack.push(x[i]);
				} else if(
					x[i] == '}' && stack.top() == '{' ||
					x[i] == ')' && stack.top() == '(' ||
					x[i] == ']' && stack.top() == '['
				) {
					stack.pop();
				} else {
					balanced = false;
					break;
				}
			}
			if(balanced == true) {
				System.out.println("It is balanced");
			} else {
				System.out.println("It is not balanced");
			}
		} catch (Exception e) {
			System.out.println("It is not balanced");
		}
		sc.close();
	}
}
