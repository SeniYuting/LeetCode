package niuke.meituan;

// 网格走法数目
// https://www.nowcoder.com/practice/e27b9fc9c0ec4a17a5064fb6f5ab13e4?tpId=85&tqId=29883&tPage=1&rp=1&ru=/ta/2017test&qru=/ta/2017test/question-ranking

// 动态规划

import java.util.Scanner;

public class Grid {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int row = in.nextInt();
        int column = in.nextInt();
        int[][] arr = new int[row + 1][column + 1];

        for (int i = 0; i <= row; i++) {
            arr[i][0] = 1;
        }

        for (int j = 0; j <= column; j++) {
            arr[0][j] = 1;
        }

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
            }
        }

        System.out.println(arr[row][column]);
    }
}
