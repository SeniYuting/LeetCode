package niuke.wangyi;

import java.util.Scanner;

public class HelpYi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] x = new int[num];
        int[] y = new int[num];

        for (int i = 0; i < num; i++) {
            x[i] = sc.nextInt();
        }

        for (int i = 0; i < num; i++) {
            y[i] = sc.nextInt();
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < num; i++) {
            min = Math.min(min, x[i] + y[i] - 2);
        }

        System.out.println(min);
    }
}
