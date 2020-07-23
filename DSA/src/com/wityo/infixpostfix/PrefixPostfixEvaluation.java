package com.wityo.infixpostfix;

import com.wityo.stackeg.LLStack;

public class PrefixPostfixEvaluation {

	public boolean checkIfOperator(Character ch) {
		if (ch == '+' || ch == '-' || ch == '/' || ch == '*') {
			return true;
		}
		return false;
	}

	public int perform(int a, int b, char operator) {
		if (operator == '*')
			return a * b;
		else if (operator == '-')
			return a - b;
		else if (operator == '+')
			return a + b;
		else
			return a / b;
	}

	public int postFixEvaluation(String expression, String type) {

		LLStack stack = new LLStack();
		for (int i = 0; i < expression.length(); i++) {
			char current = expression.charAt(i);
			if (checkIfOperator(current)) {
				int value1, value2, result;
				if (type == "prefix") {
					value1 = stack.peek();
					stack.pop();
					value2 = stack.peek();
					stack.pop();
					result = perform(value1, value2, current);
				} else {
					value2 = stack.peek();
					stack.pop();
					value1 = stack.peek();
					stack.pop();
					result = perform(value1, value2, current);
				}
				stack.push(result);
			} else {
				stack.push(Character.getNumericValue(current));
			}
		}
		return stack.peek();
	}

	public int prefixEvaluation(String expression) {
		String newExp = "";
		for (int i = expression.length() - 1; i >= 0; i--) {
			newExp += expression.charAt(i);
		}
		return postFixEvaluation(newExp, "prefix");
	}

	public static void main(String[] args) {
		String exp = "23*54*+9-";
		String exp2 = "-+*23*549";
		System.out.println(new PrefixPostfixEvaluation().postFixEvaluation(exp,""));
		System.out.println(new PrefixPostfixEvaluation().prefixEvaluation(exp2));
		;
	}

}
