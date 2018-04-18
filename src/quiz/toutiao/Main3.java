package quiz.toutiao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s = in.nextLine();

        int Q = Integer.parseInt(in.nextLine());

        String[] lines = new String[Q];
        for (int i = 0; i < Q; i++) {
            lines[i] = in.nextLine();
        }

        s = s.toLowerCase();
        StringBuffer sb = new StringBuffer();
        List<Integer> list = new ArrayList<>();
        char c = s.charAt(0);
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (c == s.charAt(i)) {
                count++;
            } else {
                sb.append(c);
                list.add(count);
                c = s.charAt(i);
                count = 1;
            }
        }
        sb.append(c);
        list.add(count);

        s = sb.toString();

        for (int i = 0; i < Q; i++) {
            System.out.println(countStep(s, list, lines[i]));
        }
    }

    private static int countStep(String steps, List<Integer> list, String s) {
        int count = 0;
        String[] ssplit = s.split(" ");
        int N = Integer.parseInt(ssplit[0]);
        int M = Integer.parseInt(ssplit[1]);
        int X = Integer.parseInt(ssplit[2]);
        int Y = Integer.parseInt(ssplit[3]);

        for (int i = 0; i < steps.length(); i++) {
            int length;
            switch (steps.charAt(i)) {
                case 'u':
                    length = list.get(i);
                    count += length;
                    X -= length;
                    if (X <= 0) {
                        return count + X;
                    }
                    break;
                case 'd':
                    length = list.get(i);
                    count += length;
                    X += length;
                    if (X >= N + 1) {
                        return count + N + 1 - X;
                    }
                    break;
                case 'r':
                    length = list.get(i);
                    count += length;
                    Y += length;
                    if (Y >= M + 1) {
                        return count + M + 1 - Y;
                    }
                    break;
                case 'l':
                    length = list.get(i);
                    count += length;
                    Y -= length;
                    if (X <= 0) {
                        return count + Y;
                    }
                    break;
                default:
                    return count;
            }
        }
        return count;
    }


}
