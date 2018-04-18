package solution.e_title41_50;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * 好题~
 */
public class JumpGameTwo {

    public static int jump(int[] nums) {

        int jump = 0;  // 目前为止的jump数
        int max = 0;  // 0-i共i+1个元素能达到的最大范围
        int jumpMax = 0;  // jump次以后，能达到的最大范围

        for(int i=0; i<nums.length; i++) {
            if(jumpMax < i) {
                jump ++;
                jumpMax = max;
            }
            max = Math.max(max, nums[i] + i);
        }

        return jump;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(jump(nums));
    }

}
