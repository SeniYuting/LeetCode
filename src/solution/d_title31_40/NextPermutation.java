package solution.d_title31_40;

/**
 * Implement next permutation, which rearranges numbers into the lexicographically
 * next greater permutation of numbers.
 * <p>
 * 给定一个数组和一个排列，求下一个排列
 * <p>
 * 思路：
 * 例： (2,3,6,5,4,1)
 * 1) 先从后往前找到第一个不是依次增长的数，记录下位置p。比如例子中的3，对应的位置是1;
 * 2) 接下来分两种情况：
 * (1) 如果上面的数字都是依次增长的，则说明这是最后一个排列，下一个就是第一个，把所有数字反转过来即可
 * (比如(6,5,4,3,2,1)下一个是(1,2,3,4,5,6));
 * (2) 否则，如果p存在，从p开始往后找，找到下一个数就比p对应的数小的数字，然后两个调换位置，比如例子中的4。
 * 调换位置后得到(2,4,6,5,3,1)。最后把p之后的所有数字倒序，比如例子中得到(2,4,1,3,5,6), 即是要求的下一个排列。
 */
public class NextPermutation {

    public static int[] nextPermutation(int[] nums) {

        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = i + 1;
            while (j <= nums.length - 1 && nums[j] > nums[i]) {
                j++;
            }
            j--;
            swap(nums, i, j);
        }
        reverse(nums, i + 1);

        return nums;
    }

    public static void reverse(int[] nums, int index) {
        int left = index;
        int right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int[] result = nextPermutation(nums);
        for (int i = 0; i < result.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

}
