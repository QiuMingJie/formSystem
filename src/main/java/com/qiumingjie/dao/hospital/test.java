package com.qiumingjie.dao.hospital;

import com.qiumingjie.entities.formSystem.Sign;
import com.qiumingjie.entities.hospital.TestEN;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author QiuMingJie
 * @date 2020-07-29 19:39
 * @description
 */
@Repository
public interface test extends JpaRepository<TestEN,String> {

    List<Sign> findAllByFormId(String formId);

    void deleteAllByFormId(String formId);
}