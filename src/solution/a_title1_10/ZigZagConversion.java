package solution.a_title1_10;

/**
 * 
 * 差题~
 *
 */
public class ZigZagConversion {

	public static String convert(String s, int numRows) {
		int length = s.length();
		if (length == 0 || numRows == 1) {
			return s;
		}

		String result = "";
		int step = 2 * numRows - 2;

		for (int i = 0; i < numRows; i++) {
			for (int j = i; j < length; j += step) {
				result += s.charAt(j);

				if (i > 0 && i < numRows - 1) {
					int middle = j + step - 2 * i;
					if (middle < length) {
						result += s.charAt(middle);
					}
				}
			}

		}

		return result;
	}

	public static void main(String[] args) {
		String s = "PAYPALISHIRING";
		int numRows = 3;
		String result = convert(s, numRows);
		System.out.println(result);
	}

}
