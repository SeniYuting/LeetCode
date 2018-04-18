package niuke.haoweilai;

// n个数里出现次数大于等于n/2的数
// https://www.nowcoder.com/practice/eac8c671a0c345b38aa0c07aba40097b?tpId=85&tqId=29866&tPage=1&rp=1&ru=/ta/2017test&qru=/ta/2017test/question-ranking

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NInteger {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();

        String[] ss = s.split(" ");
        int len = ss.length;

        Map<String, Integer> map = new HashMap<>();
        for (String sNum : ss) {
            if (map.containsKey(sNum)) {
                map.put(sNum, map.get(sNum) + 1);
            } else {
                map.put(sNum, 1);
            }
        }

        for (Map.Entry<String, Integer> m : map.entrySet()) {
            if (m.getValue() >= len / 2) {
                System.out.println(m.getKey());
            }
        }
    }
}
