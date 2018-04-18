package solution.f_title51_60;

/**
 * 求数组的相邻子数组，满足子数组和最大
 * 好题~
 * <p>
 * 思路：
 * 基于Kadane算法，若之前sum<0，则重新计算sum，否则继续加 O(n)复杂度
 */
public class MaximumSubarray {

    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int sum = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum = Math.max(nums[i], sum + nums[i]);
            max = Math.max(max, sum);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }

}
