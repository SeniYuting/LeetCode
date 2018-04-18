package quiz.zhaohang;

import java.util.Scanner;

/**
 * 输入：abcabc
 * 输出：abc
 *
 * 子串
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        StringBuilder sb = new StringBuilder(s);
        int length = s.length();
        char begin = sb.charAt(0);

        int minI = length;
        for (int i = length - 1; i >= 0; i--) {
            if (sb.charAt(i) == begin) {
                String child = s.substring(i, length);
                if (isTrue(child, s)) {
                    minI = Math.min(minI, i);
                }
            }
        }

        if (minI == length) {
            System.out.println(false);
        } else {
            System.out.println(s.substring(minI, length));
        }

    }

    public static boolean isTrue(String child, String s) {
        if (child == s) {
            return false;
        }
        int num = s.length() / child.length();
        StringBuilder cb = new StringBuilder(child);
        for (int i = 0; i < num - 1; i++) {
            cb.append(child);
        }
        if (cb.toString().equals(s)) {
            return true;
        }
        return false;
    }
}
