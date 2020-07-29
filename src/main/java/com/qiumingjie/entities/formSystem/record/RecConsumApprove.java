package com.qiumingjie.entities.formSystem.record;

import com.qiumingjie.entities.formSystem.evaluate.table.FormTemplate;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author QiuMingJie
 * @date 2020-06-28 22:47
 * @description
 */
@Entity
@DynamicUpdate
@Table
public class RecConsumApprove extends FormTemplate {
}
