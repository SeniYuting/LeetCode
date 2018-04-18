package review.sort;

public class InsertSort {

    public static void main(String[] args) {
        int[] array = {2, 5, 7, 1, 3, 4, 6, 9, 10, 8};
        insertSort(array);
        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    public static void insert(int[] array, int len, int x) {
        // 将x插入array[0:len-1]
        int i;
        for (i = len - 1; i >= 0 && x < array[i]; i--) {
            array[i + 1] = array[i];
        }
        array[i + 1] = x;
    }

    public static void insertSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            insert(array, i, array[i]);
        }
    }
}
