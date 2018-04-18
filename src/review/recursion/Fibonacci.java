package review.recursion;

public class Fibonacci {

    public static int num = 5;

    public static void main(String[] args) {
        System.out.println(fibonacci(num));
        System.out.println(fibonacci2(num));
        System.out.println(fibonacci3(num));
    }

    static int fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    // 非递归
    static int fibonacci2(int n) {
        if (n == 0 || n == 1) {
            return n;
        } else {
            int a = 1, b = 1, res = 0;
            for (int i = 2; i < n; i++) {
                res = a + b;
                a = b;
                b = res;
            }
            return res;
        }
    }

    // 动态规划
    static int[] arr = new int[num + 1];

    static int fibonacci3(int n) {
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }

}
