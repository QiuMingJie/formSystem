package com.qiumingjie.dao.formSystem.info;

import com.qiumingjie.entities.formSystem.info.RoleInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author QiuMingJie
 * @date 2020-07-01 10:15
 * @description
 */
@Repository
public interface RoleInfoRepository extends JpaRepository<RoleInfo, Integer> {

}
