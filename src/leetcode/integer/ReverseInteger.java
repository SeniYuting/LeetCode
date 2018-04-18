package leetcode.integer;

public class ReverseInteger {
    public static int reverse(int x) {
        int reverse = 0;
        while (x != 0) {
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }
        return reverse;
    }

    public static void main(String[] args) {
        System.out.println(reverse(123));
    }
}
