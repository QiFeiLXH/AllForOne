package oqg.qifei.entity;

/**
 * @Author Xuhui Lin
 * @Date 2020/9/11 13:48
 * @Description
 */
public class ChildImpl implements Child {
    String message;
    @Override
    public void message(String body) {
        this.message = body;
    }

    @Override
    public String getLastMessage() {
        return this.message;
    }
}
