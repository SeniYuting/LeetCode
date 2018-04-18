package solution.c_title21_30;

/**
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */
public class ImplementStrStr {

    public static int strStr(String haystack, String needle) {

        if(needle.isEmpty()) {
            return 0;
        }

        int haystackLen = haystack.length();
        int needleLen = needle.length();

        if (haystackLen < needleLen) {
            return -1;
        }

        for (int i = 0; i <= haystackLen - needleLen; i++) {
            for (int j = 0; j < needleLen; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
                if (j == needleLen - 1) {
                    return i;
                }
            }

        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("hello", "ll"));
        System.out.println(strStr("aaaaa", "bba"));
        System.out.println(strStr("", ""));
        System.out.println(strStr("a", "a"));
    }
}
