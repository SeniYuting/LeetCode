package qiuzhao.toutiao.second;

// 80%
/**
 * 思路：起始：group[][]空二维数组，将相应位为1的设置为groupNum
 * 一层一层遍历，每一层仅向下、向左、向右遍历
 * <p>
 * 输入：
 * 4
 * 1 0 0 0
 * 0 0 0 0
 * 0 0 0 1
 * 0 0 0 0
 */

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = Integer.valueOf(sc.nextLine());

        String[][] group = new String[m][m];

        for (int i = 0; i < m; i++) {
            group[i] = sc.nextLine().split(" ");
        }

        int[][] groupSet = new int[m][m];
        int groupNum = 0;

        for (int j = 0; j < m; j++) {
            for (int k = 0; k < m; k++) {
                if (groupSet[j][k] == 0) {
                    String s = group[j][k];
                    if (s.equals("1")) {
                        groupNum++;
                        makeSet(groupSet, group, groupNum, j, k, m);
                    }
                }
            }
        }

        System.out.println(groupNum);
    }

    private static void makeSet(int[][] groupSet, String[][] group, int groupNum, int j, int k, int m) {
        if (j < 0 || j >= m || k < 0 || k >= m) {
            return;
        }
        if (groupSet[j][k] == 0) {
            if (group[j][k].equals("1")) {
                groupSet[j][k] = groupNum;
                // 向下，向左，向右扩展
                makeSet(groupSet, group, groupNum, j, k + 1, m);  // 向右
                makeSet(groupSet, group, groupNum, j, k - 1, m);  // 向左
                makeSet(groupSet, group, groupNum, j + 1, k, m);  // 向下
            }
        }
    }
}


