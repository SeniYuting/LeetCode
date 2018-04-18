package solution.d_title31_40;

/**
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 * 统计前一个
 * 1.     1
 * 2.     11  (1个1)
 * 3.     21 （2个1）
 * 4.     1211 （1个2，1个1）
 * 5.     111221 （1个1，1个2，2个1）
 * 差题~
 */
public class CountAndSay {

    public static String countAndSay(int n) {
        String s = "1";
        for (int i = 1; i < n; i++) {
            String tmp = "";
            int count = 1;
            for (int j = 1; j < s.length(); j++) {
                if (s.charAt(j) == s.charAt(j - 1)) {
                    count++;
                } else {
                    tmp += count + "" + s.charAt(j - 1);
                    count = 1;
                }
            }
            s = tmp + count + "" + s.charAt(s.length() - 1);
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(1));
        System.out.println(countAndSay(2));
        System.out.println(countAndSay(3));
        System.out.println(countAndSay(4));
        System.out.println(countAndSay(5));
    }
}
