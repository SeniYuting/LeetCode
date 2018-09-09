package qiuzhao.toutiao.second;

// 100%

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        int length = lengthOfLongestSubstring(s);

        System.out.println(length);
    }


    public static int lengthOfLongestSubstring(String s) {
        int length = 0, i = 0, j = 0;

        Set<Character> set = new HashSet<>();

        while (i < s.length() && j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                length = Math.max(length, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }

        return length;
    }
}
