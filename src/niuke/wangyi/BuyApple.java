package niuke.wangyi;

import java.util.Scanner;

public class BuyApple {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int result = -1;
        if (n % 2 != 1) {

            int remainder = n % 8;
            switch (remainder) {
                case 0:
                    result = n / 8;
                    break;
                case 2:
                    if (n >= 18) {
                        // 将8，8，2换成6，6，6
                        result = n / 8 + 1;
                    }
                    break;
                case 4:
                    if (n >= 12) {
                        // 将8，4换成6，6
                        result = n / 8 + 1;
                    }
                    break;
                case 6:
                    result = n / 8 + 1;
                    break;
            }
        }

        System.out.println(result);
    }

}
