package solution.e_title41_50;

/**
 * Given an unsorted integer array, find the first missing positive integer.
 * Your algorithm should run in O(n) time and uses constant space.
 * <p>
 * 思路：
 * 将正数按照递增顺序依次放到数组中，即A[0]=1, A[1]=2, A[2]=3, ... ,
 * 若某元素违反了A[i]=i+1，则表示i+1就是第一个缺失的正数。
 */
public class FirstMissingPositive {

    public static int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= nums.length && nums[i] > 0 && nums[nums[i] - 1] != nums[i]) {
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
                i--;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 != nums[i]) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 0};
        System.out.println(firstMissingPositive(nums1));
        int[] nums2 = {3, 4, -1, 1};
        System.out.println(firstMissingPositive(nums2));
    }
}
