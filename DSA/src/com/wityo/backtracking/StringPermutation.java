package com.wityo.backtracking;

public class StringPermutation {

	public void stringPermutation(String s) {
		int count[] = new int[s.length()];
		for (int i = 0; i < count.length; i++) {
			count[i] = 1;
		}
		stringPermutation(s, 0, new char[s.length()], count);
	}

	public void stringPermutation(String word, int level, char[] result, int[] count) {
		if (level == word.length()) {
			System.out.println(String.valueOf(result));
			return;
		}
		for (int i = 0; i < word.length(); i++) {
			if (count[i] == 0)
				continue;
			count[i]--;
			result[level] = word.charAt(i);
			stringPermutation(word, level + 1, result, count);
			count[i]++;
		}
	}

	public static void main(String[] args) {
		new StringPermutation().stringPermutation("abc");
	}

}
