package review.classhandler;

public class OuterClass {

    private int num = 10;

    //内部类
    private class TestInner {
        private int inner_num = 0;
        public void showInner() {
            //内部类可以访问外部类的私有成员
            System.out.println(num);
        }

    }

    public void show() {
        TestInner ti = new TestInner();
        ti.showInner();
        // 外部类可以访问内部类的私有成员
        System.out.println(ti.inner_num);
    }

    public static void main(String[] args) {
        new OuterClass().show();
    }

}
