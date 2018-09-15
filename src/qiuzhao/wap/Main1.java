package qiuzhao.wap;

// 70%
/**
 * 编辑距离最小值的最大值
 * <p>
 * 异或
 * count1的经算法
 * <p>
 * 输入：
 * 4
 * 1 2 11 22
 */

import java.util.HashSet;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String nAndk = in.nextLine();
        int n = Integer.valueOf(nAndk.split(" ")[0]);
        int k = Integer.valueOf(nAndk.split(" ")[1]);

        HashSet<Integer> set = new HashSet<>();
        int[] all = new int[n];

        for (int i = 0; i < n; i++) {
            String s = in.nextLine();
            //write your code
            int num = Integer.parseInt(s, 2);
            set.add(num);
            all[i] = num;
        }

        int minMax = 0;
        int result = 0;
        for (int i = 0; i < Math.pow(2, k); i++) {
            if (!set.contains(i)) {
                int min = minDis(all, i, k);
                if (minMax < min) {
                    result = i;
                    minMax = min;
                }
            }
        }

        StringBuilder sb = new StringBuilder(Integer.toBinaryString(result));
        while (sb.length() < k) {
            sb.insert(0, '0');
        }
        System.out.println(sb.toString());
    }

    private static int minDis(int[] all, int i, int k) {
        int min = k;
        for (int j = 0; j < all.length; j++) {
            int c = bitCount(i ^ all[j]);
            min = min > c ? c : min;
        }
        return min;
    }

    private static int bitCount(int n) {
        int count = 0;
        while (n > 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }
}
