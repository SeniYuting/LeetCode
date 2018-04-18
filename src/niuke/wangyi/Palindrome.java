package niuke.wangyi;

// 牛客网-网易-回文序列
// https://www.nowcoder.com/practice/0147cbd790724bc9ae0b779aaf7c5b50?tpId=85&tqId=29850&tPage=2&rp=2&ru=/ta/2017test&qru=/ta/2017test/question-ranking

import java.util.Scanner;

public class Palindrome {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int[] arr = new int[num];

        for (int i = 0; i < num; i++) {
            arr[i] = in.nextInt();
        }

        int i = 0, j = num - 1;
        int time = 0;
        while (i < j) {
            if (arr[i] == arr[j]) {
                i++;
                j--;
            } else if (arr[i] < arr[j]) {
                arr[i + 1] += arr[i];
                i++;
                time++;
            } else {
                arr[j - 1] += arr[j];
                j--;
                time++;
            }
        }
        System.out.println(time);
    }

}
