package oqg.qifei.entity;

/**
 * @Author Xuhui Lin
 * @Date 2020/9/11 13:23
 * @Description
 */
public interface Child extends Parent{
    @Override
    public default void welcome() {
        message("Child: Hi!");
    }
}
