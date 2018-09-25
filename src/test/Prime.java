package test;

// 素数筛，判断素数
public class Prime {
    public static void main(String[] args) {
        System.out.println(isPrime(71) == 1);
    }

    //判断是否是一个素数
    public static int isPrime(int a) {
        //0,1，负数都是非素数
        if (a <= 1) {
            return 0;
        }
        //计算枚举上界
        int bound = (int) Math.sqrt(a) + 1;
        for (int i = 2; i < bound; i++) {
            //依次枚举这些数能否整除x，若能则必不是素数
            if (a % i == 0) {
                return 0;
            }
        }
        return 1;
    }
}
