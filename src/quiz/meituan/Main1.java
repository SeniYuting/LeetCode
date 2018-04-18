package quiz.meituan;

import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {

        Scanner cin = new Scanner(System.in);
        String s = cin.nextLine();
        String t = cin.nextLine();

        if (s == t || s.length() < t.length() || t.length() < 1) {
            System.out.println(0);
        }

        int len = t.length();
        int result = 0;
        for (int j = 0; j < s.length() - len + 1; j++) {
            for (int i = 0; i < len; i++) {
                result += (s.charAt(i + j) - t.charAt(i));
            }
        }

        System.out.println(result);

//        System.out.println(compare("aaa", "bab"));
//        System.out.println(compare("aaabb", "bab"));
    }
}
