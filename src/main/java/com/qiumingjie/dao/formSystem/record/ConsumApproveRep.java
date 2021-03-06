package com.qiumingjie.dao.formSystem.record;

import com.qiumingjie.entities.formSystem.record.RecConsumApprove;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author QiuMingJie
 * @date 2020-06-28 22:47
 * @description
 */
@Repository
public interface ConsumApproveRep extends JpaRepository<RecConsumApprove, String> {
}
