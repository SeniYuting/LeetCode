package solution.b_title11_20;

/**
 * Write a function to find the longest common prefix string amongst an array of
 * strings.
 * <p>
 * 分治法求解 Divide and Conquer
 * <p>
 * 好题~
 * <p>
 * // https://leetcode.com/problems/longest-common-prefix/solution/ 解法一
 */

public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        } else {
            return longestCommonPrefix(strs, 0, strs.length - 1);
        }
    }

    public static String longestCommonPrefix(String[] strs, int l, int r) {
        if (l == r) {
            return strs[l];
        } else {
            int mid = (l + r) / 2;
            String lcpLeft = longestCommonPrefix(strs, l, mid);
            String lcpRight = longestCommonPrefix(strs, mid + 1, r);
            return commonPrefix(lcpLeft, lcpRight);
        }
    }

    public static String commonPrefix(String left, String right) {
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            if (left.charAt(i) != right.charAt(i)) {
                return left.substring(0, i);
            }
        }

        return left.substring(0, min);
    }

    public static void main(String[] args) {
        String[] strs = {"leetcode", "leet", "lee", "le"};
        System.out.println(longestCommonPrefix(strs));
    }

}
