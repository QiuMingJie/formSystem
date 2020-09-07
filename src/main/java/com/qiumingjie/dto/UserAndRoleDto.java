package com.qiumingjie.dto;

import com.qiumingjie.entities.formSystem.info.RoleInfo;
import com.qiumingjie.entities.formSystem.info.UserInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author QiuMingJie
 * @date 2020-09-01 11:22
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAndRoleDto {
    private UserInfo userInfo;
    private RoleInfo roleInfo;
}
