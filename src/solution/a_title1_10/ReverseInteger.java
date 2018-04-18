package solution.a_title1_10;

/**
 * 
 * Given a 32-bit signed integer, reverse digits of an integer. 好题~
 *
 */
public class ReverseInteger {

	public static int reverse(int x) {

		int result = 0;
		int num = Math.abs(x);

		while (num != 0) {

			// 处理越界问题
			if (result > (Integer.MAX_VALUE - num % 10) / 10) {
				return 0;
			}

			result = result * 10 + num % 10;
			num /= 10;
		}

		return x > 0 ? result : -result;
	}

	public static void main(String[] args) {
		System.out.println(reverse(123));
		System.out.println(reverse(-123));
		System.out.println(reverse(120));
		System.out.println(reverse(1534236469));

		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.MAX_VALUE);

		System.out.println(reverse(Integer.MIN_VALUE));
		System.out.println(reverse(Integer.MAX_VALUE));

	}
}
