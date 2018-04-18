package review.designpattern;

public class Singleton1 {

    // 单线程下的单例模式

    private Singleton1() {

    }

    private static Singleton1 singleton2;

    public static Singleton1 getInstance() {
        if (singleton2 == null) {
            singleton2 = new Singleton1();
        }
        return singleton2;
    }

    public static void main(String[] args) {
        Singleton1 single = getInstance();
        System.out.println(single.toString());
    }
}
