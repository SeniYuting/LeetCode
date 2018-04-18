package solution.d_title31_40;

/**
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * Empty cells are indicated by the character '.'.
 */
public class SudokuSolver {

    public static char[][] solveSudoku(char[][] board) {
        helpSolveSudoku(board);
        return board;
    }

    public static boolean helpSolveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char num = '1'; num <= '9'; num++) {
                        if (isValid(board, i, j, num)) {
                            board[i][j] = num;

                            if (helpSolveSudoku(board)) {
                                return true;
                            } else {
                                board[i][j] = '.'; // 回退
                            }
                        }
                    }
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean isValid(char[][] board, int i, int j, char num) {

        // check column
        for (int k = 0; k < 9; k++) {
            if (board[k][j] == num) {
                return false;
            }
        }

        // check row
        for (int k = 0; k < 9; k++) {
            if (board[i][k] == num) {
                return false;
            }
        }

        // check block
        for (int row = i / 3 * 3; row < i / 3 * 3 + 3; row++) {
            for (int col = j / 3 * 3; col < j / 3 * 3 + 3; col++) {
                if (board[row][col] == num) {
                    return false;
                }
            }
        }

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

        char[][] result = solveSudoku(board);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

}
