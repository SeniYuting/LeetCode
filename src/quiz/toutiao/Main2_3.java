package quiz.toutiao;

import java.util.Scanner;

// 简单练习
public class Main2_3 {

    static int n1;
    static int n2;
    static int[] num1;
    static int[] num2;
    static int m;
    static int count;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n1 = sc.nextInt();
        n2 = sc.nextInt();
        m = sc.nextInt();

        num1 = new int[n1];
        for (int i = 0; i < n1; i++) {
            num1[i] = sc.nextInt();
        }

        num2 = new int[n2];
        for (int i = 0; i < n2; i++) {
            num2[i] = sc.nextInt();
        }

        for (int i = 0; i <= n2; i++) {
            combine(0, i, 0);
        }
        System.out.println(count);

    }

    public static void combine(int index, int size, int sum) {
        if (size == 0) {
//            count(0, m - sum);
            count(m - sum);
            return;
        }

        if (index == num2.length) {
            return;
        }

        sum += num2[index];
        combine(index + 1, size - 1, sum);
        sum -= num2[index];
        combine(index + 1, size, sum);
    }

    public static void count(int index, int all) {
        if (all == 0) {
            count++;
            return;
        }

        if (all < 0) {
            return;
        }

        for (int i = index; i < num1.length; i++) {
            count(i, all - num1[i]);
        }
    }

    public static void count(int all) {
        int[][] countN1 = new int[n1][all + 1];
        for (int i = 0; i < n1; i++) {
            countN1[i][0] = 1;
        }

        for (int i = 1; i * num1[0] <= all; i++) {
            countN1[0][i * num1[0]] = 1;
        }

        for (int i = 1; i < n1; i++) {
            for (int j = 1; j <= all; j++) {
                for (int k = 0; k * num1[i] <= j; k++) {
                    countN1[i][j] += countN1[i - 1][j - k * num1[i]];
                }
            }
        }
        count += countN1[n1 - 1][all];
    }
}
