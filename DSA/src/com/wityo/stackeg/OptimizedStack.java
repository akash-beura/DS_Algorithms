package com.wityo.stackeg;

import java.util.Stack;

class MyStack {
	Stack<Integer> stack = new Stack<>();
	int min = Integer.MAX_VALUE;

	public void insert(int data) {
		if (data < min) {
			stack.push(min);
			min = data;
			stack.push(data);
		} else {
			stack.push(data);
		}
	}

	public void pop() {
		if (stack.peek() == min) {
			stack.pop();
			min = stack.pop();
		} else {
			stack.pop();
		}
	}

	public int top() {
		return stack.peek();
	}

	public int min() {
		return min;
	}
}

public class OptimizedStack {
	public static void main(String[] args) {
		MyStack stack = new MyStack();
		stack.insert(5);
		stack.insert(4);
		stack.insert(1);
		stack.insert(2);
		System.out.println(stack.min());
	}
}
