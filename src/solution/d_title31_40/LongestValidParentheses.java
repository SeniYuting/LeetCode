package solution.d_title31_40;

/**
 * Given a string containing just the characters '(' and ')',
 * find the length of the longest valid (well-formed) parentheses substring.
 * <p>
 * 好题~
 * <p>
 * 思路：动态规划
 * 合适的子串必须以"）"结尾
 * （1）若s[i]=")" && s[i-1]="("，则：dp[i] = dp[i-2] + 2，即：最后能配对，
 * 则为"（）"加上前一个合适的配对
 * （2）若s[i]=")" && s[i-1]=")"，则：dp[i] = dp[i-1] + dp[i-dp[i-1]-2] + 2，
 * 即：为前一个")"的配对加上前一个合适的配对，而且最后的")"在前面要有合适的"("配对
 */
public class LongestValidParentheses {

    public static int longestValidParentheses(String s) {

        int max = 0;
        int[] dp = new int[s.length()];

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1] >= 2) ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("(()"));
        System.out.println(longestValidParentheses(")()())"));
    }

}
