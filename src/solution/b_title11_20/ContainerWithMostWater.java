package solution.b_title11_20;

/**
 * 
 * Given n non-negative integers a1, a2, ..., an, where each represents a point
 * at coordinate (i, ai). n vertical lines are drawn such that the two endpoints
 * of line i is at (i, ai) and (i, 0). Find two lines, which together with
 * x-axis forms a container, such that the container contains the most water.
 * 
 * 找盛水最多的木桶
 * 
 * 好题~
 *
 */
public class ContainerWithMostWater {

	public static int maxArea(int[] height) {
		int maxArea = 0, l = 0, r = height.length - 1;
		while (l < r) {
			maxArea = Math.max(maxArea, Math.min(height[l], height[r]) * (r - l));
			if (height[l] < height[r]) {
				l++;
			} else {
				r--;
			}
		}

		return maxArea;
	}

	public static void main(String[] args) {
		int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		System.out.println(maxArea(height));
	}

}
