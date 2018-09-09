package qiuzhao.toutiao.second;

// 100%
/**
 * 输入：
 * 3
 * 3
 * 1 2 2 1 2 3
 */

import java.util.Scanner;

public class Main5 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int m = Integer.parseInt(in.nextLine());
        String[] line = in.nextLine().split(" ");

        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            map[i][i] = 1;
        }

        for (int i = 0; i < m; i++) {
            map[Integer.parseInt(line[2 * i]) - 1][Integer.parseInt(line[2 * i + 1]) - 1] = 1;
        }

        findMaxFan(map);

        int count = 0;
        for (int j = 0; j < n; j++) {
            boolean isAllFan = true;
            for (int i = 0; i < n; i++) {
                if (map[i][j] != 1) {
                    isAllFan = false;
                    break;
                }
            }
            if (isAllFan) {
                count++;
            }
        }

        System.out.println(count);
    }

    public static void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }

    public static void findMaxFan(int[][] M) {
        for (int i = 0; i < M.length; i++) {
            int[] visited = new int[M.length];
            if (visited[i] == 0) {
                dfs(M, visited, i);
            }
            for (int k = 0; k < M.length; k++) {
                if (visited[k] == 1) {
                    M[i][k] = 1;
                }
            }
        }
    }
}
