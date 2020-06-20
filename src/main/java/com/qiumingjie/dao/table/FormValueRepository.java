package com.qiumingjie.dao.table;

import com.qiumingjie.entities.evaluate.dict.RelationKeys;
import com.qiumingjie.entities.evaluate.table.FormValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author QiuMingJie
 * @date 2020-01-22 12:13
 * @description
 */
@Repository
public interface FormValueRepository extends JpaRepository<FormValue, RelationKeys> {
}
