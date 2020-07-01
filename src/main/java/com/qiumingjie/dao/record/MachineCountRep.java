package com.qiumingjie.dao.record;

import com.qiumingjie.entities.record.MachineCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author QiuMingJie
 * @date 2020-06-28 22:35
 * @description
 */
@Repository
public interface MachineCountRep extends JpaRepository<MachineCount, String> {
}
