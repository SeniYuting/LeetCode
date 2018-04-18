package niuke.wangyi;

// 下厨房
// https://www.nowcoder.com/practice/ca5c9ba9ebac4fd5ae9ba46114b0f476?tpId=85&tqId=29832&tPage=1&rp=1&ru=/ta/2017test&qru=/ta/2017test/question-ranking

import java.util.HashSet;
import java.util.Scanner;

public class Kitchen {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashSet<String> set = new HashSet<>();

        while (in.hasNext()) {
            String line = in.nextLine();
            String[] arr = line.split(" ");
            for (int i = 0; i < arr.length; i++) {
                set.add(arr[i]);
            }
        }

        System.out.println(set.size());
    }
}
