package review.system;

public class BitOperation {

    public static void main(String[] args) {
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        int c = (a + b) >>> 1;  // 无符号右移
        System.out.println(Integer.MAX_VALUE);
        System.out.println(c);

        int d = (a + b) / 2;
        System.out.println(d);

        c = 1;
        int e = a = c;
        System.out.println(e);
        System.out.println(a);

    }

}
