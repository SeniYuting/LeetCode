package quiz.paypal;

import java.util.Scanner;

// 三种情况，每种是另外两种数量之和
// 动态规划，相邻颜色不同，收尾颜色不同，一共三种颜色
public class Main2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();

        int result;
        if (num == 0) {
            result = 0;
        } else if (num == 1) {
            result = 3;
        } else {
            int[][] temp = new int[num][3];
            temp[0][0] = 1;
            temp[0][1] = 0;
            temp[0][2] = 0;

            for (int i = 1; i < num; i++) {
                temp[i][0] += temp[i - 1][1] + temp[i - 1][2];
                temp[i][1] += temp[i - 1][0] + temp[i - 1][2];
                temp[i][2] += temp[i - 1][0] + temp[i - 1][1];
            }

            result = (temp[num - 1][1] + temp[num - 1][2]) * 3;
        }

        System.out.println(result);
    }

}
