package amazon.matrix;

import java.util.ArrayList;
import java.util.List;

public class MCM {

	static List<List<Integer>> matrix = new ArrayList<List<Integer>>();

	// Step1:(FIniding the range) i shld be 1 and j shld be x.length -1 initially
	public int solveMCM(int[] arr, int i, int j) {
		if (i >= j) {
			return 0;
		}
		int minCost = Integer.MAX_VALUE;
		for (int k = i; k < j; k++) {
			int temp = solveMCM(arr, i, k) + solveMCM(arr, k + 1, j) + arr[i - 1] * arr[k] * arr[j];
			if (temp < minCost) {
				minCost = temp;
			}
		}
		return minCost;
	}

	public int solveMCMMmemo(int[] arr, int i, int j) {
		if (i >= j) {
			return 0;
		}
		if (matrix.get(i).get(j) != -1) {
			return matrix.get(i).get(0);
		}
		int minCost = Integer.MAX_VALUE;
		for (int k = i; k < j; k++) {
			matrix.get(i).set(j, solveMCM(arr, i, k) + solveMCM(arr, k + 1, j) + arr[i - 1] * arr[k] * arr[j]);
			int temp = matrix.get(i).get(j);
			if (temp < minCost) {
				minCost = temp;
			}
		}
		return minCost;
	}

	public static void main(String[] args) {
		MCM ob = new MCM();
		int arr[] = { 10, 100, 5, 50 };
		Long start = System.nanoTime();
		System.out.println(ob.solveMCM(arr, 1, arr.length - 1));
		System.out.println("Time taken to solve using recursion:" + (System.nanoTime() - start));
		for (int i = 0; i < arr.length; i++) {
			List<Integer> temp = new ArrayList<>();
			for (int j = 0; j < arr.length; j++) {
				if (i == j) {
					temp.add(0);
					continue;
				}
				temp.add(-1);
			}
			matrix.add(temp);
		}

		start = System.nanoTime();
		System.out.println(ob.solveMCMMmemo(arr, 1, arr.length - 1));
		System.out.println("Time taken to solve using recursion:" + (System.nanoTime() - start));
		System.out.println(matrix);
	}
}
