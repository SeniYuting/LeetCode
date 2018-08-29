package qiuzhao.iqiyi;

public class Main1 {
    public static void main(String[] args) {
        System.out.println(decimalToBinary1(15));
        System.out.println(decimalToBinary2(15));
        decimalToBinary3(15);
        decimalToBinary4(15);
    }

    public static int decimalToBinary1(int n) {
        int t = 0;  //用来记录位数
        int bin = 0; //用来记录最后的二进制数
        int r;  //用来存储余数
        while (n != 0) {
            r = n % 2;
            n = n / 2;
            bin += r * (int) Math.pow(10, t);
            t++;
        }
        return bin;
    }

    public static String decimalToBinary2(int n) {
        String str = "";
        while (n != 0) {
            str = n % 2 + str;
            n = n / 2;
        }
        return str;
    }

    public static void decimalToBinary3(int n) {
        for (int i = 31; i >= 0; i--)
            System.out.print(n >>> i & 1);
        System.out.println();
    }

    public static void decimalToBinary4(int n) {
        String result = Integer.toBinaryString(n);
        System.out.println(result);
    }
}
