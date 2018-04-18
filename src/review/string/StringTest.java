package review.string;

import java.util.Arrays;

public class StringTest {

    public static void main(String[] args) {

        String s1 = "abcde";
        int index = s1.indexOf("bc");
        System.out.println(index);

        String s2 = "a|bc|d";
        String[] sp = s2.split("\\|", 2);
        for (String ssp : sp) {
            System.out.print(ssp + " ");
        }
        System.out.println();

        char[] array = "abc".toCharArray();

        String s = "321";
        // sort
        char[] ch = s.toCharArray();
        Arrays.sort(ch);
        System.out.println("ch: " + new String(ch));

        String newS = s.concat("234");
        System.out.println("s: " + s);
        System.out.println("newS: " + newS);
        String newS2 = s.replace('1', '5');
        System.out.println("s: " + s);
        System.out.println("newS2: " + newS2);

        // 重要
        // 字面量赋值创建字符串：在常量池中查找是否已经存在相同的字符串
        // 若已经存在，将栈中引用指向该字符串
        // 若不存在，在常量池中生成一个字符串，将栈中引用指向该字符串
        String str1 = "string";
        // new创建字符串：在堆中生成字符串对象，栈中的引用指向该对象
        String str2 = new String("string");
        // intern()，将堆中的字符串对象对应的字符串添加到常量池中，并返回指向该常量的引用
        String str3 = str2.intern();
        // str4解释器到执行器 （）+（）
        // 而两个String常量相加，解释器到执行器有优化，合并为一个常量
        String str4 = new String("str").intern() + new String("ing").intern();

        // str1指向的是字符串中的常量，str2是在堆中生成的对象，所以str1==str2返回false
        System.out.println(str1 == str2); //false
        // str2调用intern方法，会将str2中值（“string”）复制到常量池中，但是常量池中已经存在该字符串（即str1指向的字符串）
        // 所以直接返回该字符串的引用，因此str1==str2返回true
        System.out.println(str1 == str3); //true
        System.out.println("----" + (str1 == str4)); // false
    }
}
