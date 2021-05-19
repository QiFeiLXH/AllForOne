package oqg.qifei.entity;

/**
 * @Author Xuhui Lin
 * @Date 2020/9/11 13:14
 * @Description
 */
public interface Person {
    public void message(String body);
    public default void welcome() {
        message("Parent: Hi!");
    }
    public String getLastMessage();
}
