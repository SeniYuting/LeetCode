package qiuzhao.zhaohang;

/**
 * 好题
 * Leetode 838
 * 前加L，后加R
 * L...L左边，，R...R右边，L...R不变，R...L处理
 */

public class Main1 {
    public static void main(String[] args) {
        String dominoes = ".R....R.....LR....L.";
        System.out.println(pushDominoes(dominoes));
    }

    public static String pushDominoes(String dominoes) {
        dominoes = "L" + dominoes + "R";
        char[] dominoesChar = dominoes.toCharArray();
        int length = dominoes.length();

        int from = 0, to;
        char fromChar = 'L', toChar;
        for (int i = 1; i < length; i++) {
            char c = dominoesChar[i];
            if (c != '.') {
                to = i;
                toChar = c;
                handle(dominoesChar, from, to, fromChar, toChar);
                from = to;
                fromChar = toChar;
            }

        }

        return String.valueOf(dominoesChar, 1, length - 2);
    }

    public static void handle(char[] dominoesChar, int from, int to, char fromChar, char toChar) {
        if (fromChar == toChar) { // LL or RR
            for (int i = from; i < to; i++) {
                dominoesChar[i] = fromChar;
            }
        } else if (fromChar > toChar) {  // RL
            for (int i = from; i < to; i++) {
                if (i < to - i + from) {
                    dominoesChar[i] = 'R';
                    dominoesChar[to - i + from] = 'L';
                } else {
                    break;
                }
            }
            if ((to - from) % 2 == 0) {
                dominoesChar[(to + from) / 2] = '.';
            }
        }
    }
}
