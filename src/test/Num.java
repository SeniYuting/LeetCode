package test;

// 最大公约数和最小公倍数
public class Num {
    public static void main(String[] args) {
        System.out.println(max(24, 36));
        System.out.println(min(24, 36));
    }

    //最大公约数 -- 辗转相除
    public static int max(int m, int n) {
        if (m < n) {   //保证m>n
            int temp = n;
            n = m;
            m = temp;
        }
        if (m % n == 0) {
            return n;
        }
        return max(n, m % n);
    }

    //最小公倍数
    public static int min(int m, int n) {
        return m * n / max(m, n);
    }
}
