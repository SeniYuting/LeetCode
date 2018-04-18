package quiz.jingdong;

// 马走日字步
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int X = sc.nextInt();
        int Y = sc.nextInt();

        long result = begin(k, X, Y);
        System.out.println(result % 1000000007);
    }

    private static long begin(int k, int x, int y) {
        if (x < 0 || x > 8 || y < 0 || y > 8) {
            return 0;
        }

        if (k == 1) {
            if ((x == 1 && y == 2) || (x == 2 && y == 1)) {
                return 1;
            } else {
                return 0;
            }
        }

        return begin(k - 1, x + 1, y + 2)
                + begin(k - 1, x - 1, y + 2)
                + begin(k - 1, x + 1, y - 2)
                + begin(k - 1, x - 1, y - 2)
                + begin(k - 1, x + 2, y + 1)
                + begin(k - 1, x - 2, y + 1)
                + begin(k - 1, x + 2, y - 1)
                + begin(k - 1, x - 2, y - 1);
    }
}


