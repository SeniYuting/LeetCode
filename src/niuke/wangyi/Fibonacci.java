package niuke.wangyi;

// 牛客网-网易-Fibonacci
// https://www.nowcoder.com/practice/18ecd0ecf5ef4fe9ba3f17f8d00d2d66?tpId=85&tqId=29846&tPage=1&rp=1&ru=/ta/2017test&qru=/ta/2017test/question-ranking

import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a = 0, b = 1;
        int temp = 0;

        // fibonacci的非递归算法
        while (temp < n) {
            temp = a + b;
            a = b;
            b = temp;
        }
        System.out.println(temp - n > n - a ? n - a : temp - n);
    }
}
