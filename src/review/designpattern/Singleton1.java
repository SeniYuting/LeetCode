package review.designpattern;

public class Singleton1 {

    // 单线程下的单例模式

    private Singleton1() {

    }

    private static Singleton1 instance;

    public static Singleton1 getInstance() {
        if (instance == null) {
            instance = new Singleton1();
        }
        return instance;
    }

    public static void main(String[] args) {
        Singleton1 single = getInstance();
        System.out.println(single.toString());
    }
}
