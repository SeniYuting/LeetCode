package solution.g_title61_70;

/**
 * 找从左上角到右下角的最小路径和
 * <p>
 * 思路：动态规划
 * dp[i][j] = min(dp[i-1][j], dp[i][j-1]) + grid[i][j]
 */
public class MinimumPathSum {
    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int result = minPathSum(grid);
        System.out.println(result);
    }

    public static int minPathSum(int[][] grid) {
        int dp[][] = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            dp[i][0] = (i >= 1 ? dp[i - 1][0] : 0) + grid[i][0];
        }

        for (int j = 0; j < grid[0].length; j++) {
            dp[0][j] = (j >= 1 ? dp[0][j - 1] : 0) + grid[0][j];
        }

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[grid.length - 1][grid[0].length - 1];
    }
}
