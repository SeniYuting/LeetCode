package niuke.tengxun;

// 游戏任务标记
// https://www.nowcoder.com/practice/2f45f0ef94724e06a4173c91ef60781c?tpId=85&tqId=29871&tPage=1&rp=1&ru=/ta/2017test&qru=/ta/2017test/question-ranking

import java.util.Scanner;

public class GameTask {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();

        if (a < 1 || a > 1024 || b < 1 || b > 1024) {
            System.out.println(-1);
        } else {
            if (a == b) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
