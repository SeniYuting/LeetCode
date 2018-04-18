package solution.f_title51_60;

/**
 * 给定数组，数组相应位置的值为可以跳动的步数，
 * 起始位置为0，求是否可以跳到最后一个元素处
 * 好题~
 * 思路：
 * 从右往左倒溯，是否满足i+nums[i]>=最后一个可达的index
 */
public class JumpGame {
    public static boolean canJump(int[] nums) {
        int lastIndex = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastIndex) {
                lastIndex = i;
            }
        }
        return lastIndex == 0;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 3, 1, 1, 4};
        System.out.println(canJump(nums1));
        int[] nums2 = {3, 2, 1, 0, 4};
        System.out.println(canJump(nums2));
    }
}
