package solution.b_title11_20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * Given an array S of n integers, are there elements a, b, c, and d in S such
 * that a + b + c + d = target? Find all unique quadruplets in the array which
 * gives the sum of target.
 *
 */
public class FourSum {

	public static List<List<Integer>> fourSum(int[] nums, int target) {

		List<List<Integer>> list = new ArrayList<List<Integer>>();
		Set<List<Integer>> set = new HashSet<List<Integer>>();

		if (nums == null || nums.length < 4) {
			return list;
		}

		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 3; i++) {
			for (int j = i + 1; j < nums.length - 2; j++) {

				int l = j + 1, r = nums.length - 1;
				while (l < r) {
					int sum = nums[i] + nums[j] + nums[l] + nums[r];

					if (sum < target) {
						l++;
					} else if (sum > target) {
						r--;
					} else {
						List<Integer> result = new ArrayList<Integer>();
						result.add(nums[i]);
						result.add(nums[j]);
						result.add(nums[l]);
						result.add(nums[r]);

						if (!set.contains(result)) {
							list.add(result);
							set.add(result);
						}
						l++;
						r--;
					}
				}
			}
		}

		return list;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 0, -1, 0, -2, 2 };
		List<List<Integer>> result = fourSum(nums, 0);
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
