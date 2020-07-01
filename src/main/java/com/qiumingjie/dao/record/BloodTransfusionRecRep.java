package com.qiumingjie.dao.record;

import com.qiumingjie.entities.record.BloodTransfusionRec;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author QiuMingJie
 * @date 2020-06-28 22:46
 * @description
 */
@Repository
public interface BloodTransfusionRecRep  extends JpaRepository<BloodTransfusionRec, String> {
}
