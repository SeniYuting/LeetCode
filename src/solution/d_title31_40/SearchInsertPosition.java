package solution.d_title31_40;

/**
 * Given a sorted array and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 */
public class SearchInsertPosition {

    public static int searchInsert(int[] nums, int target) {
        if (nums.length == 0 || target < nums[0]) {
            return 0;
        }
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < target && target < nums[i + 1]) {
                return i + 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        System.out.println(searchInsert(nums, 5));
        System.out.println(searchInsert(nums, 2));
        System.out.println(searchInsert(nums, 7));
        System.out.println(searchInsert(nums, 0));

    }

}
