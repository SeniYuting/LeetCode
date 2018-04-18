package quiz.jingdong;

import java.util.Scanner;
import java.util.Stack;

public class Main3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();

        for (int i = 0; i < num; i++) {
            String s = in.next();

            boolean isMore = false;
            int left = 0, right = 0;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '(') {
                    left++;
                } else if (s.charAt(j) == ')') {
                    right++;
                } else {
                    isMore = true;
                }
            }

            if (left != right || isMore) {
                System.out.println("No");
                continue;
            }

            boolean isOK = false;

            for (int j = 0; j < s.length() - 1; j++) {
                for (int k = j + 1; k < s.length(); k++) {
                    char[] sc = s.toCharArray();
                    if (sc[j] == sc[k]) {
                        continue;
                    }
                    char temp = sc[j];
                    sc[j] = sc[k];
                    sc[k] = temp;
                    if (isValid(sc)) {
                        isOK = true;
                        System.out.println("Yes");
                        break;
                    }
                }
                if (isOK) {
                    break;
                }
            }

            if (!isOK) {
                System.out.println("No");
            }
        }

    }

    public static boolean isValid(char[] sc) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < sc.length; i++) {
            Character c = sc[i];
            switch (c) {
                case '(':
                    stack.push(c);
                    break;
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
            }
        }

        return stack.isEmpty();
    }
}
