package solution.e_title41_50;

/**
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 * <p>
 * 思路：先沿着副对角线翻转一次，再沿着水平中线翻转一次
 */
public class RotateImage {

    public static int[][] rotate(int[][] matrix) {
        int len = matrix.length;

        // 沿副对角线翻转
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[len - 1 - j][len - 1 - i];
                matrix[len - 1 - j][len - 1 - i] = temp;
            }
        }

        // 沿水平中线翻转
        for (int i = 0; i < len / 2; i++) {
            for (int j = 0; j < len; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[len - 1 - i][j];
                matrix[len - 1 - i][j] = temp;
            }
        }

        return matrix;
    }

    public static void main(String[] args) {
        int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] result1 = rotate(matrix1);
        for (int[] re : result1) {
            for (int r : re) {
                System.out.print(r + " ");
            }
            System.out.println();
        }

        System.out.println();

        int[][] matrix2 = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        int[][] result2 = rotate(matrix2);
        for (int[] re : result2) {
            for (int r : re) {
                System.out.print(r + " ");
            }
            System.out.println();
        }

    }

}
