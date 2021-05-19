package oqg.qifei.entity;

/**
 * @Author Xuhui Lin
 * @Date 2020/9/11 13:17
 * @Description
 */
public class ParentImpl implements Parent {
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
