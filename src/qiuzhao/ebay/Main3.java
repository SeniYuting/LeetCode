package qiuzhao.ebay;

// input:
// 7 5
// 100 400 300 100 500 101 400

import java.util.Scanner;

public class Main3 {

    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] numbers = sc.nextLine().split(" ");
        int n = Integer.parseInt(numbers[0]);
        int m = Integer.parseInt(numbers[1]);
        String[] stones = sc.nextLine().split(" ");

        int[] stonesInt = new int[n];
        for (int i = 0; i < n; i++) {
            stonesInt[i] = Integer.parseInt(stones[i]);
        }

        MaxMin(stonesInt, n, m);
        System.out.println(min);
    }

    public static void MaxMin(int[] stones, int n, int m) {
        if (n == m) {
            int max = 0;
            for (int i : stones) {
                max = i > max ? i : max;
            }

            if (min > max) {
                min = max;
            }
        }

        int[] newStones = new int[stones.length - 1];


        for (int i = 0; i < stones.length - 1; i++) {
            for (int j = 0; j < newStones.length; j++) {
                if (j != i) {
                    newStones[j] = stones[j];
                } else {
                    newStones[j] = stones[j] + stones[j + 1];
                    j++;
                }
            }

            MaxMin(newStones, n, m + 1);
        }
    }
}
