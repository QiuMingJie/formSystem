package com.qiumingjie.dao.formSystem.record;

import com.qiumingjie.entities.formSystem.record.RecAnesthesiaKonwed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author QiuMingJie
 * @date 2020-06-28 22:46
 * @description
 */
@Repository
public interface AnesthesiaKonwedRep extends JpaRepository<RecAnesthesiaKonwed, String> {
}
