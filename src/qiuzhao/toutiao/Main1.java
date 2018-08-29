package qiuzhao.toutiao;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 好题~
 * <p>
 * 类似Leetcode 547
 * 输入：
 * 10
 * 0
 * 5 3 0
 * 8 4 0
 * 9 0
 * 9 0
 * 3 0
 * 0
 * 7 9 0
 * 0
 * 9 7 0
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = Integer.parseInt(sc.nextLine());
        int[][] map = new int[num][num];

        for (int i = 0; i < num; i++) {
            map[i][i] = 1;
            String str = sc.nextLine();
            String[] splitStr = str.split(" ");
            for (int j = 0; j < splitStr.length - 1; j++) {
                int n = Integer.parseInt(splitStr[j]) - 1;
                map[i][n] = 1;
                map[n][i] = 1;
            }
        }

//        for (int i = 0; i < num; i++) {
//            for (int j = 0; j < num; j++) {
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }

        System.out.println(findCircleNum(map));
    }

    // 深度优先遍历
    public static void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }

    // 广度优先遍历
    static Queue<Integer> q = new LinkedList<>();

    public static void bfs(int[][] M, int[] visited, int i) {
        // visit[i];
        q.offer(i);
        visited[i] = 1;
        while (!q.isEmpty()) {
            int node = q.poll();
            for (int j = 0; j < M.length; j++) {
                // 未被访问过且是邻接点,注意是node的邻接点
                if (visited[j] == 0 && M[node][j] == 1) {
                    q.offer(j);
                    visited[j] = 1;
                }
            }
        }

    }

    // DFS和BFS时间复杂度相同
    // 使用邻接矩阵存储图：O(n*n)：查找临接矩阵中的邻接顶点
    // 使用邻接表存储图：O(n+e)

    public static int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
//                dfs(M, visited, i);
                bfs(M, visited, i);
                count++;
            }
        }
        return count;
    }
}
