package com.qiumingjie.dao;

import com.qiumingjie.FormEnum;
import com.qiumingjie.dao.record.AnesthesiaAfterOpraKonwedRep;
import com.qiumingjie.dao.record.AnesthesiaBrforeOpraRep;
import com.qiumingjie.utils.CommonUtils;
import com.qiumingjie.utils.Validate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Field;

/**
 * @author QiuMingJie
 * @date 2020-06-30 10:09
 * @description
 */
@Component
public class RepositoryContext {

    @Resource
    AnesthesiaAfterOpraKonwedRep AnesthesiaAfterOpraKonwed;

    @Resource
    AnesthesiaBrforeOpraRep AnesthesiaBrforeOpra;


    public JpaRepository getRepository(String formDictCode) {
        try {
            FormEnum emuByCode = FormEnum.getEmuByCode(formDictCode);
            if (CommonUtils.empty(emuByCode)) {
                Validate.error("获取字典表枚举失败");
            }
            String entityName = emuByCode.getHandler().getSimpleName();
            Field anesthesiaAfterOpraKonwed = this.getClass().getDeclaredField(entityName);
            return (JpaRepository) anesthesiaAfterOpraKonwed.get(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
