package com.qiumingjie.dao.record;

import com.qiumingjie.entities.record.UseExpensiveKnowed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author QiuMingJie
 * @date 2020-06-28 22:47
 * @description
 */
@Repository
public interface UseExpensiveKnowedRep extends JpaRepository<UseExpensiveKnowed, String> {
}
