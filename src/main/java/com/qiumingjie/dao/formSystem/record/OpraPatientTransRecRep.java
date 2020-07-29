package com.qiumingjie.dao.formSystem.record;

import com.qiumingjie.entities.formSystem.record.RecOpraPatientTransRec;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author QiuMingJie
 * @date 2020-06-28 22:46
 * @description
 */
@Repository
public interface OpraPatientTransRecRep extends JpaRepository<RecOpraPatientTransRec, String> {
}
