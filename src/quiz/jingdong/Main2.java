package quiz.jingdong;

// 输出X*Y=N

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        long[] numbers = new long[t];

        for (int i = 0; i < t; i++) {
            numbers[i] = sc.nextLong();
        }

        for (int i = 0; i < t; i++) {
            if (numbers[i] % 2 == 0) {
                long num = numbers[i];
                long a = 2;
                long b = num / 2;
                while (b % 2 == 0) {
                    a = a * 2;
                    b = b / 2;
                }
                System.out.println(b + " " + a);
            } else {
                System.out.println("No");
            }
        }
    }
}
