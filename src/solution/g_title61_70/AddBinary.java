package solution.g_title61_70;

/**
 * 二进制数相加
 * <p>
 * 典型
 */
public class AddBinary {
    public static void main(String[] args) {
        System.out.println(addBinary("11", "1"));
        System.out.println(addBinary("1010", "1011"));
    }

    public static String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1;

        int carry = 0;
        while (i >= 0 || j >= 0 || carry > 0) {
            int res = (i >= 0 ? (a.charAt(i) - '0') : 0) + (j >= 0 ? (b.charAt(j) - '0') : 0) + carry;
            carry = res / 2;
            result.append(res % 2);
            i--;
            j--;
        }

        return result.reverse().toString();
    }
}
