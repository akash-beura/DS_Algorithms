package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*Given a list of reviews, a list of keywords and an integer k. Find the most popular k keywords in order of most to least frequently mentioned.

The comparison of strings is case-insensitive.
Multiple occurances of a keyword in a review should be considred as a single mention.
If keywords are mentioned an equal number of times in reviews, sort alphabetically.

Example 1:

Input:
k = 2
keywords = ["anacell", "cetracular", "betacellular"]
reviews = [
  "Anacell provides the best services in the city",
  "betacellular has awesome services",
  "Best services provided by anacell, everyone should use anacell",
]

Output:
["anacell", "betacellular"]

Explanation:
"anacell" is occuring in 2 different reviews and "betacellular" is only occuring in 1 review.



*
*
*/

public class TopKKeywords {

	public static List<String> topKKeywords(List<String> keywords, List<String> reviews, int k) {
		// 1. Create a HashMap
		Map<String, Integer> topKeywords = new HashMap<>();

		// store the keywork count of each keyword given in the
		for (String keyword : keywords) {
			for (String review : reviews) {
				if (review.toLowerCase().contains(keyword.toLowerCase())) {
					topKeywords.put(keyword, topKeywords.getOrDefault(keyword, 0) + 1);
				}
			}
			if (!topKeywords.containsKey(keyword)) {
				topKeywords.put(keyword, 0);
			}
		}
		List<Map.Entry<String, Integer>> entriesList = new ArrayList<>(topKeywords.entrySet());
		Collections.sort(entriesList, (o1, o2) -> {
			int result = o2.getValue() - o1.getValue();
			if (result == 0) {
				return o1.getKey().compareTo(o2.getKey());
			}
			return result;
		});

		List<String> result = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			result.add(entriesList.get(i).getKey());
		}
		return result;

	}

	public static void main(String[] args) {

		String[] keywords = { "anacell", "betacellular", "cetracular", "deltacellular", "eurocell" };
		String[] reviews = { 
				"I love anacell Best services; Best services provided by anacell",
				"betacellular has great services",
				"deltacellular provides much better services than betacellular",
				"cetracular is worse than anacell",
				"Betacellular is better than deltacellular.", };

		System.out.println("Answer: " + topKKeywords(Arrays.asList(keywords), Arrays.asList(reviews), 2));
	}

}
