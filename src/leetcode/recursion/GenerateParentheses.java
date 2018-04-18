package leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 */
public class GenerateParentheses {

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(n, n, "", result);
        return result;
    }

    public static void generate(int left, int right, String out, List<String> res) {
        if (left < 0 || right < 0 || left > right) {
            return;
        }

        if (left == 0 && right == 0) {
            res.add(out);
            return;
        }

        generate(left - 1, right, out + "(", res);
        generate(left, right - 1, out + ")", res);
    }

    public static void main(String[] args) {
        List<String> result = generateParenthesis(3);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

}
