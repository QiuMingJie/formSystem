package com.qiumingjie.dao.record;

import com.qiumingjie.entities.record.ConsumApprove;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author QiuMingJie
 * @date 2020-06-28 22:47
 * @description
 */
@Repository
public interface ConsumApproveRep extends JpaRepository<ConsumApprove, String> {
}
