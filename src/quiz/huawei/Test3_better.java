package quiz.huawei;

import java.util.Scanner;

/**
 * 背包问题
 * 测试：
 * 背包大小、花费、收益
 *
 * 输入：
 * 40
 * 12 13 23 36
 * 11 11 20 30
 * 输出：
 * 1 3
 */
public class Test3_better {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int all = Integer.parseInt(sc.nextLine());
        String cost = sc.nextLine();
        String reward = sc.nextLine();

        String[] costs = cost.split(" ");
        String[] rewards = reward.split(" ");

        int[] costsInt = new int[costs.length + 1];
        int[] rewardsInt = new int[rewards.length + 1];
        for (int i = 1; i <= costs.length; i++) {
            costsInt[i] = Integer.parseInt(costs[i - 1]);
            rewardsInt[i] = Integer.parseInt(rewards[i - 1]);
        }

        int[][] m = new int[costsInt.length + 1][all + 1];
        for (int i = 1; i <= costs.length; i++) {
            for (int j = 1; j <= all; j++) {
                if (j >= costsInt[i])
                    m[i][j] = Math.max(m[i - 1][j], m[i - 1][j - costsInt[i]] + rewardsInt[i]);
                else
                    m[i][j] = m[i - 1][j];
            }
        }

        int[] result = new int[costsInt.length + 1];
        result[1] = (m[1][all] > 0) ? 1 : 0;
        for (int i = costs.length; i > 1; i--) {
            if (m[i][all] == m[i - 1][all])
                result[i] = 0;
            else {
                result[i] = 1;
                all -= costsInt[i];
            }
        }

        StringBuilder s = new StringBuilder();
        for (int i = 1; i < result.length; i++) {
            if (result[i] == 1) {
                s.append(i).append(" ");
            }
        }

        System.out.println(s.toString().trim());
    }


}
