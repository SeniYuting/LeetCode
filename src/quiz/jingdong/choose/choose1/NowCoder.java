package quiz.jingdong.choose.choose1;

import java.util.HashSet;
import java.util.Set;

public class NowCoder {
    public static void main(String[] args) {
        Set<MyClass> set = new HashSet<>();
        set.add(new MyClass(5));
        set.add(new MyClass(2));
        set.add(new MyClass(6));
        System.out.println(set.size());  // 结果：1
    }
}
