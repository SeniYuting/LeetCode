package quiz.jingdong;

import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] c = s.toCharArray();
        combine(c);
    }

    public static void combine(char[] c) {
        int len = c.length;
        int[] used = new int[len];
        char[] temp = new char[len];

        int result = 0;
        int count = 0;
        while (true) {
            int index = 0;
            while (used[index] == 1) {
                used[index] = 0;
                result--;
                if (++index == len) {
                    System.out.println(count);
                    return;
                }
            }
            used[index] = 1;
            temp[result++] = c[index];

            if (isPalindrome(new String(temp).substring(0, result))) {
                count++;
            }
        }
    }

    public static boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
