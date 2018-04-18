package quiz.zhaohang;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test3 {

    // 以100为例
    // 两个数里面，最大的是50*50
    // 分解一下，三个数里面，最大的是25*25*50
    // 12*13*25*50
    // 6*6*13*25*50
    // 3*3*6*13*25*50
    // 所以，一个数：3*3*3*...*4
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n < 2) {
            System.out.println(1);
        }
        if (n < 5) {
            System.out.println(n);
        }

        List<Integer> list = new ArrayList<>();
        while (n > 4) {
            list.add(3);
            n -= 3;
        }
        list.add(n);

        long l = 1;
        for (int i = 0; i < list.size(); i++) {
            l *= list.get(i);
        }

        System.out.println(l);
    }
}
