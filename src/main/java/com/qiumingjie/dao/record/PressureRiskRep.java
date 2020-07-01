package com.qiumingjie.dao.record;

import com.qiumingjie.entities.record.PressureRisk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author QiuMingJie
 * @date 2020-06-28 22:46
 * @description
 */
@Repository
public interface PressureRiskRep extends JpaRepository<PressureRisk, String> {
}
