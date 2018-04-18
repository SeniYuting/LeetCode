package review.sort;

public class BubbleSort {  // 两两比较选最大

    public static void main(String[] args) {
        int[] a = {2, 5, 7, 1, 3, 4, 6, 9, 10, 8};
        int[] result = sort(a);
        for (int r : result) {
            System.out.print(r + " ");
        }
    }

    public static int[] sort(int[] a) {
        int temp;
        for (int i = a.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (a[j + 1] < a[j]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        return a;
    }
}
