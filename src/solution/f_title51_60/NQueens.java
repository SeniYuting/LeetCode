package solution.f_title51_60;

import java.util.*;

/**
 * N皇后问题
 * 思路：
 * int[n]存放结果，int[0]=1表示Queen在第1行第2列
 */
public class NQueens {

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        int[] queenList = new int[n];
        placeQueue(queenList, 0, n, result);
        return result;
    }

    public static void placeQueue(int[] queenList, int row, int n, List<List<String>> result) {
        // 若已填满，则生成结果
        if (row == n) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String str = "";
                for (int j = 0; j < n; j++) {
                    if (queenList[i] == j) {
                        str += 'Q';
                    } else {
                        str += '.';
                    }
                }
                list.add(str);
            }
            result.add(list);
        }
        // 循环每一列
        for (int col = 0; col < n; col++) {
            if (isValid(queenList, row, col)) {
                queenList[row] = col;
                placeQueue(queenList, row + 1, n, result);
            }
        }
    }

    public static boolean isValid(int[] queenList, int row, int col) {
        for (int i = 0; i < row; i++) {
            int pos = queenList[i];
            if (pos == col) {  // 与新加入的Queen在同一列
                return false;
            }
            if (pos - i == col - row) { // 与新加入的Queen在同一主对角线
                return false;
            }
            if (i + pos == row + col) { // 与新加入的Queen在同一副对角线
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<String>> list = solveNQueens(4);
        for (List li : list) {
            for (Object l : li) {
                System.out.println(l);
            }
            System.out.println();
        }
    }
}
