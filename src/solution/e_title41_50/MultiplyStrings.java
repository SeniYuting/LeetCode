package solution.e_title41_50;

/**
 * Given two non-negative integers num1 and num2 represented as strings,
 * return the product of num1 and num2.
 * <p>
 * 思路：
 * 第一个数长度是n，第二个数长度是m，则结果长度最大为m+n，最小m+n-1。
 * 比如385 * 97, 个位=5 * 7，十位=8 * 7 + 5 * 9 ，百位=3 * 7 + 8 * 9 …可以每一位用一个int表示，存在int[]里面。
 */
public class MultiplyStrings {

    public static String multiply(String num1, String num2) {
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();

        int[] number = new int[num1.length() + num2.length()];
        for (int i = 0; i < num1.length(); i++) {
            for (int j = 0; j < num2.length(); j++) {
                number[i + j] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < number.length; i++) {
            int digit = number[i] % 10;
            int carry = number[i] / 10;

            result.insert(0, digit);

            if (i < number.length - 1) {
                number[i + 1] += carry;
            }
        }

        while (result.length() > 0 && result.charAt(0) == '0') { // 将前面的0删除
            result.deleteCharAt(0);
        }
        return result.length() == 0 ? "0" : result.toString();
    }

    public static void main(String[] args) {
        System.out.println(multiply("16", "17"));
    }

}
