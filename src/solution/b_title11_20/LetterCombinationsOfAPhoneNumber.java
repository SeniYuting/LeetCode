package solution.b_title11_20;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a digit string, return all possible letter combinations that the number
 * could represent.
 * <p>
 * 电话号码组合
 * <p>
 * 好题~，思路：组合
 */
public class LetterCombinationsOfAPhoneNumber {

    public static List<String> list = new ArrayList();
    public static String[] keyboard = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static List<String> letterCombinations(String digits) {

        if (digits == null || digits.equals("")) {
            return list;
        }

        StringBuilder result = new StringBuilder();
        buildResult(digits, 0, result);

        return list;
    }

    public static void buildResult(String digits, int index, StringBuilder result) {
        if (index == digits.length()) {
            list.add(result.toString());
            return;
        }

        int num = digits.charAt(index) - '0';
        String key = keyboard[num];
        for (int i = 0; i < key.length(); i++) {
            result.append(key.charAt(i));
            buildResult(digits, index + 1, result);
            result.deleteCharAt(result.length() - 1);
        }

    }

    public static void main(String[] args) {
        List<String> result = letterCombinations("23");
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }
    }

}
