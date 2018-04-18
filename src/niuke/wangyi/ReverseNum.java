package niuke.wangyi;

// 数字翻转
// https://www.nowcoder.com/practice/bc62febdd1034a73a62224affe8bddf2?tpId=85&tqId=29854&tPage=1&rp=1&ru=/ta/2017test&qru=/ta/2017test/question-ranking

import java.util.Scanner;

public class ReverseNum {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int y = in.nextInt();
        System.out.println(reverse(reverse(x) + reverse(y)));

    }

    public static int reverse(int num) {
        int result = 0;
        while (num != 0) {
            result = result * 10 + num % 10;
            num /= 10;
        }
        return result;
    }
}
