package test.test2;

import test.test1.TestClass;

// 匿名内部类
// 调用其他包中类的的protected方法

public class TestInner {
    public static void main(String[] args) {
        new TestClass() {
            void callParentTest() {
                super.test();
            }
        }.callParentTest();
    }
}
