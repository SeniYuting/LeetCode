package solution.b_title11_20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * Given an array S of n integers, are there elements a, b, c in S such that a +
 * b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * 
 * 思路：先固定一个数，再找另外两个数之和为第一个数的相反数
 *
 */
public class ThreeSum {

	public static List<List<Integer>> list = new ArrayList<List<Integer>>();

	public static List<List<Integer>> threeSum(int[] nums) {
		if (nums == null || nums.length < 3) {
			return list;
		}

		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 2; i++) {
			if (i > 0 && nums[i - 1] == nums[i])
				continue;
			find(nums, i + 1, nums.length - 1, nums[i]);
		}

		return list;
	}

	public static void find(int[] nums, int begin, int end, int num) {
		int l = begin, r = end;
		while (l < r) {
			if (nums[l] + nums[r] + num == 0) {
				List<Integer> threeNumList = new ArrayList<Integer>();
				threeNumList.add(num);
				threeNumList.add(nums[l]);
				threeNumList.add(nums[r]);
				list.add(threeNumList);

				while (l < r && nums[l] == nums[l + 1]) {
					l++;
				}
				while (l < r && nums[r - 1] == nums[r]) {
					r--;
				}
				l++;
				r--;
			} else if (nums[l] + nums[r] + num < 0) {
				l++;
			} else {
				r--;
			}
		}
	}

	public static void main(String[] args) {
		int[] nums = { -1, 0, 1, 2, -1, -4 };
		List<List<Integer>> result = threeSum(nums);
		for (int i = 0; i < result.size(); i++) {
			List<Integer> l = result.get(i);
			System.out.print("[ ");
			for (int j = 0; j < l.size(); j++) {
				System.out.print(l.get(j) + " ");
			}
			System.out.println("]");
		}
	}

}
