package solution.e_title41_50;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 * <p>
 * 思路：
 * 依次求每一个柱子处可承接的水, 水量高度为：min(max_left, max_right)
 */
public class TrappingRainWater {

    public static int trap(int[] height) {

        int result = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int max_left = 0, max_right = 0;
            for (int j = i; j >= 0; j--) {
                max_left = Math.max(max_left, height[j]);
            }
            for (int j = i; j < height.length; j++) {
                max_right = Math.max(max_right, height[j]);
            }
            result += Math.min(max_left, max_right) - height[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] height1 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height1));

        int[] height2 = {2,0,2};
        System.out.println(trap(height2));
    }
}
