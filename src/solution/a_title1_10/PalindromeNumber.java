package solution.a_title1_10;

/**
 * 
 * 同ReverseInteger
 *
 */
public class PalindromeNumber {

	public static boolean isPalindrome(int x) {

		if (x < 0 || (x % 10 == 0 && x != 0)) {
			return false;
		}
		
		int reverse = 0;
		int tmpX = x;
		while(tmpX!=0) {
			reverse = reverse * 10 + tmpX % 10;
			tmpX /= 10;
		}

		return reverse == x ? true : false;
	}

	public static void main(String[] args) {
		System.out.println(isPalindrome(123));
		System.out.println(isPalindrome(121));
		System.out.println(isPalindrome(0));
	}

}
