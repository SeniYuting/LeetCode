package solution.d_title31_40;

/**
 * Given an array of integers sorted in ascending order, find the starting and ending position of
 * a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 */
public class SearchForARange {

    public static int[] searchRange(int[] nums, int target) {
        int targetRange[] = {-1, -1};

        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                targetRange[0] = i;
                break;
            }
        }

        if (targetRange[0] == -1) {
            return targetRange;
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (target == nums[i]) {
                targetRange[1] = i;
                break;
            }
        }

        return targetRange;
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int[] result = searchRange(nums, 8);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

}
