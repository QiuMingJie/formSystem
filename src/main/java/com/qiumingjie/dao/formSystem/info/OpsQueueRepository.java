package com.qiumingjie.dao.formSystem.info;

import com.qiumingjie.entities.formSystem.info.OpsQueue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author QiuMingJie
 * @date 2020-03-10 17:53
 * @description
 */
@Repository
public interface OpsQueueRepository extends JpaRepository<OpsQueue, String> {

}
