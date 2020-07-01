package com.qiumingjie.dao;

import com.qiumingjie.entities.info.DoctorInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author QiuMingJie
 * @date 2020-07-01 10:15
 * @description
 */
@Repository
public interface DoctorRepository extends JpaRepository<DoctorInfo,String> {
}
