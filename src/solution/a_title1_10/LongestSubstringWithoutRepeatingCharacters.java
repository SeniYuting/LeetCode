package solution.a_title1_10;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * Given a string, find the length of the longest substring without repeating
 * characters. 好题~
 * 
 * Example: Given "pwwkew", the answer is "wke"
 *
 */
public class LongestSubstringWithoutRepeatingCharacters {

	// Time Limit Exceeded
	public static int myLengthOfLongestSubstringTry(String s) {
		int length = 0;

		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 1; j <= s.length(); j++) {
				if (allUnique(s, i, j)) {
					length = Math.max(length, j - i);
				}
			}
		}

		return length;
	}

	public static boolean allUnique(String s, int start, int end) {

		Set<Character> set = new HashSet<>();

		for (int i = start; i < end; i++) {
			char c = s.charAt(i);
			if (set.contains(c)) {
				return false;
			}
			set.add(c);
		}

		return true;
	}

	// Accepted
	public static int myLengthOfLongestSubstring(String s) {
		int length = 0, i = 0, j = 0;

		Set<Character> set = new HashSet<>(); // 注意，如果是List，则下面remove只删除第一个重复

		while (i < s.length() && j < s.length()) {
			// extend range [i, j] (滑动窗口)
			if (!set.contains(s.charAt(j))) {
				set.add(s.charAt(j++));
				length = Math.max(length, j - i);
			} else {
				set.remove(s.charAt(i++));
			}
		}

		return length;
	}

	public static void main(String[] args) {
		String s = "pwwkew";
		// int length = myLengthOfLongestSubstringTry(s);
		int length = myLengthOfLongestSubstring(s);
		System.out.println(length);
	}

}
