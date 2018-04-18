package niuke.jingdong;

// 幸运数字
// https://www.nowcoder.com/practice/4d1afe11171c44a385287e29092cdb3f?tpId=85&tqId=29881&tPage=1&rp=1&ru=/ta/2017test&qru=/ta/2017test/question-ranking

import java.util.Scanner;

public class LuckyNum {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int n = 0;
        for (int i = 1; i <= num; i++) {
            if (f(i, 10) == f(i, 2)) {
                n++;
            }
        }
        System.out.println(n);
    }

    public static int f(int num, int sys) {
        int result = 0;
        while (num > 0) {
            result += num % sys;
            num /= sys;
        }
        return result;
    }

}
