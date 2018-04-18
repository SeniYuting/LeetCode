package quiz.toutiao;

import java.util.Scanner;

/**
 * 输入：
 * 3 1 5
 * 1 2 3
 * 1
 * 输出：
 * 9
 */
public class Main2 {
    private static int sum = 0;
    public static int m = 0;
    private static int[] n1Nums;
    private static int[] n2Nums;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n1 = in.nextInt();
        int n2 = in.nextInt();
        m = in.nextInt();

        n1Nums = new int[n1];
        n2Nums = new int[n2];

        for (int i = 0; i < n1; i++) {
            n1Nums[i] = in.nextInt();
        }

        for (int i = 0; i < n2; i++) {
            n2Nums[i] = in.nextInt();
        }

        countNum(m, 0);

        for (int i = 1; i <= n2; i++) {
            combination(0, i, 0);
        }

        int nmod = 10;
        for (int i = 0; i < 8; i++) {
            nmod *= 10;
        }
        nmod += 7;
        System.out.println(sum % nmod);
    }

    private static void combination(int index, int size, int all) {
        if (size == 0) {
            countNum(m - all, 0);
            return;
        }

        if (index == n2Nums.length) {
            return;
        }

        all += n2Nums[index];
        combination(index + 1, size - 1, all);
        all -= n2Nums[index];
        combination(index + 1, size, all);
    }

    private static void countNum(int m, int index) {
        if (m < 0) {
            return;
        }

        if (m == 0) {
            sum++;
            return;
        }

        for (int i = index; i < n1Nums.length; i++) {
            countNum(m - n1Nums[i], i);
        }
    }
}
