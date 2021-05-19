package oqg.qifei.entity;

/**
 * @Author Xuhui Lin
 * @Date 2020/9/14 10:32
 * @Description
 */
public class StringCombiner {
    /**
     * 分隔符
     */
    private String delimiter;
    /**
     * 前缀
     */
    private String prefix;
    /**
     * 后缀
     */
    private String suffix;
    private StringBuilder builder;

    public StringCombiner() {
    }

    public StringCombiner(String delimiter, String prefix, String suffix) {
        this.delimiter = delimiter;
        this.prefix = prefix;
        this.suffix = suffix;
    }

    public StringCombiner add(String element) {
        if (areAtStart()) {
            builder.append(prefix);
        } else {
            builder.append(delimiter);
        }
        builder.append(element);
        return this;
    }

    private boolean areAtStart() {
        if(builder == null){
            builder = new StringBuilder();
            return true;
        } else {
            return false;
        }

    }

    public StringCombiner merge(StringCombiner other) {
//        builder = new StringBuilder();
        builder.append(other.builder);
        return this;
    }

    @Override
    public String toString() {
        builder.append(suffix);
        return builder.toString();
    }
}
