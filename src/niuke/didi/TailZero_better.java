package niuke.didi;

import java.util.Scanner;

public class TailZero_better {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();

        int count = 0;
        while (num > 0) {
            count += num / 5;
            num /= 5;
        }

        System.out.println(count);
    }
}
