package com.qiumingjie.dao;

import com.qiumingjie.entities.PatientInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author QiuMingJie
 * @date 2020-02-26 14:09
 * @description 传输数据表
 */
@Repository
public interface PatientInfoRepository extends JpaRepository<PatientInfo, String> {
}
