package com.wityo.stackeg;

public class StackArray {

	private static final int MAX_SIZE = 100;
	private static final int[] stackArray = new int[MAX_SIZE];
	private int top = -1;

	public void push(int data) {
		if (top == MAX_SIZE - 1) {
			System.out.println("Stack is already full, pop some element.");
		} else {
			stackArray[++top] = data;
		}
	}

	public void pop() {
		if (top == -1) {
			System.out.println("Stack is empty, cannot pop element.");
		} else {
			--top;
		}
	}

	public int peek() {
		return stackArray[top];
	}

	public void insertAtEnd(int data) {
		stackArray[currentEnd--] = data;

	}

	int currentEnd = top;

	public void reverse() {
		if (top == -1) {
			top = currentEnd;
			return;
		}
		int temp = peek();
		if (top > currentEnd) {
			currentEnd = top;
		}
		pop();
		reverse();
		insertAtEnd(temp);
	}

}
