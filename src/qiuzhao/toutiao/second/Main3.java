package qiuzhao.toutiao.second;

// 80% 切字符串，判断是否为合法IP
/**
 * 切割字符串
 * <p>
 * 输入：
 * 8888
 */

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main3 {

    public static int count = 0;
    public static Set<String> ipSet = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        if (s.length() < 4 || s.length() > 12) {
            System.out.println(0);
            return;
        }

        String[] slot = new String[4];
        splitIp(s, 0, 4, slot);

        System.out.println(count);
    }

    private static void splitIp(String s, int index, int size, String[] slot) {
        if (index == size) {
            checkIp(slot);
        } else {
            for (int i = 1; i < 4; i++) {  // 3次切割
                if (index == 3) {
                    if (s.length() > 3 || s.length() == 0) {
                        return;
                    } else {
                        slot[index] = s;
                        splitIp("", index + 1, size, slot);
                    }
                } else {
                    if (i >= s.length()) {
                        return;
                    }
                    String front = s.substring(0, i);
                    String end = s.substring(i);

                    slot[index] = front;
                    splitIp(end, index + 1, size, slot);
                }
            }
        }

    }

    private static void checkIp(String[] slot) {
        boolean good = true;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < slot.length; i++) {
            int num = toInt(slot[i]);
            sb.append(num + ".");
            if (num < 0 || num > 255) {
                good = false;
            }
        }

        System.out.println(sb);

        if (good && !ipSet.contains(sb.toString())) {
            count += 1;
            ipSet.add(sb.toString());
        }
    }

    private static int toInt(String substring) {
        int result = 0;
        int mul = 1;

        for (int i = substring.length() - 1; i >= 0; i--) {
            result += (substring.charAt(i) - '0') * mul;
            mul *= 10;
        }

        return result;
    }
}
