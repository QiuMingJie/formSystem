package com.qiumingjie.dao.dict;

import com.qiumingjie.entities.evaluate.dict.Relation;
import com.qiumingjie.entities.evaluate.dict.RelationKeys;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author QiuMingJie
 * @date 2020-01-22 12:06
 * @description
 */
@Repository
public interface RelationRepository extends JpaRepository<Relation, RelationKeys> {

    /**
     * @return
     */
    List<Relation> findAllById_FormDictId(String formDictId);

    List<Relation> findAllById_ItemId(String itemId);

    /**
     * 注意更新和删除是需要加事务的， 并且要加上 @Modify的注解
     *
     * @Modifying注解 1、在@Query注解中编写JPQL实现DELETE和UPDATE操作时候必须加上@Modifying注解，通知Spring Data这是一个delete或者updata操作
     * <p>
     * 2、 updata和delete操作需要使用事务，此时需要定义service层，在service方法上添加事务操作
     * <p>
     * 3、 注意JPQL不支持insert操作
     * @Query 如果在注解中添加 nativeQuery=true 是支持原生SQL查询
     */
    @Modifying
    @Transactional(rollbackFor = RuntimeException.class)
    @Query("delete from Relation a where a.id  in (?1)")
    void deleteByIdList(List<RelationKeys> ids);


}
