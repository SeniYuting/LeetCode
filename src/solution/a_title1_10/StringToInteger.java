package solution.a_title1_10;

/**
 * 
 * Implement atoi to convert a string to an integer.
 *
 */
public class StringToInteger {

	public static int myAtoi(String str) {
		str = str.trim();
		int result = 0;
		boolean isPos = true;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (i == 0 && (c == '-' || c == '+')) {
				isPos = c == '+' ? true : false;
			} else if (c >= '0' && c <= '9') {
				// 检查溢出情况
				if (result > (Integer.MAX_VALUE - (c - '0')) / 10) {
					return isPos ? Integer.MAX_VALUE : Integer.MIN_VALUE;
				}
				result *= 10;
				result += c - '0';
			} else {
				return isPos ? result : -result;
			}
		}
		return isPos ? result : -result;
	}

	public static void main(String[] args) {
		System.out.println(myAtoi("hhh-123jjj")); // 0
		System.out.println(myAtoi("")); // 0
		System.out.println(myAtoi(" ")); // 0
		System.out.println(myAtoi("-a4")); // 0
		System.out.println(myAtoi("-")); // 0
		System.out.println(myAtoi("90")); // 90
		System.out.println(myAtoi("-3")); // -3
		System.out.println(myAtoi("5abc3")); // 5
		System.out.println(myAtoi("004")); // 4
		System.out.println(myAtoi("0.3")); // 0
		System.out.println(myAtoi("2147483648")); // 2147483647
		System.out.println(myAtoi("-2147483649")); // -2147483648
	}

}
