package com.qiumingjie.dao.formSystem.record;

import com.qiumingjie.entities.formSystem.record.RecOpraNurseRec;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author QiuMingJie
 * @date 2020-06-28 22:45
 * @description
 */
@Repository
public interface OpraNurseRecRep extends JpaRepository<RecOpraNurseRec, String> {
}
