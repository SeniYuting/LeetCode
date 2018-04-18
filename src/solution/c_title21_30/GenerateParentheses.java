package solution.c_title21_30;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 * <p>
 * 好题~ 递归
 * <p>
 * 定义left和right分别表示剩余左右括号的个数 若剩余（左>右），则非法 若剩余（左=0&&右=0），则合法 若剩余（左>0||右>0），则递归
 */
public class GenerateParentheses {

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList();
        generateParenthesisDFS(n, n, "", result);
        return result;
    }

    public static void generateParenthesisDFS(int left, int right, String out, List<String> result) {
        if (left < 0 || right < 0 || left > right) {
            return;
        }
        if (left == 0 && right == 0) {
            result.add(out);
            return;
        }
        generateParenthesisDFS(left - 1, right, out + "(", result);
        generateParenthesisDFS(left, right - 1, out + ")", result);
    }

    public static void main(String[] args) {
        List<String> result = generateParenthesis(3);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

}
