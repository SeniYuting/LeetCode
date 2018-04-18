package solution.f_title51_60;

/**
 * 1~n^2的螺旋序
 * 思路：
 * 从外圈到里圈建立
 * 最后补上中心点
 */
public class SpiralMatrixTwo {
    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int k = 1;
        int top = 0, bottom = n - 1, left = 0, right = n - 1;
        while (left < right && top < bottom) {
            for (int i = left; i < right; i++) {
                res[top][i] = k++;
            }
            for (int i = top; i < bottom; i++) {
                res[i][right] = k++;
            }
            for (int i = right; i > left; i--) {
                res[bottom][i] = k++;
            }
            for (int i = bottom; i > top; i--) {
                res[i][left] = k++;
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        if (n % 2 != 0) {
            res[n / 2][n / 2] = n * n;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] res = generateMatrix(3);
        for (int[] re : res) {
            for (int r : re) {
                System.out.print(r + " ");
            }
            System.out.println();
        }
    }

}
