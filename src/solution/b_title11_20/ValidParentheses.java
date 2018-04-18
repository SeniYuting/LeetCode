package solution.b_title11_20;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 
 * Given a string containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid. The brackets must close in the
 * correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * 
 * 好题~ Stack的使用
 *
 */
public class ValidParentheses {

	public static boolean isValid(String s) {

		Map<Character, Character> map = new HashMap();
		map.put('(', ')');
		map.put('[', ']');
		map.put('{', '}');

		Stack<Character> stack = new Stack();
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
				if (stack.isEmpty() || map.get(stack.pop()) != c) {
					return false;
				}
			}
		}

		return stack.isEmpty();
	}

	public static void main(String[] args) {
		System.out.println(isValid("()[]{}"));
		System.out.println(isValid("(}]"));
		System.out.println(isValid("([([})])"));
	}
}
