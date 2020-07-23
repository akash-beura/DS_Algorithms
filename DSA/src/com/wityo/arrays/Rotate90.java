package com.wityo.arrays;

import java.util.Stack;

public class Rotate90 {

	public static void main(String[] args) {

		int[][] a = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int[][] b = new int[a.length][a.length];
		int k = a.length - 1;

		for (int i = 0; i < a.length; i++, k--) {
			for (int p = 0; p < a.length; p++) {
				b[i][p] = a[p][k];
			}
		}

		for (int i = 0; i < b.length; i++) {
			for (int l = 0; l < b.length; l++) {
				System.out.print(b[i][l] + " ");
			}
			System.out.println();
		}

	}

}
