package amazon;

import java.util.HashSet;
import java.util.Set;

public class LongestPallindromicSubstring {

	Set<String> result = new HashSet<>();
	public int pallindrome(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		} else if (s.length() == 1) {
			return 1;

		} else if (s.length() == 2) {
			if (s.charAt(0) == s.charAt(1)) {
				return 2;
			} else {
				return 1;
			}
		} else {
			int start = 0;
			int end = 0;
			for (int i = 0; i < s.length(); i++) {
				int l1 = expandMid(s, i, i);
				int l2 = expandMid(s, i, i + 1);
				int len = Math.max(l1, l2);
				if (len > end - start) {
					start = i - ((len - 1) / 2);
					end = i + len / 2;
				}
			}
			return s.substring(start, end+1).length();
		}
	}

	public int expandMid(String s, int left, int right) {
		if (s == null || left > right) {
			return 0;
		}
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		return right - left - 1;
	}
	
	public static void main(String[] args) {
		LongestPallindromicSubstring ob = new LongestPallindromicSubstring();
		System.out.println(ob.pallindrome("abcddcbabcdcdaadcdcbabcdddcb"));
	}

}
