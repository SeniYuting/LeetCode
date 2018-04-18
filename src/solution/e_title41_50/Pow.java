package solution.e_title41_50;

/**
 * Implement pow(x, n).
 * Example:
 * Input: 2.00000, 10
 * Output: 1024.00000
 * 思路：
 * 递归，(x ^ n) ^ 2 = x ^ (2 * n)，考虑奇偶
 */

public class Pow {

    public static double fastPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double half = fastPow(x, n / 2);
        if ((n & 1) == 0) {  // 等价于n % 2 == 0，但为晕眩效率高
            return half * half;
        } else {
            return half * half * x;
        }
    }

    public static double myPow(double x, int n) {
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        return fastPow(x, n);
    }

    public static void main(String[] args) {
        /**
         * 结果：
         * 1024.0
         * 9.261000000000001
         * 2.543114507074558E-5
         * 0.125
         */
        System.out.println(myPow(2.00000, 10));
        System.out.println(myPow(2.10000, 3));
        System.out.println(myPow(34.00515, -3));
        System.out.println(myPow(2.00000, -3));
    }
}
