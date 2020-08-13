package com.qiumingjie.dao.formSystem;

import com.qiumingjie.entities.formSystem.Sign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author QiuMingJie
 * @date 2020-07-01 9:15
 * @description
 */
@Repository
public interface SignRepository extends JpaRepository<Sign,String> {

    List<Sign> findAllByFormId(String formId);

    void deleteAllByFormId(String formId);

    List<Sign> findAllByFormIdAndGroupId(String formId, String groupId);
}
