package com.qiumingjie.dao.record;

import com.qiumingjie.entities.record.OpraNurseRec;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author QiuMingJie
 * @date 2020-06-28 22:45
 * @description
 */
@Repository
public interface OpraNurseRecRep extends JpaRepository<OpraNurseRec, String> {
}
