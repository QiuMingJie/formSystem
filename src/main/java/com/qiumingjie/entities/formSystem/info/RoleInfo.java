package com.qiumingjie.entities.formSystem.info;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author QiuMingJie
 * @date 2020-09-01 10:22
 * @description
 */
@Entity
@Table(name = "SM_Role")
@Data
public class RoleInfo implements Serializable {
    @Id
    private Integer roleIdentity;

    private String smRoleName;

    private String description;

    private Boolean flag;
}
