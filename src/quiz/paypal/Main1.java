package quiz.paypal;

import java.util.Scanner;

// 十六进制变十进制
// 输入：0:001:000:02:0000:A:FFFF:FFFF
// 输出：1 2 10 -1

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] ss = s.split(":");
        String s1 = ss[0] + ss[1];
        String s2 = ss[2] + ss[3];
        String s3 = ss[4] + ss[5];
        String s4 = ss[6] + ss[7];

        String out = getNumber(s1) + " " + getNumber(s2)
                + " " + getNumber(s3) + " " + getNumber(s4);
        System.out.println(out);
    }

    public static int getNumber(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            int num = Integer.parseInt(s.charAt(i) + "", 16);
            result = result * 16 + num;
        }
        return result;
    }
}
