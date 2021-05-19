package org.qifei.test;

import org.springframework.stereotype.Service;

/**
 * @Author Xuhui Lin
 * @Date 2020/12/28 15:10
 * @Description
 */
@Service
public class CustomServiceImpl implements CustomService {
    @Override
    public Integer queryOne() {
        System.out.println(System.currentTimeMillis());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 1;
    }

    @Override
    public Integer queryTwo() {
        System.out.println(System.currentTimeMillis());try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 2;
    }
}
