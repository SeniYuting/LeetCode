package niuke.wangyi;

// 统计回文
// https://www.nowcoder.com/practice/9d1559511b3849deaa71b576fa7009dc?tpId=85&tqId=29842&tPage=1&rp=1&ru=/ta/2017test&qru=/ta/2017test/question-ranking

import java.util.Scanner;

public class CountPalindrome {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        String b = in.nextLine();

        int num = 0;
        int length = a.length();
        for (int i = 0; i <= length; i++) {
            StringBuilder ab = new StringBuilder(a);
            ab.insert(i, b);
            if (isPalindrome(ab)) {
                num++;
            }
        }

        System.out.println(num);
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
