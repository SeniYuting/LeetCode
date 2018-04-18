package solution.b_title11_20;

/**
 * 
 * Given a roman numeral, convert it to an integer. Input is guaranteed to be
 * within the range from 1 to 3999.
 * 
 * 差题~
 *
 */
public class RomanToInteger {

	public static int romanToInt(String s) {

		int num = getNumber(s.charAt(0));
		for (int i = 1; i < s.length(); i++) {
			if (getNumber(s.charAt(i - 1)) < getNumber(s.charAt(i))) {
				num += getNumber(s.charAt(i)) - 2 * getNumber(s.charAt(i - 1));
			} else {
				num += getNumber(s.charAt(i));
			}
		}
		return num;
	}

	public static int getNumber(char c) {
		switch (c) {
		case 'M':
			return 1000;
		case 'D':
			return 500;
		case 'C':
			return 100;
		case 'L':
			return 50;
		case 'X':
			return 10;
		case 'V':
			return 5;
		case 'I':
			return 1;
		}
		return 0;
	}

	public static void main(String[] args) {
		System.out.println(romanToInt("MCC")); // 1200
		System.out.println(romanToInt("MCDXIX")); // 1419
		System.out.println(romanToInt("MCLXXXIX")); // 1189
	}

}
