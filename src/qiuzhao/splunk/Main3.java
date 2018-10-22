package qiuzhao.splunk;

import java.util.Arrays;
import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        String[] numsStr = sc.nextLine().split(" ");

        int[] nums = new int[num];
        for (int i = 0; i < num; i++) {
            nums[i] = Integer.parseInt(numsStr[i]);
        }
        Arrays.sort(nums);

        int time1 = nums[num - 1], time2 = 0;
        int leftTime1 = nums[num - 1], leftTime2 = 0;

        for (int i = num - 2; i >= 0; i--) {
            if (leftTime1 >= leftTime2) {
                time2 += nums[i];
                leftTime2 += nums[i];

            } else {
                time1 += nums[i];
                leftTime1 += nums[i];
            }

            int minTime = leftTime1 < leftTime2 ? leftTime1 : leftTime2;
            leftTime1 -= minTime;
            leftTime2 -= minTime;
        }

        System.out.println(time1 > time2 ? time1 : time2);

    }
}
