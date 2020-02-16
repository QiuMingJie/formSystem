package com.qiumingjie.controller;

import com.qiumingjie.service.FormAddDictService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author QiuMingJie
 * @date 2020-02-12 21:31
 * @description
 */
public class Test {

    @Autowired
    public static FormAddDictService formAddDictService;

    public static String test() {
        return formAddDictService.gettest();
    }

    public static void main(String[] args) {
        System.out.println(test());
    }
}
