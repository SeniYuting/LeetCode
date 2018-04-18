package solution.d_title31_40;

import java.util.Arrays;

/**
 * Determine if a Sudoku is valid
 * 3个规则：
 * 1）每一行只能出现1~9一次；
 * 2）每一列只能出现1~9一次；
 * 3）每个3×3子区域只能出现1~9一次
 */
public class ValidSudoku {

    public static boolean isValidSudoku(char[][] board) {
        boolean[] horVisited = new boolean[9];
        boolean[] verVisited = new boolean[9];

        // 判断每一行/每一列是否有重复数字
        for (int i = 0; i < 9; i++) {
            Arrays.fill(horVisited, false);
            Arrays.fill(verVisited, false);
            for (int j = 0; j < 9; j++) {
                if (!isValid(horVisited, board[i][j])) {
                    return false;
                }
                if (!isValid(verVisited, board[j][i])) {
                    return false;
                }
            }
        }

        boolean[] visited = new boolean[9];
        // 判断每3*3的区域是否有重复数字
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                Arrays.fill(visited, false);
                for (int k = 0; k < 9; k++) {
                    if (!isValid(visited, board[i + k / 3][j + k % 3])) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public static boolean isValid(boolean[] visited, char c) {
        if (c == '.') {
            return true;
        }

        int numIndex = c - '0' - 1;
        if (visited[numIndex]) {
            return false;
        }

        visited[numIndex] = true; // 设为已访问
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(isValidSudoku(board));
    }

}
