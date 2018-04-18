package review.permcomb;

// 打印出所有组合
// 与01字符串映射
public class Combine {

    public static void combine(char[] c) {
        int len = c.length;
        int[] used = new int[len];
        char[] temp = new char[len];

        int result = 0;
        while (true) {
            int index = 0;
            // 把连续的1换为0，后面补1
            // 若used[index]为0，则变为1
            while (used[index] == 1) {
                used[index] = 0;
                result--;
                if (++index == len) {
                    return;
                }
            }
            used[index] = 1;
            temp[result++] = c[index];
            for (int i = 0; i < len; i++) {
                System.out.print(used[i]);
            }
            System.out.println(" " + new String(temp).substring(0, result));
        }
    }

    public static void main(String[] args) {
        String s = "abc";
        char[] c = s.toCharArray();
        combine(c);
    }
}
