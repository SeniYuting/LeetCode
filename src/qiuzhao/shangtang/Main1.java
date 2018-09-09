package qiuzhao.shangtang;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 对数组+k或者-k操作，求min(最大值-最小值)
 * <p>
 * 输入：
 * 4 3
 * 1 7 2 5
 * 思路：
 * {1,2,3} k=5，则同时-5或者+5即可
 */


public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line1 = sc.nextLine().split(" ");
        String[] line2 = sc.nextLine().split(" ");
        int n = Integer.parseInt(line1[0]);
        int k = Integer.parseInt(line1[1]);
        int[] num = new int[n];
        int sum = 0, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(line2[i]);
            sum += num[i];
            if (num[i] > max) {
                max = num[i];
            }
            if (num[i] < min) {
                min = num[i];
            }
        }

        int mean = sum / n;
        max -= k;
        min += k;

        for (int i = 0; i < n; i++) {
            if (num[i] < mean) {
                num[i] += k;
            }
            if (num[i] > mean) {
                num[i] -= k;
            }
            if (num[i] == mean) {
                if (max - num[i] > num[i] - min) {
                    num[i] -= k;
                } else {
                    num[i] += k;
                }
            }
        }
        Arrays.sort(num);

        System.out.println(Math.min(num[n - 1] - num[0], max + k - (min - k)));
    }
}
