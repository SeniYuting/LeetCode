package leetcode.string;

public class LongestPalindromicSubstring {

    // 动态规划
    public static String longestPalindrome(String s) {
        int n = s.length();

        boolean table[][] = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            table[i][i] = true;
        }

        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                table[i][i + 1] = true;
            }
        }

        for (int i = 1; i < n - 3; i++) {
            for (int j = i + 2; j < n; j++) {
                table[i][j] = table[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
            }
        }

        int begin = 0, end = 0, max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (table[i][j]) {
                    if (j - i > max) {
                        max = j - i;
                        begin = i;
                        end = j;
                    }
                }
            }
        }

        return s.substring(begin, end + 1);
    }

    public static void main(String[] args) {
        String s = "babadabba";
        String sub = longestPalindrome(s);
        System.out.println(sub);
    }

}
