package solution.g_title61_70;

/**
 * UniquePaths题目增加障碍物二维数组
 * <p>
 * 思路：同UniquePaths题目，只是到障碍物点的dp[i][j]=0
 * 另外：0行0列一旦碰到障碍物，后面均为0
 */
public class UniquePathsTwo {
    public static void main(String[] args) {
        int[][] obstacleGrid1 = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid1)); // 2

        int[][] obstacleGrid2 = {{1, 0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid2)); // 0
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null) {
            return 0;
        }

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if (n == 0 || obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }

        int[][] result = new int[m][n];
        result[0][0] = 1;

        for (int j = 1; j < n; j++) {
            if (obstacleGrid[0][j] == 1) {
                result[0][j] = 0;
            } else {
                result[0][j] = result[0][j - 1];
            }
        }

        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                result[i][0] = 0;
            } else {
                result[i][0] = result[i - 1][0];
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    result[i][j] = 0;
                } else {
                    result[i][j] = result[i - 1][j] + result[i][j - 1];
                }
            }
        }

        return result[m - 1][n - 1];
    }
}
