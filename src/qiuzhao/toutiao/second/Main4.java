package qiuzhao.toutiao.second;

// 100%
/**
 * 输入：
 * 3
 * 197 130 1
 * 三个8位二进制数即：11000101，10000010，00000001
 */

import java.util.Scanner;

public class Main4 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = Integer.parseInt(in.nextLine());
        String[] line = in.nextLine().split(" ");

        for (int i = 0; i < num; i++) {
            line[i] = decimalToBinary(Integer.parseInt(line[i]));
        }

        System.out.println(isLegal(line) ? 1 : 0);
    }

    public static String decimalToBinary(int n) {
//        Integer.toBinaryString(n).substring(...) 0开头则结果置空处理过  5：101
        StringBuilder sb = new StringBuilder();
        for (int i = 7; i >= 0; i--)
            sb.append(n >>> i & 1);
        return sb.toString();
    }

    public static boolean isLegal(String[] line) {
        boolean legal = true;

        for (int i = 0; i < line.length; i++) {
            String indexLine = line[i];
            if (indexLine.startsWith("11111") || indexLine.startsWith("10")) {
                legal = false;
            }
            if (indexLine.startsWith("110") && !line[++i].startsWith("10")) {
                legal = false;
            }
            if (indexLine.startsWith("1110") && !(line[++i].startsWith("10") && line[++i].startsWith("10"))) {
                legal = false;
            }
            if (indexLine.startsWith("11110") && !(line[++i].startsWith("10") && line[++i].startsWith("10") && line[++i].startsWith("10"))) {
                legal = false;
            }
            if (!legal) {
                break;
            }
        }

        return legal;
    }

}
