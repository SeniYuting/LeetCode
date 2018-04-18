package leetcode.array;

// 最大子数组和
public class MaximumSubarray {
    public static int maxSubArray(int[] nums) {
        int len = nums.length;
        int sum = 0, max = Integer.MIN_VALUE;

        for (int i = 0; i < len; i++) {
            sum = Math.max(sum + nums[i], nums[i]);
            max = Math.max(max, sum);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }
}
