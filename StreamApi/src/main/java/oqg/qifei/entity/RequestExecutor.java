package oqg.qifei.entity;

/**
 * @Author Xuhui Lin
 * @Date 2020/9/10 16:46
 * @Description
 */
// 正确的函数式接口
@FunctionalInterface
public interface RequestExecutor {
    Object doExecute() throws RuntimeException;
}
