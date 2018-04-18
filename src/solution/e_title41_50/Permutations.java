package solution.e_title41_50;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of distinct numbers, return all possible permutations.
 * 好题~
 */
public class Permutations {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        helpPermute(nums, 0, nums.length - 1, list);
        return list;
    }

    public static void helpPermute(int[] nums, int start, int end, List<List<Integer>> list) {
        if (start == end) {
            List<Integer> tmp = new ArrayList<>();
            for (int num : nums) {
                tmp.add(num);
            }
            list.add(tmp);
            return;
        }

        for (int i = start; i <= end; i++) {
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
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = permute(nums);
        for (List<Integer> re : result) {
            for (Integer r : re) {
                System.out.print(r + " ");
            }
            System.out.println();
        }
    }

}
