package solution.a_title1_10;

/**
 * '.' Matches any single character. '*' Matches zero or more of the preceding
 * element.
 *
 */
public class RegularExpressionMatching {

	public static boolean isMatch(String s, String p) {

		if (p.isEmpty()) {
			return s.isEmpty();
		}

		// 初始条件
		boolean firstMatch = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');

		if (p.length() >= 2 && p.charAt(1) == '*') {
			return isMatch(s, p.substring(2)) || (firstMatch && isMatch(s.substring(1), p));
		} else {
			return firstMatch && isMatch(s.substring(1), p.substring(1));
		}
	}

	public static void main(String[] args) {
		System.out.println(isMatch("aa", "a")); // false
		System.out.println(isMatch("aa", "aa")); // true
		System.out.println(isMatch("aaa", "aa")); // false
		System.out.println(isMatch("aa", "a*")); // true
		System.out.println(isMatch("aa", ".*")); // true
		System.out.println(isMatch("ab", ".*")); // true
		System.out.println(isMatch("aab", "c*a*b")); // true
		System.out.println(isMatch("aaa", "aaaa")); // false
	}

}
