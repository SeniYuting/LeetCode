package review.sort;

public class QuickSort {

    public static void main(String[] args) {
        int[] a = {2, 5, 7, 1, 3, 4, 6, 9, 10, 8};
        quickSort(a, 0, a.length - 1);
        for (int ai : a) {
            System.out.print(ai + " ");
        }
    }

    public static void quickSort(int[] a, int low, int high) {
        if (low >= high) return;
        int first = low;
        int last = high;
        int key = a[first];
        while (first < last) {
            while (key <= a[last]) { // 先从后往前遍历
                last--;
                if (last == first) {
                    break;
                }
            }
            a[first] = a[last];
            while (key >= a[first]) {
                first++;
                if (first == last) {
                    break;
                }
            }
            a[last] = a[first];
        }
        a[first] = key;
        quickSort(a, low, first - 1);
        quickSort(a, last + 1, high);
    }
}
