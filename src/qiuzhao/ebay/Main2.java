package qiuzhao.ebay;

// input:
// 3
// 0 0 10

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] line = sc.nextLine().split(" ");

        int[] boxes = new int[n];
        for (int i = 0; i < n; i++) {
            boxes[i] = Integer.parseInt(line[i]);
        }
        Arrays.sort(boxes);

        System.out.println(countCol(boxes, n));
    }

    private static int countCol(int[] boxes, int n) {
        int count = 0;
        for (int i = n - 1; i >= 0; i--) {
            int topMin = boxes[i];
            while (i > 0 && topMin > 0) {
                topMin = Math.min(topMin - 1, boxes[i - 1]);
                i--;
            }
            count++;
        }

        return count;
    }
}
