package review.dp;

/**
 * 给定数组 arr，arr 中所有的值都为正数且不重复。每个值代表一种面值的货币，
 * 每种面值的货币都可以使用任意张，再给定一个整数 aim 代表要找的钱数，求换钱有多少种方法。
 */
// http://www.cnblogs.com/zhengbin/p/7476713.html

/**
 * 如果 arr 长度为 N，则生成行数为 N，列数为 money + 1 的矩阵 dp
 * dp[i][j] 表示在使用 arr[0...i] 货币的情况下，组成钱数 j 需要 dp[i][j] 种方法
 * dp[i][j] = dp[i-1][j] + dp[i-1][j-1*arr[i]] + dp[i-1][j-2*arr[i]] + ... + dp[i-1][j-k*arr[i]]
 */
public class ChangeMoney {

    // 动态规划
    static int change(int arr[], int money) {
        int len = arr.length;

        int[][] dpArr = new int[len][money + 1];

        for (int i = 1; i * arr[0] <= money; i++) {
            dpArr[0][i * arr[0]] = 1;
        }

        for (int i = 0; i < len; i++) {
            dpArr[i][0] = 1;
        }

        for (int i = 1; i < len; i++) {
            for (int j = 1; j <= money; j++) {
                for (int k = 0; k * arr[i] <= j; k++) {
                    dpArr[i][j] += dpArr[i - 1][j - k * arr[i]];
                }
            }
        }

        return dpArr[len - 1][money];
    }

    public static void main(String[] args) {
        int arr[] = {5, 10, 25, 1};
        int money = 100;
        System.out.println(change(arr, money));
    }
}
