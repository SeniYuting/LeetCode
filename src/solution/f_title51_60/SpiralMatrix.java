package solution.f_title51_60;

import java.util.*;

/**
 * 螺旋矩阵
 * 思路：
 * 二维数组有R行C列，当前位置(r,c)，下一位置(cr,cc)
 */
public class SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> answer = new ArrayList<>();
        if (matrix.length == 0) {
            return answer;
        }
        int R = matrix.length, C = matrix[0].length;
        boolean[][] seen = new boolean[R][C];
        int dr[] = {0, 1, 0, -1};
        int dc[] = {1, 0, -1, 0};
        int r = 0, c = 0, di = 0;
        for (int i = 0; i < R * C; i++) {
            answer.add(matrix[r][c]);
            seen[r][c] = true;
            int cr = r + dr[di];
            int cc = c + dc[di];
            if (0 <= cr && cr < R && 0 <= cc && cc < C && !seen[cr][cc]) {
                r = cr;
                c = cc;
            } else {
                di = (di + 1) % 4;
                r += dr[di];
                c += dc[di];
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> list = spiralOrder(matrix);
        for (Integer l : list) {
            System.out.print(l + " ");
        }
    }
}
