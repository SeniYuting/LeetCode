package review.system;

// 进制问题
public class SystemTransfer {

    // num为123，即：3 * 2^0 + 2 * 2^1 + 1 * 2^2 = 11
    public static int getResult(int[] num) {
        int res = 0;
        for (int i = 0; i < num.length; i++) {
            res = res * 2 + num[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] num = {1, 2, 3};
        System.out.println(getResult(num));
    }
}
