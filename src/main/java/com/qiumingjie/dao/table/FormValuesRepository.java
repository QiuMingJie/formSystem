package com.qiumingjie.dao.table;

import com.qiumingjie.entities.evaluate.table.FormValues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author QiuMingJie
 * @date 2020-02-17 15:34
 * @description
 */
@Repository
public interface FormValuesRepository extends JpaRepository<FormValues,String> {
}
