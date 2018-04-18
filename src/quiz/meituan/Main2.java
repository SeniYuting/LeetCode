package quiz.meituan;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        int[] ints = new int[10];

        for (int i = 0; i < s.length(); i++) {
            ints[s.charAt(i) - '0'] ++;
        }

        int min = 0;

        for (int j = 1; j < 10; j++) {
            if (ints[j] == 0) {
                System.out.println(j);
                return;
            }

            if (ints[j] < ints[min]) {
                min = j;
            }
        }

        StringBuilder sb = new StringBuilder();
        if (min == 0) {
            sb.append('1');
            for (int k = 0; k <= ints[min]; k++) {
                sb.append(min);
            }
        } else {
            for (int k = 0; k <= ints[min]; k++) {
                sb.append(min);
            }
        }

        System.out.println(sb.toString());

        // 0001222333444555666777888999
    }
}
