package solution.f_title51_60;

import java.util.ArrayList;
import java.util.List;

/**
 * N皇后问题，求个数
 */
public class NQueensTwo {

    public static int totalNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        int[] queenList = new int[n];
        NQueens.placeQueue(queenList, 0, n, result);
        return result.size();
    }

    public static void main(String[] args) {
        System.out.println(totalNQueens(4));
    }
}
