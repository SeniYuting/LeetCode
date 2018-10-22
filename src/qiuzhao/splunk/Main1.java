package qiuzhao.splunk;

// 排序：按index， 51 55（5当成55） 68 81

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());

        if (n == 0) {
            System.out.println(0);
            return;
        }

        String[] s = in.nextLine().split(" ");

        for (int i = 0; i < s.length; i++) {
            s[i] = removeZero(s[i]);
        }

        sortString(s, 0, n, 0);

        String result = removeZero(String.join("", s));
        System.out.println(result);
    }

    public static void sortString(String[] s, int from, int to, int index) {
        if (from >= to - 1) {
            return;
        }
        Arrays.sort(s, from, to, (s1, s2) -> {
            char c1 = s1.length() > index ? s1.charAt(index) : s1.charAt(s1.length() - 1);
            char c2 = s2.length() > index ? s2.charAt(index) : s2.charAt(s2.length() - 1);
            return c1 - c2;
        });

        int i = from;
        int nextFrom = from;
        while (i < to - 1) {
            i++;
            String s1 = s[nextFrom];
            String s2 = s[i];
            char c1 = s1.length() > index ? s1.charAt(index) : s1.charAt(s1.length() - 1);
            char c2 = s2.length() > index ? s2.charAt(index) : s2.charAt(s2.length() - 1);
            if (c1 != c2 || (s1.length() <= index && s2.length() <= index)) {
                sortString(s, nextFrom, i, index + 1);
                nextFrom = i;
            }
        }

        sortString(s, nextFrom, to, index + 1);
    }

    public static String removeZero(String s) {
        int i = 0;
        while (i < s.length() && s.charAt(i) == '0') {
            i++;
        }

        if (i == s.length()) {
            return "0";
        } else {
            return s.substring(i);
        }
    }
}
