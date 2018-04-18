package solution.a_title1_10;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume
 * that the maximum length of s is 1000. 最长回文子串问题 动态规划求解，时间复杂度O(n^2) 好题~
 *
 *  table[i][j]表示从i->j构成回文子串
 */
public class LongestPalindromicSubstring {

	public static String longestPalindrome(String s) {

		int n = s.length();
		int subStrBegin = 0;
		int subStrLength = 1;

		boolean[][] table = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			table[i][i] = true;
		}

		for (int i = 0; i < n - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				table[i][i + 1] = true;
				subStrBegin = i;
				subStrLength = 2;
			}
		}

		for (int len = 3; len <= n; len++) {
			for (int i = 0; i < n - len + 1; i++) {
				int j = i + len - 1;
				if (s.charAt(i) == s.charAt(j) && table[i + 1][j - 1]) {
					table[i][j] = true;
					subStrBegin = i;
					subStrLength = len;
				}
			}
		}

		return s.substring(subStrBegin, subStrBegin + subStrLength);
	}

	public static void main(String[] args) {
		String s = "babad";
		String sub = longestPalindrome(s);
		System.out.println(sub);
	}

}
