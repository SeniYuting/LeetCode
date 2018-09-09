package solution.g_title61_70;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * m * n的方格，从左上角移动到右下角，仅能向下或者向右，问有多少种不同的走法
 * <p>
 * Example1:
 * Input: m = 3, n = 2
 * Output: 3
 * <p>
 * Example2:
 * Input: m = 7, n = 3
 * Output: 28
 * <p>
 * 动态规划：i行j列
 * dp[i][j] = dp[i-1][j] + dp[i][j-1]
 */
public class UniquePaths {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 2));
        System.out.println(uniquePaths(7, 3));
    }

    public static int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }

        int[][] result = new int[m][n];

        // 只有一行
        for (int j = 0; j < n; j++) {
            result[0][j] = 1;
        }

        // 只有一列
        for (int i = 0; i < m; i++) {
            result[i][0] = 1;
        }

        // other
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                result[i][j] = result[i - 1][j] + result[i][j - 1];
            }
        }

        return result[m - 1][n - 1];
    }
}
