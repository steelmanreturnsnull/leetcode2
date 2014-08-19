package leetcode.word;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
 * Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such
 * that:
 * 
 * Only one letter can be changed at a time Each intermediate word must exist in the dictionary For example,
 * 
 * Given: start = "hit" end = "cog" dict = ["hot","dot","dog","lot","log"]
 * 
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog", return its length 5.
 * 
 */
public class WordLadder {

	// O(26^length) + O(dict), // O(26^l) space
	public int ladderLength(String start, String end, Set<String> dict) {

		LinkedList<String> start_word_queue = new LinkedList<>();
		LinkedList<String> end_word_queue = new LinkedList<>();
		Map<String, Integer> start_visited = new HashMap<>();
		Map<String, Integer> end_visited = new HashMap<>();

		start_word_queue.add(start);
		start_visited.put(start, 1);
		end_word_queue.add(end);
		end_visited.put(end, 1);

		while (!start_word_queue.isEmpty() && !end_word_queue.isEmpty()) {
			String start_word = start_word_queue.pop();
			int start_distance = start_visited.get(start_word);

			for (int i = 0; i < start_word.length(); i++) {
				char[] chars = start_word.toCharArray();
				for (char c = 'a'; c <= 'z'; c++) {
					chars[i] = c;
					String new_word = new String(chars);
					if (end_visited.containsKey(new_word)) {
						return start_distance + end_visited.get(new_word);
					}
					if (!start_visited.containsKey(new_word) && dict.contains(new_word)) {
						start_word_queue.add(new_word);
						start_visited.put(new_word, start_distance + 1);
					}
				}
			}

			String end_word = end_word_queue.pop();
			int end_distance = end_visited.get(end_word);

			for (int i = 0; i < end_word.length(); i++) {
				char[] chars = end_word.toCharArray();
				for (char c = 'a'; c <= 'z'; c++) {
					chars[i] = c;
					String new_word = new String(chars);
					if (start_visited.containsKey(new_word)) {
						return end_distance + start_visited.get(new_word);
					}
					if (!end_visited.containsKey(new_word) && dict.contains(new_word)) {
						end_word_queue.add(new_word);
						end_visited.put(new_word, end_distance + 1);
					}
				}
			}

		}

		return 0;

	}

	public int ladderLengthII(String start, String end, Set<String> dict) {

		if (start.equals(end))
			return 2;

		LinkedList<String> word_queue = new LinkedList<>();
		LinkedList<Integer> distance_queue = new LinkedList<>();
		Set<String> visited = new HashSet<>();
		word_queue.add(start);
		distance_queue.add(1);
		visited.add(start);

		while (!word_queue.isEmpty()) {
			String word = word_queue.pop();
			int distance = distance_queue.pop();

			if (word.equals(end))
				return distance;

			for (int i = 0; i < word.length(); i++) {
				char[] chars = word.toCharArray();
				for (char c = 'a'; c <= 'z'; c++) {
					chars[i] = c;
					String newString = String.valueOf(chars);
					if (newString.equals(end) || dict.contains(newString) && !visited.contains(newString)) {
						word_queue.add(newString);
						distance_queue.add(distance + 1);
						visited.add(newString);
					}

				}
			}
		}
		return 0;
	}

}
