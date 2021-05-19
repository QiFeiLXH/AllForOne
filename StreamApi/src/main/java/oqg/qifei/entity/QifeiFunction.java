package oqg.qifei.entity;

/**
 * @Author Xuhui Lin
 * @Date 2020/9/10 13:59
 * @Description
 */

@FunctionalInterface
public interface QifeiFunction<T, U, R> {
    R apply(T t, U u);
//    default R apply1(T t, U u) {
//        return null;
//    };
}
