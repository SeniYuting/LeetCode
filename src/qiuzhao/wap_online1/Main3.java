package qiuzhao.wap_online1;

/**
 * 2013.Rotate Image
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 * Note:
 * Do this in-place.
 * Example:
 * [[1,2,3],[4,5,6],[7,8,9]] -> [[7,4,1],[8,5,2],[9,6,3]]
 * I know you need an illustration
 * 1 2 3    7 4 1
 * 4 5 6 -> 8 5 2
 * 7 8 9    9 6 3
 */
public class Main3 {
    public static void main(String[] args) {
        int[][] image = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] result = rotate(image, 3);
        for (int[] line : result) {
            for (int i : line) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static int[][] rotate(int[][] image, int n) {
        int mid = (n + 1) / 2;
        for (int i = 0; i < mid; i++) {
            for (int j = i; j < n - 1; j++) {
                int X = i;
                int Y = j;
                int nextX = j;
                int nextY = n - 1 - i;
                int temp = image[X][Y];
                for (int k = 0; k < 4; k++) {
                    int t = image[nextX][nextY];
                    image[nextX][nextY] = temp;
                    temp = t;
                    X = nextX;
                    Y = nextY;
                    nextX = Y;
                    nextY = n - 1 - X;
                }
            }
        }

        return image;
    }
}
