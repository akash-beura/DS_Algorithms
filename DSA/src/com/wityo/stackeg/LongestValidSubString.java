package com.wityo.stackeg;

import java.util.Stack;

public class LongestValidSubString {

	static int longestValidString(String expression) {
		Stack<Character> stack = new Stack<>();
		int counter = 0;
		for (int i = 0; i < expression.length(); i++) {
			char current = expression.charAt(i);
			if (current == '(' || current == '[' || current == '{') {
				stack.push(current);
			} else {
				if (!stack.isEmpty()) {
					if (current == ')') {
						if (stack.peek() == '(') {
							counter = counter + 2;
							stack.pop();
						}
					} else if (current == '}') {
						if (stack.peek() == '{') {
							counter = counter + 2;
							stack.pop();
						}
					} else if (current == ']') {
						if (stack.peek() == '[') {
							counter = counter + 2;
							stack.pop();
						}
					}
				}
			}
		}
		return counter;
	}

	public static void main(String[] args) {
		int a = longestValidString("((()");
		int b = longestValidString(")()())");
		int c = longestValidString("()(()))))");
		System.out.println(a + " " + b + " " + c);
	}

}
