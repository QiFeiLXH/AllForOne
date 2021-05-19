package org.qifei.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.qifei.entity.UserInfo;
import org.qifei.service.UserInfoService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;

/**
 * @BelongsProject: AllForOne
 * @BelongsPackage: org.qifei.service.impl
 * @Author: QiFei
 * @CreateTime: 2020-03-26 16:10
 * @Description:
 */
@Slf4j
@Service
@CacheConfig(cacheNames = "caffeineCacheManager")
public class UserInfoServiceImpl implements UserInfoService {
    /**
     * 模拟数据库存储数据
     */
    private HashMap<Integer, UserInfo> userInfoMap = new HashMap<>();

    @Override
    @CachePut(key = "#userInfo.id")
    public void addUserInfo(UserInfo userInfo) {
        userInfoMap.put(userInfo.getId(), userInfo);
    }

    @Override
    @Cacheable(key = "#id")
    public UserInfo getByName(Integer id) {
        return userInfoMap.get(id);
    }

    @Override
    @CachePut(key = "#userInfo.id")
    public UserInfo updateUserInfo(UserInfo userInfo) {
        if (!userInfoMap.containsKey(userInfo.getId())) {
            return null;
        }
        // 取旧的值
        UserInfo oldUserInfo = userInfoMap.get(userInfo.getId());
        // 替换内容
        if (!StringUtils.isEmpty(oldUserInfo.getAge())) {
            oldUserInfo.setAge(userInfo.getAge());
        }
        if (!StringUtils.isEmpty(oldUserInfo.getName())) {
            oldUserInfo.setName(userInfo.getName());
        }
        if (!StringUtils.isEmpty(oldUserInfo.getSex())) {
            oldUserInfo.setSex(userInfo.getSex());
        }
        // 将新的对象存储，更新旧对象信息
        userInfoMap.put(oldUserInfo.getId(), oldUserInfo);
        // 返回新对象信息
        return oldUserInfo;
    }

    @Override
    @CacheEvict(key = "#id")
    public void deleteById(Integer id) {
        userInfoMap.remove(id);
    }
}
