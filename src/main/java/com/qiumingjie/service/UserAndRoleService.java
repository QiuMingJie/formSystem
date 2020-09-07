package com.qiumingjie.service;

import com.qiumingjie.dao.formSystem.info.RoleInfoRepository;
import com.qiumingjie.dao.formSystem.info.UserInfoRepository;
import com.qiumingjie.dto.UserAndRoleDto;
import com.qiumingjie.entities.formSystem.info.RoleInfo;
import com.qiumingjie.entities.formSystem.info.UserInfo;
import com.qiumingjie.utils.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author QiuMingJie
 * @date 2020-09-01 11:21
 * @description
 */
@Service
public class UserAndRoleService {
    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private RoleInfoRepository roleInfoRepository;

    public UserAndRoleDto getUserAndRoleInfoByUserId(Integer userId) {
        Optional<UserInfo> userInfoOptional = userInfoRepository.findById(userId);
        if (!userInfoOptional.isPresent()) {
            Validate.error("获取用户失败，用户不存在");
        }
        UserInfo userInfo = userInfoOptional.get();
        if (userInfo.getRoleIdentity() == null) {
            Validate.error("此用户无授权角色");
        }
        Optional<RoleInfo> roleInfoOptional = roleInfoRepository.findById(userInfo.getRoleIdentity());
        if (!roleInfoOptional.isPresent()) {
            Validate.error("编码角色不存在");
        }
        return new UserAndRoleDto(userInfo, roleInfoOptional.get());
    }

}
