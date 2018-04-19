package quiz.iqiyi;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[3];

        nums[0] = sc.nextInt();
        nums[1] = sc.nextInt();
        nums[2] = sc.nextInt();

        int step = 0;

        Arrays.sort(nums);

        int d1 = nums[2] - nums[0];
        int d2 = nums[2] - nums[1];

        step += d1 / 2;
        step += d2 / 2;

        if (d1 % 2 == 0) {
            if (d2 % 2 == 0) {
                System.out.println(step);
            } else {
                System.out.println(step + 2);
            }
        } else {
            if (d2 % 2 == 0) {
                System.out.println(step + 2);
            } else {
                System.out.println(step + 1);
            }
        }

    }
}