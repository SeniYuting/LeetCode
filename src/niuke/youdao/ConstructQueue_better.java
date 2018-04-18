package niuke.youdao;

import java.util.LinkedList;
import java.util.Scanner;

public class ConstructQueue_better {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();

        for (int i = 0; i < num; i++) {
            int number = in.nextInt();
            LinkedList<Integer> res = analyze(number);
            for (int j = 0; j < res.size() - 1; j++) {
                System.out.print(res.get(j) + " ");
            }
            System.out.println(res.get(number - 1));
        }
    }

    // 逆向思维
    // 按题目意思，从后往前，有32，将3从队头拿到队尾，取出队头
    // 反过来，将队头插在前面，将3从队尾拿到队头
    public static LinkedList<Integer> analyze(int number) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = number; i > 0; i--) {
            list.addFirst(i);
            list.addFirst(list.removeLast());
        }
        return list;
    }
}
