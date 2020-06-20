package com.qiumingjie.dao.table;

import com.qiumingjie.entities.evaluate.table.FormValues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author QiuMingJie
 * @date 2020-02-17 15:34
 * @description
 */
@Repository
public interface FormValuesRepository extends JpaRepository<FormValues, String> {
    public List<FormValues> findAllByPatientId(String patientId);

    public List<FormValues> findAllByOperationId(String operationId);

    public List<FormValues> findAllByPatientIdAndOperationId(String patientId, String operationId);

}
