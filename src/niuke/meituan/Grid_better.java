package niuke.meituan;

// 递归

import java.util.Scanner;

public class Grid_better {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int row = in.nextInt();
        int column = in.nextInt();

        System.out.println(step(row, column));
    }

    public static int step(int row, int column) {
        if (row == 0 || column == 0) {
            return 1;
        } else {
            return step(row - 1, column) + step(row, column - 1);
        }
    }
}
