package dynamicprogramming;

import java.util.HashMap;
import java.util.HashSet;

public class SubsetSum {

	static boolean[][] dp;
	static int[][] t;

	public boolean solve(int[] ar, int sum, int n) {

		if (sum == 0) {
			return true;
		}
		if (n == 0) {
			return false;
		}

		if (ar[n - 1] <= sum) {
			return solve(ar, sum - ar[n - 1], n - 1) || solve(ar, sum, n - 1);
		} else {
			return solve(ar, sum, n - 1);
		}
	}

	public boolean solveWithMemo(int ar[], int sum, int n) {
		if (n == 0) {
			return false;
		}
		if (sum == 0) {
			return true;
		}

		if (dp[n][sum] == true) {
			return true;
		}

		if (ar[n - 1] <= sum) {
			return dp[n][sum] = solve(ar, sum - ar[n - 1], n - 1) || solve(ar, sum, n - 1);
		} else {
			return dp[n][sum] = solve(ar, sum, n - 1);
		}
	}

	// from memo, change n to i and sum to j
	public boolean solveWithDp(int[] ar, int sum, int n) {
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < sum + 1; j++) {
				if (ar[i - 1] <= j) {
					dp[i][j] = dp[i - 1][j - ar[i - 1]] || dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[n][sum];
	}

	public int totalSubsets(int ar[], int sum, int n) {
		for (int i = 1; i < n +1; i++) {
			for (int j = 1; j < sum + 1; j++) {
				if (ar[i - 1] <= j) {
					t[i][j] = t[i - 1][j - ar[i - 1]] + t[i - 1][j];
				} else {
					t[i][j] = t[i - 1][j];
				}
			}
		}
		return t[n][sum];
	}

	public static void main(String[] args) {
		int[] ar = { 1, 2, 3, 4 };
		int sum = 3;
		dp = new boolean[ar.length + 1][sum + 1];
		t = new int[ar.length + 1][sum + 1];
		for (int i = 0; i < ar.length + 1; i++) {
			for (int j = 0; j < sum + 1; j++) {
				if (i == 0 && j == 0) {
					dp[i][j] = true;
					t[i][j] = 1;
				}

				else if (j == 0) {
					dp[i][j] = true;
					t[i][j] = 1;
				} else {
					dp[i][j] = false;
					t[i][j] = 0;
				}
			}
		}

		SubsetSum ob = new SubsetSum();
//		System.out.println(ob.solve(ar, sum, ar.length));
//		System.out.println(ob.solveWithMemo(ar, sum, ar.length));

		System.out.println(ob.solveWithDp(ar, sum, ar.length));
		for (int i = 0; i < ar.length + 1; i++) {
			for (int j = 0; j < sum + 1; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
//		System.out.println("dp:" + (System.nanoTime() - start));

		System.out.println(ob.totalSubsets(ar, sum, ar.length));

	}

}
