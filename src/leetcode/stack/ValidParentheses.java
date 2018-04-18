package leetcode.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    public static boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            switch (c) {
                case '(':
                case '[':
                case '{':
                    stack.push(c);
                    break;
                case ')':
                case ']':
                case '}':
                    if (stack.empty() || map.get(stack.pop()) != c) {
                        return false;
                    }
            }
        }

        return stack.empty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(}]"));
        System.out.println(isValid("([([})])"));
    }
}
