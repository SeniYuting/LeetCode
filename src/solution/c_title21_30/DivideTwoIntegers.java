package solution.c_title21_30;

/**
 * Divide two integers without using multiplication, division and mod operator.
 * If it is overflow, return MAX_INT.
 */
public class DivideTwoIntegers {

    public static int divide(int dividend, int divisor) {

        if (divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)) {
            return Integer.MAX_VALUE;
        }

        int result = 0;
        // 考虑到左移边界问题，将Int(32位)型数字转换为long(64位)型
        long absDividend = Math.abs((long)dividend);
        long absDivisor = Math.abs((long)divisor);

        while (absDividend >= absDivisor) {
            int shiftNum = 0;
            while (absDividend >= (absDivisor << shiftNum)) {
                shiftNum++;  // 记录左移次数（比实际次数多1）
            }
            result += (1 << (shiftNum - 1));
            absDividend -= (absDivisor << (shiftNum - 1));
        }

        if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) {
            return result;
        } else {
            return -result;
        }
    }

    public static void main(String[] args) {
        System.out.println(divide(Integer.MIN_VALUE, -1));
        System.out.println(divide(Integer.MIN_VALUE, 1));
        System.out.println(divide(Integer.MAX_VALUE, 1));
        System.out.println(divide(3, 2));
    }
}
