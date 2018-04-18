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
public class Main2_2 {
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

        combination(n2Nums);

        int nMod = 1;
        for (int i = 0; i < 9; i++) {
            nMod *= 10;
        }
        nMod += 7;
        System.out.println(sum % nMod);
    }

    // 非递归
    public static void combination(int[] arr) {
        int len = arr.length;
        int[] used = new int[len];

        while (true) {
            int index = 0;
            // 把连续的1换为0，后面补1
            // 若used[index]为0，则变为1
            while (used[index] == 1) {
                used[index] = 0;
                if (++index == len) { // 全0
                    sum += change(n1Nums, m);
                    return;
                }
            }
            used[index] = 1;

            // 不全0
            int all = 0;
            for (int i = 0; i < len; i++) {
                if (used[i] == 1) {
                    all += arr[i];
                }
            }
            sum += change(n1Nums, m - all);
        }
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
