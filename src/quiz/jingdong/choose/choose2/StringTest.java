package quiz.jingdong.choose.choose2;

/**
 * 对于字符串而言
 * ==比较两个对象在内存中的首地址
 * equals()比较字符串中所包含内容是否相等
 */
public class StringTest {

    public static void main(String[] args) {
        String s1 = "abc" + "def";
        String s2 = new String(s1);
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));

        String s3 = "abc";
        String s4 = "abc";
        System.out.println(s3 == s4);
        System.out.println(s3.equals(s4));

        String s5 = "abc";
        String s6 = "ab" + "c";
        System.out.println(s5 == s6);
        System.out.println(s5.equals(s6));
    }

}
