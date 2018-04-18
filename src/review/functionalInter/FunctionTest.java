package review.functionalInter;

@FunctionalInterface
public interface FunctionTest<T, U> {
    T test(U u); // 仅一个抽象接口

    default void hello() {
        // 默认方法不是抽象
    }
}
