package com.wityo.dynamicprogramming.longestcommonsubsequence;

public class LongestCommonSubsequence {

	public int lcs(char[] a, char[] b) {
		int m = a.length + 1;
		int n = b.length + 1;
		int LCS[][] = new int[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 || j == 0) {
					LCS[i][j] = 0;
				} else if (a[i - 1] == b[j - 1]) {
					LCS[i][j] = 1 + LCS[i - 1][j - 1];
					System.out.print(a[i - 1]);
				} else {
					LCS[i][j] = Math.max(LCS[i - 1][j], LCS[i][j - 1]);
				}
			}
		}

		return LCS[m - 1][n - 1];
	}

	public static void main(String[] args) {
		String s1 = "abd";
		String s2 = "abd";
		System.out.println(new LongestCommonSubsequence().lcs(s1.toCharArray(), s2.toCharArray()));
	}

}
