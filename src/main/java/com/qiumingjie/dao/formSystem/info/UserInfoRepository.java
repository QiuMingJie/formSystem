package com.qiumingjie.dao.formSystem.info;

import com.qiumingjie.entities.formSystem.info.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author QiuMingJie
 * @date 2020-07-01 10:15
 * @description
 */
@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {
    UserInfo findAllByUserNumber(String userNumber);


}
