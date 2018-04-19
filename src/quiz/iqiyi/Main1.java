package quiz.iqiyi;

import java.util.Scanner;

public class Main1 {

    private static String max = "";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        if (!str.equals("")) {

            char[] sChar = str.toCharArray();
            int maxIndex = 0;
            char maxChar = sChar[0];
            for (int i = 1; i < sChar.length; i++) {
                if (sChar[i] > maxChar) {
                    maxChar = sChar[i];
                    maxIndex = i;
                }
            }

            int length = str.length() - maxIndex;
            int sCharIndex = sChar.length - 1;
            char[] resultChar = new char[length];
            for (int i = 0; i < length; i++) {
                resultChar[i] = sChar[sCharIndex--];
            }

            combine(resultChar);
        }

        System.out.println(max);
    }

    public static void combine(char[] c) {
        int len = c.length;
        int[] used = new int[len];
        char[] temp = new char[len];

        int result = 0;
        while (true) {
            int index = 0;
            // 把连续的1换为0，后面补1
            // 若used[index]为0，则变为1
            while (used[index] == 1) {
                used[index] = 0;
                result--;
                if (++index == len) {
                    return;
                }
            }
            used[index] = 1;
            temp[result++] = c[index];

            String nowStr = new String(temp).substring(0, result);
            if (nowStr.compareTo(max) > 0) {
                max = nowStr;
            }
        }
    }
}
