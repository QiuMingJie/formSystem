package com.qiumingjie.dao.dict;

import com.qiumingjie.entities.evaluate.dict.ItemDict;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author QiuMingJie
 * @date 2020-01-22 12:04
 * @description
 */
@Repository
public interface ItemDictRepository extends JpaRepository<ItemDict, String> {

    List<ItemDict> findByItemId(String itemId);

    /**
     * 查找每个头部的下一个数
     *
     * @return itemIdHead->I0001,itemNextInt -> 2
     */
    @Query("select new map( substring(a.itemId,1,5) as itemIdHead ,(max( substring(a.itemId,6,9) )+1 ) as itemIdNextInt)from ItemDict a  group by substring(a.itemId,1,5) ")
    List<Map> findItemHeadAndNextInt();

    ItemDict findFirstByItemIdStartingWithAndContentContainsAndDeleteFlagIsNullAndUseFlagIsNullAndRemarkIsAndUnitsIsAndValueLevelIs(String itemIdHead,String contentLike,String remark,String unit,Integer valuesLevel);

}
