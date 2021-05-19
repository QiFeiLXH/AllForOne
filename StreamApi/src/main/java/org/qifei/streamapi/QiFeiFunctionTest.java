package org.qifei.streamapi;

import oqg.qifei.entity.QifeiFunction;
import oqg.qifei.entity.RequestExecutor;

/**
 * @Author Xuhui Lin
 * @Date 2020/9/10 14:05
 * @Description
 */
public class QiFeiFunctionTest {
    public static void main(String[] args) {
        String s = "hello";
        templateRequest(() -> s + " world!" );

    }

    public static Integer getAdd(int x, int y, QifeiFunction<Integer, Integer, Integer> myFunction) {
        return myFunction.apply(x, y);
    }

    /**
     * 请求模板
     */
    public static  void templateRequest(RequestExecutor executor) {

        try {

            Object result = executor.doExecute();
            System.out.println(result);

        } catch (Exception e) {
            e.getMessage();
        }
    }
}
