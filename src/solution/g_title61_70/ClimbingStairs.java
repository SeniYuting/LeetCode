package solution.g_title61_70;

/**
 * 爬n级楼梯：一次一步或者两步
 * 问：有多少种走法
 * 典型题
 * <p>
 * f(n) = f(n-1) + f(n-2)
 */
public class ClimbingStairs {

    public static void main(String[] args) {
        System.out.println(climbStairs(3)); // 3
        System.out.println(climbStairs(4)); // 5
    }

    public static int climbStairs(int n) {
        if (n == 1 || n == 2) {
            return n;
        }

        int a = 1, b = 2, result = 0;
        while (n >= 3) {
            result = a + b;
            a = b;
            b = result;
            n--;
        }

        return result;
    }
}
