package com.qiumingjie.utils;

/**
 * @author QiuMingJie
 * @date 2020-01-26 21:43
 * @description 这个类用来记录一些魔法值和一些公共的生成方法
 */
public class FormUtil {
    /**
     * 输出之间的间隔，四个空格
     */
    public static String soutBank = "    ";


    /**
     * 计算下一个实体的id
     * @param currentId 当前实体id
     * @return 下一个实体id
     */
    public static String caculFormEntityId(String currentId) {
        if (currentId.length() < 10) {
            return currentId + "_0001";
        }
        String templateId = getFormDictId(currentId);
        String index = currentId.substring(10, 14);
        Integer i = Integer.parseInt(index)+1;
        return templateId + fillInteger(i);
    }

    private static String fillInteger(Integer i) {
        String s = String.valueOf(i);
        while (s.length() < 4) {
            s = "0" + s;
        }
        return s;
    }

    /**
     * 根据formId剪切得到formDictId
     * @param formId 实体id E0001_001_0001
     * @return 字典id E0001_001
     */
    public static String getFormDictId(String formId) {
        return formId.substring(0,10);
    }

}
