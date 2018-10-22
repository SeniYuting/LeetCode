package qiuzhao.splunk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] line = sc.nextLine().split(" ");
        int peopleNum = Integer.parseInt(line[0]);
        int relNum = Integer.parseInt(line[1]);

        int[][] map = new int[peopleNum][peopleNum];
        for (int i = 0; i < peopleNum; i++) {
            map[i][i] = 1;
        }

        for (int i = 0; i < relNum; i++) {
            String[] splitStr = sc.nextLine().split(" ");
            map[Integer.parseInt(splitStr[0])][Integer.parseInt(splitStr[1])] = 1;
            map[Integer.parseInt(splitStr[1])][Integer.parseInt(splitStr[0])] = 1;
        }

        for (int i = 0; i < peopleNum; i++) {
            for (int j = 0; j < peopleNum; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println(findCircleNum(map));
        System.out.println(findCircleNum(map) > 2 ? "NO" : "YES");
    }

    public static void dfs(int[][] M, int[] visited, int i, List<Integer> rel) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 0 && visited[j] == 0) {
                boolean isOK = true;
                for (Integer index : rel) {
                    if (M[index][j] == 1 || M[j][index] == 1) {
                        isOK = false;
                        break;
                    }
                }
                if (isOK) {
                    visited[j] = 1;
                    rel.add(j);
                    dfs(M, visited, j, rel);
                }
            }
        }
    }

    public static int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                List<Integer> rel = new ArrayList<Integer>();
                rel.add(i);
                dfs(M, visited, i, rel);
                count++;
            }
        }
        return count;
    }
}
