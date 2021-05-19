package oqg.qifei.entity;

/**
 * @Author Xuhui Lin
 * @Date 2020/9/11 13:55
 * @Description
 */
public class OverridingParent extends ParentImpl {
    @Override
    public void welcome() {
        message("Class Parent: Hi!");
    }
}
