package quiz.zhaohang;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * 定义left和right分别表示剩余左右括号的个数 若剩余（左>右），则非法 若剩余（左=0&&右=0），则合法 若剩余（左>0||右>0），则递归
 *
 */
public class Test2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        List<String> result = generate(num);
        for (int i = 0; i < result.size() - 1; i++) {
            System.out.print(result.get(i) + ",");
        }
        System.out.println(result.get(result.size() - 1));
    }

    public static List<String> generate(int n) {
        List<String> result = new ArrayList();
        generateDFS(n, n, "", result);
        return result;
    }

    public static void generateDFS(int left, int right, String out, List<String> result) {
        if (left < 0 || right < 0 || left > right) {
            return;
        }
        if (left == 0 && right == 0) {
            result.add(out);
            return;
        }
        generateDFS(left - 1, right, out + "(", result);
        generateDFS(left, right - 1, out + ")", result);
    }

}
