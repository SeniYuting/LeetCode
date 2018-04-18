package quiz.toutiao;

import java.util.Scanner;

/**
 * 输入：
 * 3
 * 3 1 2 3
 * 3 2 4 6
 * 3 3 4 6
 * 输出：
 * 1
 * 2
 * 3
 */
public class Main1 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        for (int i = 0; i < N; i++) {

            int num = in.nextInt();
            int[] numbers = new int[num];

            for (int j = 0; j < num; j++) {
                numbers[j] = in.nextInt();
            }

            int min = numbers[num - 1] - numbers[0];

            for (int j = 1; j <= min; j++) {
                boolean isOK = true;
                for (int k = 0; k < num; k++) {
                    if (numbers[k] + j > numbers[num - 1] || !isOK) {
                        break;
                    } else {
                        isOK = isIn(numbers, numbers[k] + j);
                    }
                }
                if (isOK) {
                    System.out.println(j);
                    break;
                }
            }

        }
    }

    private static boolean isIn(int[] arr, int m) {
        for (int a : arr) {
            if (a == m) {
                return true;
            }
        }
        return false;
    }
}
