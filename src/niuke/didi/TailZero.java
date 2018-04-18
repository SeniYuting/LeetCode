package niuke.didi;

// 末尾0的个数
// https://www.nowcoder.com/practice/6ffdd7e4197c403e88c6a8aa3e7a332a?tpId=85&tqId=29861&tPage=2&rp=2&ru=/ta/2017test&qru=/ta/2017test/question-ranking

// 也就是计算因子5的个数
import java.util.Scanner;

public class TailZero {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();

        int count = 0;
        int n = num / 5;
        // 对每个5的倍数处理
        for (int i = 1; i <= n; i++) {
            int handle = i * 5;
            while (handle % 5 == 0) {
                handle /= 5;
                count++;
            }
        }

        System.out.println(count);
    }
}
