package oqg.qifei.entity;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

import static java.util.stream.Collector.Characteristics.IDENTITY_FINISH;
import static java.util.stream.Collector.Characteristics.UNORDERED;

/**
 * @Author Xuhui Lin
 * @Date 2020/9/14 11:21
 * @Description
 */
public class MyCollector<T> implements Collector<T, Set<T>, Set<T>> {


    @Override
    public Supplier supplier() {
        System.out.println("suppliier invoked!");
        return HashSet::new;
    }

    @Override
    public BiConsumer<Set<T>, T> accumulator() {
        System.out.println("accmulator invoked!");

        return Set::add;
//        return HashSet::add;// 不可以写这个，因为类型可能与supplier中的类型冲突
    }

    @Override
    public BinaryOperator<Set<T>> combiner() {
        System.out.println("combiner invoked!");

        return (set1, set2) -> {
            set1.addAll(set2);
            return set1;
        };
    }

    // 声明 IDENTITY_FINISH 后方法不会执行，默认是Java底层自动实现。
    @Override
    public Function<Set<T>,Set<T>> finisher() {
        System.out.println("finisher invoked!");
//        return t -> t;
//        return Function.identity();
        throw new UnsupportedOperationException();
    }

    @Override
    public Set<Characteristics> characteristics() {
        System.out.println("characteristics invoked");
        return Collections.unmodifiableSet(EnumSet.of(IDENTITY_FINISH, UNORDERED));
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "welcome", "hello");
        Set<String> collect = list.stream().collect(new MyCollector<>());
        System.out.println(collect);
    }
}
