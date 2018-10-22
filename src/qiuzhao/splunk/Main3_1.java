package qiuzhao.splunk;

// 暴力，所有数字，要么选择，要么不选择
import java.util.Scanner;

public class Main3_1 {

    public static int min = Integer.MAX_VALUE;
    public static int total = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        String[] numsStr = sc.nextLine().split(" ");

        int[] nums = new int[num];
        for (int i = 0; i < num; i++) {
            nums[i] = Integer.parseInt(numsStr[i]);
            total += nums[i];
        }

        select(nums, 0, 0);
        System.out.println(min);

    }

    public static void select(int[] nums, int index, int sum) {
        if (index == nums.length) {
            int res = sum > total - sum ? sum : total - sum;
            min = res < min ? res : min;
            return;
        }
        select(nums, index + 1, sum + nums[index]);
        select(nums, index + 1, sum);
    }
}