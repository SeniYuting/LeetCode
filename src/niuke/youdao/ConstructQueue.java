package niuke.youdao;

// 构造队列
// https://www.nowcoder.com/practice/657d09e2b3704574814089ba8566d98d?tpId=85&tqId=29849&tPage=1&rp=1&ru=/ta/2017test&qru=/ta/2017test/question-ranking

// 类似约瑟夫问题
// 每隔2个数填数

import java.util.Scanner;

public class ConstructQueue {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();

        for (int i = 0; i < num; i++) {
            int number = in.nextInt();
            int[] outputArr = new int[number];
            int index = -1; // 数组下标
            int indexAdd = 0; // 计算报号人数

            // 每隔两个依次填数
            for (int j = 0; j < number; j++) {
                // 循环处理数组下标
                while (true) {
                    index = (index + 1) % number;
                    if (outputArr[index] == 0) {
                        indexAdd++;
                    }
                    if (indexAdd == 2) {
                        indexAdd = 0;
                        break;
                    }
                }
                outputArr[index] = j + 1;
            }

            for (int j = 0; j < number - 1; j++) {
                System.out.print(outputArr[j] + " ");
            }
            System.out.println(outputArr[number - 1]);
        }
    }
}
