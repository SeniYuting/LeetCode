package review.functionalInter;

import java.util.HashSet;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        // 函数式接口-->返回函数的引用（指针），将整个过程解耦（业务逻辑部分仅处理逻辑）
        // 参数是String 返回类型是String[]的split方法
        // 仅定义该方法的接口，可以自定义实现
        FunctionTest<String[], String> t1 = "123 321"::split;
        String[] s = t1.test(" "); // test的参数是：split的参数
        System.out.println(s[0] + "|" + s[1]);

        FunctionTest<String[], Integer> t2 = String[]::new;
        String[] s2 = t2.test(3);  // test的参数是：new的参数
        System.out.println(s2.length);

        // set
        Set<String> set = new HashSet<>();
        set.add("seni");
        set.add("victor");
        set.add("baby");
        set.stream()
                .map(String::toUpperCase)
                .sorted((a, b) -> a.compareTo(b))
                .forEach(System.out::println);
    }
}
