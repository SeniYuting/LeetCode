package review.system;

public class BinarySystemOne {

    public static void main(String[] args) {
        System.out.println(countOne(8));
        System.out.println(countOne(7));
        System.out.println(countOne(6));
    }

    // 求二进制中1的个数
    public static int countOne(int n) {
        int count = 0;
        while (n > 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }

}
