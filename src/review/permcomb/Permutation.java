package review.permcomb;

public class Permutation { // 全排列

    public static void main(String[] args) {
        char[] array = {'a', 'b', 'c'};
        permutation(array, 0, array.length - 1);
    }

    public static void permutation(char[] array, int from, int to) {
        if (from == to) {
            for (char c : array) {
                System.out.print(c + " ");
            }
            System.out.println();
        } else {
            for (int i = from; i <= to; i++) {
                swap(array, i, from);
                permutation(array, from + 1, to);
                swap(array, i, from);
            }
        }
    }

    public static void swap(char array[], int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
