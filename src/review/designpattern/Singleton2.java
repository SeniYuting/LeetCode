package review.designpattern;

public class Singleton2 {

    // 多线程下的单例模式
    // 1. 给getInstance()加锁，synchronized关键字，可以解决问题，但影响性能
    // 2. 如下，类仅加载一次，∴ new Singleton2()仅执行一次

    private Singleton2() {

    }

    private static class SingletonContainer {
        private static Singleton2 instance = new Singleton2();
    }

    public static Singleton2 getInstance() {
        return SingletonContainer.instance;
    }

    public static void main(String[] args) {
        Singleton2 single = getInstance();
        System.out.println(single.toString());
    }
}