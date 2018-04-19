package niuke.wacai;

// 求数列的和
// https://www.nowcoder.com/practice/02f23a209c0c4d2484e29b560c174de1?tpId=85&tqId=29893&tPage=1&rp=1&ru=/ta/2017test&qru=/ta/2017test/question-ranking

import java.text.DecimalFormat;
import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String line = in.nextLine();
            String[] lineSplit = line.split(" ");
            double n = Integer.parseInt(lineSplit[0]);
            int m = Integer.parseInt(lineSplit[1]);
            double sum = 0.0;
            for (int i = 0; i < m; i++) {
                sum += n;
                n = Math.sqrt(n);
            }
            DecimalFormat df = new DecimalFormat("#.00");
            System.out.println(df.format(sum));
        }
    }
}
