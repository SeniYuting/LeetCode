package solution.f_title51_60;

/**
 * 例：
 * Input: Hello World
 * Output: 5
 */
public class LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        String[] sArray = s.split(" ");
        if (sArray == null || sArray.length == 0) {
            return 0;
        }
        return sArray[sArray.length - 1].length();
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World"));
    }
}
