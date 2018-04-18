package solution.a_title1_10;

import java.util.Arrays;

/**
 * 
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity
 * should be O(log (m+n)). 好题~
 * 
 * 思路：二分查找复杂度log(n),但本题不是二分查找，因为median在中间附近
 *
 * Example1: nums1 = [1, 3] nums2 = [2] The median is 2.0
 *
 * Example2: nums1 = [1, 2] nums2 = [3, 4] The median is (2 + 3)/2 = 2.5
 *
 */
public class MedianOfTwoSortedArrays {

	// Time Limit Exceeded
	public static double findMedianSortedArraysTry(int[] nums1, int[] nums2) {

		int allNumLength = nums1.length + nums2.length;
		if (allNumLength == 0) {
			return 0.0;
		}

		if (allNumLength == 1) {
			return nums1.length != 0 ? nums1[0] : nums2[0];
		}

		double median = 0.0;
		int[] allNum = new int[allNumLength];
		System.arraycopy(nums1, 0, allNum, 0, nums1.length);
		System.arraycopy(nums2, 0, allNum, nums1.length, nums2.length);
		Arrays.sort(allNum);

		if (allNum.length % 2 == 0) {
			median = (double) (allNum[allNum.length / 2 - 1] + allNum[allNum.length / 2]) / 2;
		} else {
			median = allNum[allNum.length / 2];
		}

		return median;
	}

	// Accepted:
	// https://leetcode.com/problems/median-of-two-sorted-arrays/solution/
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

		int m = nums1.length;
		int n = nums2.length;

		if (m > n) { // ensure m<=n
			int[] temp = nums1;
			nums1 = nums2;
			nums2 = temp;
			int tmp = m;
			m = n;
			n = tmp;
		}

		int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
		while (iMin <= iMax) {

			int i = (iMin + iMax) / 2;
			int j = halfLen - i;
			if (i < iMax && nums2[j - 1] > nums1[i]) {
				iMin++;
			} else if (i > iMin && nums1[i - 1] > nums2[j]) {
				iMax--;
			}

			else { // i满足条件
				int maxLeft = 0;
				if (i == 0) {
					maxLeft = nums2[j - 1];
				} else if (j == 0) {
					maxLeft = nums1[i - 1];
				} else {
					maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
				}
				if ((m + n) % 2 == 1) {
					return maxLeft;
				}

				int minRight = 0;
				if (i == m) {
					minRight = nums2[j];
				} else if (j == n) {
					minRight = nums1[i];
				} else {
					minRight = Math.min(nums1[i], nums2[j]);
				}
				return (double) (maxLeft + minRight) / 2;
			}
		}
		return 0.0;
	}

	public static void main(String[] args) {
		int[] nums1 = { 1, 3 }, nums2 = { 2 };
		// double median1 = findMedianSortedArraysTry(nums1, nums2);
		double median1 = findMedianSortedArrays(nums1, nums2);
		System.out.println(median1);

		int[] nums3 = { 1, 2 }, nums4 = { 3, 4 };
		// double median2 = findMedianSortedArraysTry(nums3, nums4);
		double median2 = findMedianSortedArrays(nums3, nums4);
		System.out.println(median2);
	}
}
