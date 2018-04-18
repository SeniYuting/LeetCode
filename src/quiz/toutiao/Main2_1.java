package quiz.toutiao;

import java.util.Scanner;

/**
 * 输入：
 * 3 1 5
 * 1 2 3
 * 1
 * 输出：
 * 9
 */
public class Main2_1 {
    private static int sum = 0;
    public static int m = 0;
    private static int[] n1Nums;
    private static int[] n2Nums;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n1 = in.nextInt();
        int n2 = in.nextInt();
        m = in.nextInt();

        n1Nums = new int[n1];
        n2Nums = new int[n2];

        for (int i = 0; i < n1; i++) {
            n1Nums[i] = in.nextInt();
        }

        for (int i = 0; i < n2; i++) {
            n2Nums[i] = in.nextInt();
        }

        for (int i = 0; i <= n2; i++) {
            combination(0, i, 0);
        }

        int nMod = 1;
        for (int i = 0; i < 9; i++) {
            nMod *= 10;
        }
        nMod += 7;
        System.out.println(sum % nMod);
    }

    // 递归
    private static void combination(int index, int size, int all) {
        if (size == 0) {
            sum += change(n1Nums, m - all);
            return;
        }

        if (index == n2Nums.length) {
            return;
        }

        all += n2Nums[index];
        combination(index + 1, size - 1, all);
        all -= n2Nums[index];
        combination(index + 1, size, all);
    }

    // 动态规划
    private static int change(int arr[], int money) {
        int length = arr.length;

        int[][] dp = new int[length][money + 1];
        for (int i = 0; i < length; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i * arr[0] <= money; i++) {
            dp[0][i * arr[0]] = 1;
        }

        for (int i = 1; i < length; i++) {
            for (int j = 1; j <= money; j++) {
                for (int k = 0; k * arr[i] <= j; k++) {
                    dp[i][j] += dp[i - 1][j - k * arr[i]];
                }
            }
        }

        return dp[length - 1][money];
    }
}
