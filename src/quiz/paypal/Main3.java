package quiz.paypal;

// 比较差异

/**
 * 输入：
 * 3 3
 * a
 * b
 * c
 * xx
 * yy
 * c
 * <p>
 * 输出：
 * -a
 * -b
 * +xx
 * +yy
 * c
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num1 = in.nextInt();
        int num2 = in.nextInt();

        String[] s1 = new String[num1];
        String[] s2 = new String[num2];

        for (int i = 0; i < num1; i++) {
            s1[i] = in.next();
        }

        for (int i = 0; i < num2; i++) {
            s2[i] = in.next();
        }

        ArrayList<String> result = new ArrayList<>();
        int num = num1 < num2 ? num1 : num2;
        for (int i = 0; i < num; i++) {
            if (!s1[i].equals(s2[i])) {
                result.add("-" + s1[i]);
                result.add("+" + s2[i]);
            } else {
                result.add(" " + s1[i]);
            }
        }

        if (num1 < num2) {
            for (int i = num1; i < num2; i++) {
                result.add("+" + s2[i]);
            }
        } else if (num1 > num2) {
            for (int i = num2; i < num1; i++) {
                result.add("-" + s1[i]);
            }
        }

        result.sort(new MyComparator());

        for (int i = result.size() - 1; i >= 0; i--) {
            System.out.println(result.get(i));
        }

    }

    static class MyComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            return a.charAt(0) < b.charAt(0) ? -1 : a.charAt(1) > b.charAt(1) ? -1 : 0;
        }
    }
}
