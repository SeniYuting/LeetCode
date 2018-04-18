package review.sort;

public class SelectSort {  // 找最小

    public static void main(String[] args) {
        int[] array = {2, 5, 7, 1, 3, 4, 6, 9, 10, 8};
        selectSort(array, 0, array.length);
        for (int a : array) {
            System.out.print(a + " ");
        }
    }

    public static void selectSort(int[] array, int begin, int end) {
        for (int i = begin; i < end; i++) {
            int minIndex = i;
            for (int j = i; j < end; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            swap(array, minIndex, i);
        }
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
