package niuke.wangyi;

// 数列还原
// https://www.nowcoder.com/practice/b698e67a2f5b450a824527e82ed7495d?tpId=85&tqId=29837&tPage=1&rp=1&ru=/ta/2017test&qru=/ta/2017test/question-ranking

import java.util.Scanner;

public class Restore {
    static int[] nums;
    static boolean[] bitflag;
    static int k;
    static int sum = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        k = in.nextInt();
        nums = new int[n];
        boolean[] flag = new boolean[n];
        bitflag = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
            if (nums[i] != 0) {
                flag[nums[i] - 1] = true;
                bitflag[i] = true;
                count++;
            }
        }

        int notcount = n - count;
        int[] notnums = new int[notcount];
        for (int i = 0; i < n; i++) {
            if (!flag[i]) {
                notnums[--notcount] = i + 1;
            }
        }

        permutation(notnums, 0, n - count - 1);
        System.out.println(sum);

    }

    public static void permutation(int[] array, int from, int to) {
        if (from == to) {
            int j = 0;
            for (int i = 0; i < nums.length; i++) {
                if (!bitflag[i]) {
                    nums[i] = array[j++];
                }
            }

            int count = 0;
            for (int m = 0; m < nums.length - 1; m++) {
                for (int n = m + 1; n < nums.length; n++) {
                    if (nums[m] < nums[n]) {
                        count++;
                    }
                }
            }

            if (count == k) {
                sum++;
            }
        } else {
            for (int i = from; i <= to; i++) {
                swap(array, i, from);
                permutation(array, from + 1, to);
                swap(array, i, from);
            }
        }
    }

    public static void swap(int array[], int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
