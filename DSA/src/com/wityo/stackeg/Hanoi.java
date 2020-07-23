package com.wityo.stackeg;

public class Hanoi {

	public void hanoi(int n, String A, String B, String C) {
		if (n > 0) {
			hanoi(n - 1, A, C, B);
			System.out.println("Move a disc from " + A + " to " + C);
			hanoi(n - 1, B, A, C);
  
		}
	}

	public static void main(String[] args) {
		new Hanoi().hanoi(4, "A", "B", "C");

	}

}
