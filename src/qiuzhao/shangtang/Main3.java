package qiuzhao.shangtang;

import java.util.Scanner;

/**
 * 求任意起点和终点，单向行走的最长距离
 * <p>
 * 输入：
 * 6
 * -1 2
 * 3 3
 * -2 1
 * -1 1
 * 4 4
 * 1 2
 * <p>
 * 思路：
 * 从任意起点开始：dfs遍历形成sum[]数组，表示距离
 * 再依次求maxSubArray：最大子数组和
 */
public class Main3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = Integer.parseInt(sc.nextLine());
        int[][] map = new int[num][num];

        for (int i = 0; i < num; i++) {
            String str = sc.nextLine();
            String[] splitStr = str.split(" ");
            map[i][Integer.parseInt(splitStr[1]) - 1] = Integer.parseInt(splitStr[0]);
        }

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        System.out.println(findNum(map));

    }

    public static void dfs(int[][] M, int[][] visited, int i, int[] sum, int[] index) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] != 0 && visited[i][j] == 0) {
                visited[i][j] = 1;
                sum[index[0]++] = M[i][j];
                dfs(M, visited, j, sum, index);
            }
        }
    }

    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int sum = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum = Math.max(nums[i], sum + nums[i]);
            max = Math.max(max, sum);
        }
        return max;
    }

    public static int findNum(int[][] M) {
        int max = 0;
        for (int i = 0; i < M.length; i++) {
            int[] sum = new int[M.length];
            int[] index = {0};
            int[][] visited = new int[M.length][M.length];
            dfs(M, visited, i, sum, index);

            for (int i1 = 0; i1 < M.length; i1++) {
                System.out.print(sum[i1] + " ");
            }
            System.out.println();

            int maxSum = maxSubArray(sum);
            if (maxSum > max) {
                max = maxSum;
            }

        }
        return max;
    }
}
