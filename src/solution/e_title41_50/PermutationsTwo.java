package solution.e_title41_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of numbers that might contain duplicates,
 * return all possible unique permutations.
 */
public class PermutationsTwo {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        helpPermute(nums, 0, nums.length - 1, list);
        return list;
    }

    public static void helpPermute(int[] nums, int start, int end, List<List<Integer>> list) {
        if (start == end) {
            List<Integer> tmp = new ArrayList<>();
            for (int num : nums) {
                tmp.add(num);
            }
            if(!list.contains(tmp)) {
                list.add(tmp);
            }
            return;
        }

        for (int i = start; i <= end; i++) {
            if (i != start && nums[i] == nums[start]) {
                continue;
            }
            swap(nums, start, i);
            helpPermute(nums, start + 1, end, list);
            swap(nums, start, i);
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 2};
        List<List<Integer>> result1 = permute(nums1);
        for (List<Integer> re : result1) {
            for (Integer r : re) {
                System.out.print(r + " ");
            }
            System.out.println();
        }

        int[] nums2 = {2, 2, 1, 1};
        List<List<Integer>> result2 = permute(nums2);
        for (List<Integer> re : result2) {
            for (Integer r : re) {
                System.out.print(r + " ");
            }
            System.out.println();
        }
    }
}
