package solution.f_title51_60;

import java.util.ArrayList;
import java.util.List;

/**
 * 求[1,2,3,...,n]按序排列的第k项
 * 思路：
 * n个数有n!种排列，n-1个数有(n-1)!种排列
 * 对于n位数而言，每一个不同的最高位，后面可以拼接(n-1)!种排列
 * 按每组(n-1)!分组
 * 利用k(n-1)!取得最高位在数列中的index
 */
public class PermutationSequence {
    public static String getPermutation(int n, int k) {
        k--; // 从0开始计数，而不是1

        List<Integer> numList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numList.add(i);
        }

        int factorial = 1;
        for (int i = 2; i < n; i++) {
            factorial *= i;
        }

        String res = "";
        int times = n - 1;
        while (times >= 0) {
            int indexInList = k / factorial;
            res += numList.get(indexInList);
            numList.remove(indexInList);

            k %= factorial;
            if (times != 0) {
                factorial /= times;
            }

            times--;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(getPermutation(3, 2));
    }
}
