package com.qiumingjie.dao.formSystem.record;

import com.qiumingjie.entities.formSystem.record.RecAnesthesiaBrforeOpra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author QiuMingJie
 * @date 2020-06-30 11:43
 * @description
 */
@Repository
public interface AnesthesiaBrforeOpraRep extends JpaRepository<RecAnesthesiaBrforeOpra, String> {
}
