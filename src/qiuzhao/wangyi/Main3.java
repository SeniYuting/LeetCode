package qiuzhao.wangyi;

// 100%

/**
 * 输入：
 * 5
 * 1 21 168 110
 * 2 24 170 120
 * 3 26 170 130
 * 4 22 173 120
 * 5 23 180 130
 */

import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        int[][] tb_user_info = new int[n][4];
        for (int i = 0; i < n; i++) {
            String[] line = sc.nextLine().split(" ");
            for (int j = 0; j < 4; j++) {
                tb_user_info[i][j] = Integer.parseInt(line[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            double minDis = Integer.MAX_VALUE;
            int minIndex = 0;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    double dis = Math.sqrt(Math.pow(tb_user_info[i][1] - tb_user_info[j][1], 2)
                            + Math.pow(tb_user_info[i][2] - tb_user_info[j][2], 2)
                            + Math.pow(tb_user_info[i][3] - tb_user_info[j][3], 2));
                    if (dis < minDis) {
                        minDis = dis;
                        minIndex = j;
                    }
                }
            }
            if (minDis < 20) {
                System.out.println(String.format("%s %s %.2f", tb_user_info[i][0], tb_user_info[minIndex][0], minDis));
            }
        }

    }
}
