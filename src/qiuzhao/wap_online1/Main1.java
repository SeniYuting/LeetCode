package qiuzhao.wap_online1;

/**
 * 2005.Find Min in Rotated Sorted Array
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * You may assume no duplicate exists in the array.
 * i.e. [0, 1, 2, 4, 5, 6, 7] might become [4, 5, 6, 7, 0, 1, 2].
 * Find the minimum element.
 * Example:
 * [4, 5, 6, 7, 0, 1, 2] → 0
 */
public class Main1 {
    public static void main(String[] args) {

        int[] ints = new int[]{4, 5, 6, 7, 0, 1, 2};
        System.out.println(binarySearch(ints));

    }

    public static int binarySearch(int[] ints) {
        int head = 0;
        int tail = ints.length - 1;

        if (ints[head] < ints[tail]) {
            return ints[head];
        }

        while (head < tail - 1) {
            int mid = (head + tail) / 2;
            if (ints[mid] > ints[0]) {
                head = mid;
            } else if (ints[mid] < ints[ints.length - 1]) {
                tail = mid;
            }
        }

        return ints[head] < ints[tail] ? ints[head] : ints[tail];

    }
}
