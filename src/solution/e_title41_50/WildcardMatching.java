package solution.e_title41_50;

/**
 * Implement wildcard pattern matching with support for '?' and '*'.
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * 题目类似第10题
 * 思路：动态规划
 * （1）若：s[i]==p[j] || p[j]='?'，则：F[i,j]=F[i-1,j-1]
 * (2) 若：p[j]='*'，则：F[i][j]=F[i-1][j] || F[i][j-1]
 * 考虑p开头的*，加一行一列
 */
public class WildcardMatching {

    public static boolean isMatch(String s, String p) {

        int sLen = s.length(), pLen = p.length();
        boolean[][] result = new boolean[sLen + 1][pLen + 1];

        result[0][0] = true;
        for (int j = 1; j <= pLen; j++) {
            result[0][j] = result[0][j - 1] && p.charAt(j - 1) == '*';
        }

        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= pLen; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    result[i][j] = result[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    result[i][j] = result[i - 1][j] || result[i][j - 1];
                }
            }
        }

        return result[sLen][pLen];

    }

    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a")); // false
        System.out.println(isMatch("aa", "aa")); // true
        System.out.println(isMatch("aaa", "aa")); // false
        System.out.println(isMatch("aa", "*")); // true
        System.out.println(isMatch("aa", "a*")); // true
        System.out.println(isMatch("ab", "?*")); // true
        System.out.println(isMatch("aab", "c*a*b")); // false
        System.out.println(isMatch("aaa", "aaaa")); // false
    }

}
