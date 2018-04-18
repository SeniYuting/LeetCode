package review.sort;

public class HeapSort {

    public static void adjust(int H[], int s, int length) {
        int tmp = H[s];
        int child = 2 * s + 1;
        while (child < length) {
            if (child + 1 < length && H[child] < H[child + 1]) {
                ++child;
            }
            if (H[s] < H[child]) {
                H[s] = H[child];
                s = child;
                child = 2 * s + 1;
            } else {
                break;
            }
            H[s] = tmp;
        }
    }

    public static void print(int H[], int length) {
        for (int j = 0; j < length; j++) {
            System.out.print(H[j] + " ");
        }
        System.out.println("");
    }


    public static void build(int H[], int length) {
        for (int i = (length - 1) / 2; i >= 0; i--) {
            adjust(H, i, length);
        }
    }

    public static void sort(int H[], int length) {
        build(H, length);
        for (int i = length - 1; i > 0; i--) {
            int tmp = H[i];
            H[i] = H[0];
            H[0] = tmp;
            adjust(H, 0, i);
        }
    }

    public static void main(String args[]) {
        int[] H = {2, 5, 7, 1, 3, 4, 6, 9, 10, 8};
        System.out.println("输入：");
        print(H, 10);
        sort(H, 10);
        System.out.println("输出：");
        print(H, 10);
    }

}
