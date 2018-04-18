package review.recursion;

public class BinarySearch { // 二分查找，要求待查找的序列有序，复杂度O(log n)，递归算法的空间复杂度高

    public static void main(String[] args) {
        int[] list = {1, 2, 3, 4, 5};
        int r1 = binarySearch1(list, 2, 0, list.length - 1);
        System.out.println(r1);
        int r2 = binarySearch2(list, 2, 0, list.length - 1);
        System.out.println(r2);
    }

    // 非递归实现
    public static int binarySearch1(int[] list, int a, int low, int high) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if (list[mid] == a) {
                return mid;
            } else if (list[mid] > a) {
                high = mid - 1;
            } else if (list[mid] < a) {
                low = mid + 1;
            }
        }
        return -1;
    }

    // 递归实现
    public static int binarySearch2(int[] list, int a, int low, int high) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if (list[mid] == a) {
                return mid;
            } else if (list[mid] > a) {
                return binarySearch2(list, a, low, mid - 1);
            } else if (list[mid] < a) {
                return binarySearch2(list, a, mid + 1, high);
            }
        }
        return -1;
    }
}
