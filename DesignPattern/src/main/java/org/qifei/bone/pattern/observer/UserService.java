package org.qifei.bone.pattern.observer;

import java.sql.SQLException;

/**
 * @Author Xuhui Lin
 * @Date 2021/1/26 10:55
 * @Description
 */
public interface UserService {
    void register(String personId) throws SQLException;
}
