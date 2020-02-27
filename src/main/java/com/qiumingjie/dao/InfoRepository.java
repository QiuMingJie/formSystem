package com.qiumingjie.dao;

import com.qiumingjie.entities.Info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author QiuMingJie
 * @date 2020-02-26 14:09
 * @description 传输数据表
 */
@Repository
public interface InfoRepository extends JpaRepository<Info,String> {
}
