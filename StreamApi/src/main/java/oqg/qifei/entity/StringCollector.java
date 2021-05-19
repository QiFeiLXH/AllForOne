package oqg.qifei.entity;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * @Author Xuhui Lin
 * @Date 2020/9/14 10:31
 * @Description
 */
public class StringCollector implements Collector<String, StringCombiner, String> {
    /** 分隔符 */
    private String delimiter;
    /** 前缀 */
    private String prefix;
    /** 后缀 */
    private String suffix;
    final Set<Collector.Characteristics> CH_NOID = Collections.emptySet();
    final Set<Collector.Characteristics> CH_ID
            = Collections.unmodifiableSet(EnumSet.of(Collector.Characteristics.IDENTITY_FINISH));
    final Set<Collector.Characteristics> CH_UNORDERED_NOID
            = Collections.unmodifiableSet(EnumSet.of(Collector.Characteristics.UNORDERED));

    public StringCollector() {
    }

    public StringCollector(String delimiter, String prefix, String suffix) {
        this.delimiter = delimiter;
        this.prefix = prefix;
        this.suffix = suffix;
    }

    @Override
    public Supplier<StringCombiner> supplier() {
        return () -> new StringCombiner(delimiter, prefix, suffix);
    }

    @Override
    public BiConsumer<StringCombiner, String> accumulator() {
        return StringCombiner::add;
    }

    @Override
    public BinaryOperator<StringCombiner> combiner() {
        return StringCombiner::merge;
    }

    @Override
    public Function<StringCombiner, String> finisher() {
        return StringCombiner::toString;
    }

    @Override
    public Set<Characteristics> characteristics() {
        //return CH_NOID;
        return CH_NOID;
    }

}
