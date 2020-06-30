package com.qiumingjie.dao.record;

import com.qiumingjie.entities.record.AnesthesiaAfterOpraKonwed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author QiuMingJie
 * @date 2020-06-30 10:22
 * @description
 */
@Repository
public interface AnesthesiaAfterOpraKonwedRep extends JpaRepository<AnesthesiaAfterOpraKonwed, String> {
}
