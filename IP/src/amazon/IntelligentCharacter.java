package amazon;

import java.util.HashMap;
import java.util.Map;

public class IntelligentCharacter {

	public int findMaxSubstring(String s, int k, String charValue) {
		Map<Character, Integer> norm = new HashMap<Character, Integer>();
		char ch = 'a';
		for (int i = 0; i < charValue.length(); i++) {
			norm.put(ch, Character.getNumericValue(charValue.charAt(i)));
			ch++;
		}

		int max = 0;
		int currentNormalCount = 0;
		for (int i = 0; i < s.length(); i++) {
			currentNormalCount = 0; // 1 2
			String temp = "";

			for (int j = i; j < s.length(); j++) {
				ch = s.charAt(j);
				if (norm.get(ch) == 0) {
					currentNormalCount++;
					if (currentNormalCount > k) {
						break;
					}
				}
				temp = temp + ch;
				if (temp.length() > max) {
					max = temp.length();
				}
				System.out.println(temp);

			}
		}
		return max;
	}

	public static void main(String[] args) {
		String s = "giraffe";
		String charCount = "a111101111111111011111111";
		IntelligentCharacter ob = new IntelligentCharacter();
		System.out.println(ob.findMaxSubstring(s, 2, charCount));
	}

}
