package amazon.LCS;

import java.util.ArrayList;
import java.util.List;

public class LongestCommonSubsequence {

	static List<List<Integer>> graph = new ArrayList<>();

	public int findLCSWithRecursion(String x, String y, int m, int n) {
		// Base condition
		if (m == 0 || n == 0) {
			return 0;
		}

		// we start from end and check if characters are matching, then reduce the size
		// of input and check for the next reduced input
		if (x.charAt(m - 1) == y.charAt(n - 1)) {
			return 1 + findLCSWithRecursion(x, y, m - 1, n - 1);
		} else {
			return Math.max(findLCSWithRecursion(x, y, m, n - 1), findLCSWithRecursion(x, y, m - 1, n));
		}
	}

	public int findLCSwithDPMemo(String x, String y, int m, int n) {
		// Base condition
		if (m == 0 || n == 0) {
			return 0;
		}
		// Check for the m and n if result already calculated
		if (graph.get(m).get(n) != -1) {
			return graph.get(m).get(n);
		}
		if (x.charAt(m - 1) == y.charAt(n - 1)) {
			graph.get(m).add(n, 1 + findLCSWithRecursion(x, y, m - 1, n - 1));
			return graph.get(m).get(n);
		} else {
			graph.get(m).add(n, Math.max(findLCSWithRecursion(x, y, m, n - 1), findLCSWithRecursion(x, y, m - 1, n)));
			return graph.get(m).get(n);
		}
	}

	public int lcsWithDp(String x, String y, int m, int n) {

		// base condition will become init in this, 1st row and col are 0.
		int[][] t = new int[m + 1][n + 1];

		for (int i = 1; i < m + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				if (x.charAt(i - 1) == y.charAt(j - 1)) {
					t[i][j] = t[i - 1][j - 1] + 1;
				} else {
					t[i][j] = Math.max(t[i][j - 1], t[i - 1][j]);
				}
			}
		}
		for (int i = 1; i < m + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				System.out.print(t[i][j] + " ");
			}
			System.out.println();
		}
		return t[m][n];
	}

	public int longestCommonSubString(String x, String y, int m, int n) {

		// basically a variant of LCS
		int max = 0;
		int[][] t = new int[m + 1][n + 1];
		for (int i = 1; i < m + 1; i++) {
			for (int j = i + 1; j < n + 1; j++) {
				if (x.charAt(i - 1) == y.charAt(j - 1)) {
					t[i][j] = t[i - 1][j - 1] + 1;
					if (t[i][j] > max) {
						max = t[i][j];
					}
				} else {
					// different from above, since the logic is when a subtring breaks we init the
					// length to 0 and begin for the next ss
					t[i][j] = 0;
				}
			}
		}
		for (int i = 1; i < m + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				System.out.print(t[i][j] + " ");
			}
			System.out.println();
		}
		return max;

	}

	// This is also a variant of LCS, only 1 string is given, we can reverse the
	// string and take it as 2nd string and apply LCS
	public int maxPallindromicSubSequence(String x) {
		String y = "";
		for (int i = x.length() - 1; i >= 0; i--) {
			y += x.charAt(i);
		}
		return lcsWithDp(x, y, x.length(), y.length());
	}

	// Idea is if we reverse the string and find out the max pallindromic
	// subsequence, the no. of deletion will be minimum, so we use this approach
	public int minDeletionForPallindrome(String x) {
		return x.length() - maxPallindromicSubSequence(x);
	}

	public static void main(String[] args) {
		LongestCommonSubsequence ob = new LongestCommonSubsequence();
		String x = "ABC";
		String y = "ABC ";
		// here
		for (int i = 0; i <= x.length(); i++) {
			List<Integer> temp = new ArrayList<>();
			for (int j = 0; j <= y.length(); j++) {
				temp.add(-1);
			}
			graph.add(temp);
		}
//		System.out.println(ob.findLCSwithDPMemo(x, y, x.length(), y.length()));

//		System.out.println(ob.findLCSWithRecursion(x, y, x.length(), y.length()));

//		System.out.println(ob.lcsWithDp(x, y, x.length(), y.length()));

//		System.out.println(ob.longestCommonSubString(x, y, x.length(), y.length()));

		String pall = "abbacdba";
//		System.out.println(ob.maxPallindromicSubSequence(pall));

//		String minDeletion = "abcdba";
//		System.out.println(ob.minDeletionForPallindrome(minDeletion));
	}

}
