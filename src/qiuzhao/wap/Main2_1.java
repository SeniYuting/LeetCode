package qiuzhao.wap;

// 30%

import java.math.BigDecimal;
import java.util.Scanner;

public class Main2_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        long ans = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isDivisibleBySeven(a[i] + "" + a[j])) {
                    ans++;
                }
                if (isDivisibleBySeven(a[j] + "" + a[i])) {
                    ans++;
                }
            }
        }

        System.out.println(ans);

//        System.out.println(isDivisibleBySeven("17623416832"));
    }

    public static boolean isDivisibleBySeven(String num) {
        if (num.length() <= 10) {
            return Integer.parseInt(num) % 7 == 0;
        }
        int length = num.length();
        return isDivisibleBySeven(bigNumberSub(num.substring(0, length - 1), num.substring(length - 1, length)));
    }

    public static String bigNumberSub(String minuend, String subtrahend) {
        BigDecimal result = null;
        try {
            BigDecimal b1 = new BigDecimal(minuend);
            BigDecimal b2 = new BigDecimal(subtrahend);
            result = b1.subtract(b2).subtract(b2).stripTrailingZeros();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();

    }

}
