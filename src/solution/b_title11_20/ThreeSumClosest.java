package solution.b_title11_20;

import java.util.Arrays;

/**
 * Given an array S of n integers, find three integers in S such that the sum is
 * closest to a given number, target. Return the sum of the three integers. You
 * may assume that each input would have exactly one solution.
 * 
 * 好题~
 *
 */
public class ThreeSumClosest {

	public static int threeSumClosest(int[] nums, int target) {

		if (nums == null || nums.length < 3) {
			return 0;
		}

		Arrays.sort(nums);

		int result = 0;
		int closest = Integer.MAX_VALUE;

		for (int i = 0; i < nums.length - 2; i++) {

			if (i > 0 && nums[i] == nums[i - 1])
				continue;

			int l = i + 1, r = nums.length - 1;
			while (l < r) {
				int sum = nums[i] + nums[l] + nums[r];

				if (sum < target) {
					l++;
				} else if (sum > target) {
					r--;
				} else {
					return sum;
				}

				if (Math.abs(sum - target) < closest) {
					closest = Math.abs(sum - target);
					result = sum;
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		int[] nums = { -1, 2, 1, -4 };
		int target = 1;

		// int[] nums = { 1, 1, 1, 1 };
		// int target = 0;
		System.out.println(threeSumClosest(nums, target));
	}

}
