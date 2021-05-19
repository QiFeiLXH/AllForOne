package org.qifei.controller;

import org.qifei.entity.UserInfo;
import org.qifei.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @BelongsProject: AllForOne
 * @BelongsPackage: org.qifei.controller
 * @Author: QiFei
 * @CreateTime: 2020-03-26 16:14
 * @Description:
 */
@RestController
@RequestMapping
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;

    @GetMapping("/userInfo/{id}")
    public Object getUserInfo(@PathVariable Integer id) {
        UserInfo userInfo = userInfoService.getByName(id);
        if (userInfo == null) {
            return "没有该用户";
        }
        return userInfo;
    }

    @PostMapping("/userInfo")
    public Object createUserInfo(@RequestBody UserInfo userInfo) {
        userInfoService.addUserInfo(userInfo);
        return "SUCCESS";
    }

    @PutMapping("/userInfo")
    public Object updateUserInfo(@RequestBody UserInfo userInfo) {
        UserInfo newUserInfo = userInfoService.updateUserInfo(userInfo);
        if (newUserInfo == null){
            return "不存在该用户";
        }
        return newUserInfo;
    }

    @DeleteMapping("/userInfo/{id}")
    public Object deleteUserInfo(@PathVariable Integer id) {
        userInfoService.deleteById(id);
        return "SUCCESS";
    }
}
