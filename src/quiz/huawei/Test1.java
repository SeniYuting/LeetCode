package quiz.huawei;

import java.util.Scanner;

public class Test1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int length = str.length(), max = 0;

        if (length == 1) {
            System.out.println(1);
        } else {
            for (int i = 0; i < length; i++) {
                for (int j = i + 1; j <= length; j++) {
                    StringBuilder sb = new StringBuilder(str.substring(i, j));
                    if (isPalindrome(sb)) {
                        max = Math.max(j - i, max);
                    }
                }
            }

            System.out.println(max);
        }
    }

    public static boolean isPalindrome(StringBuilder ab) {
        for (int i = 0; i < ab.length() / 2; i++) {
            if (ab.charAt(i) != ab.charAt(ab.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

}
