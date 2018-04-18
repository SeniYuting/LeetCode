package solution.d_title31_40;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 * <p>
 * 思路：二分查找
 * <p>
 * 设左边缘为left，右边缘为right，中间位置为middle
 * 若target==nums[middle]，则返回
 * 若nums[middle]<nums[right]，则middle到right是有序的，只需判断target是否在middle到right之间
 * 如果是，则左边缘为m+1，否则右边缘为m-1
 * 若nums[middle]>=nums[right]，则left到middle时有序的，同理
 */
public class SearchInRotatedSortedArray {

    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (target == nums[middle]) {
                return middle;
            } else {
                if (nums[middle] < nums[right]) {
                    if (nums[middle] < target && target <= nums[right]) {
                        left = middle + 1;
                    } else {
                        right = middle - 1;
                    }
                } else {
                    if (nums[left] <= target && target < nums[middle]) {
                        right = middle - 1;
                    } else {
                        left = middle + 1;
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(search(nums, 1));
    }
}
