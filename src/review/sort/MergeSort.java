package review.sort;

public class MergeSort { // 归并排序，分治法

    public static void main(String[] args) {
        int[] array = {2, 5, 7, 1, 3, 4, 6, 9, 10, 8};
        int[] a = mergeSort(array, 0, array.length);
        for (int i : a) {
            System.out.print(i + " ");
        }
    }

    public static int[] mergeSort(int[] array, int begin, int end) { // [begin, end)
        if (end - begin <= 1) {
            return new int[]{array[begin]};
        }
        int mid = (begin + end) / 2;
        int[] left = mergeSort(array, begin, mid);
        int[] right = mergeSort(array, mid, end);
        return merge(left, right);
    }

    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int j = 0, k = 0;

        for (int i = 0; i < result.length; i++) {
            if (j == left.length) {
                result[i] = right[k++];
            } else if (k == right.length) {
                result[i] = left[j++];
            } else if (left[j] < right[k]) {
                result[i] = left[j++];
            } else {
                result[i] = right[k++];
            }
        }

        return result;

    }
}
