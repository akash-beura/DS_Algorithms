package amazon;

import java.util.HashSet;
import java.util.Set;

public class DistinctPallindrome {

	public int distinct(String s) {
		int n = s.length();
		int[][] dp = new int[s.length()][s.length()];
		for (int i = 0; i < n; i++) {
			dp[i][i] = 1;
		}
		Set<String> distinct = new HashSet<String>();
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				int a = j - i;
				int b = j;

				if (i == 0) {
					dp[a][b] = 1;
					distinct.add(s.substring(a, b + 1));
					continue;
				}
				// if 2 characters
				else if (i == 1) {
					if (s.charAt(a) == s.charAt(b)) {
						dp[a][b] = 1;
						distinct.add(s.substring(a, b + 1));
					}
					continue;
				}
				if (s.charAt(a) == s.charAt(b) && dp[a + 1][b - 1] == 1) {
					dp[a][b] = 1;
					distinct.add(s.substring(a, b + 1));
				}
			}
		}
		return distinct.size();

	}

	public static void main(String[] args) {
		System.out.println(new DistinctPallindrome().distinct("abaaaa"));
	}

	// -----------
//	Set<String> distinct = new HashSet<String>();
//	int startIndex = 1;
//	int lastTrueI = 0;
//	int lastTrueJ = 0;
//	while (startIndex != n) {
//		int temp = startIndex;
//		for (int i = 0; i < n && temp < n; i++) {
//			int totalChar = temp - i + 1;
//			if (totalChar < 3) {
//				if (s.charAt(i) == s.charAt(temp)) {
//					dp[i][temp] = 1;
//					distinct.add(s.substring(i, temp + 1));
//				} else {
//					dp[i][temp] = 0;
//				}
//			} else {
//				if (s.charAt(i) == s.charAt(temp) && dp[i + 1][temp - 1] == 1) {
//					dp[i][temp] = 1;
//					distinct.add(s.substring(i, temp + 1));
//				}
//			}
//			if (dp[i][temp] == 1) {
//				lastTrueI = i;
//				lastTrueJ = temp;
//			}
//			temp++;
//		}
//		startIndex++;
//	}
//	System.out.println("Last true index: " + lastTrueI + " " + lastTrueJ);
//	System.out.println("Longest pallindromic substring length: " + (lastTrueJ - lastTrueI + 1));
//	return distinct.size();
	// ===========

}
