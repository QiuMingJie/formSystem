package com.qiumingjie.dao.dict;

import com.qiumingjie.entities.evaluate.dict.ItemDict;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author QiuMingJie
 * @date 2020-01-22 12:04
 * @description
 */
@Repository
public interface ItemDictRepository extends JpaRepository<ItemDict, String> {

     List<ItemDict> findByItemId(String itemId);
}
