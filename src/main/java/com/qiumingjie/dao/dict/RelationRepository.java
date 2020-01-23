package com.qiumingjie.dao.dict;

import com.qiumingjie.entities.evaluate.dict.Relation;
import com.qiumingjie.entities.evaluate.dict.RelationKeys;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author QiuMingJie
 * @date 2020-01-22 12:06
 * @description
 */
@Repository
public interface RelationRepository extends JpaRepository<Relation, RelationKeys> {

    /**
     *
     * @return
     */
//    @Query("select Relation from Relation ")
//     Relation findRelationsByFormId1();


}
