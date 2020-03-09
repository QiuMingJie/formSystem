package com.qiumingjie.controller;

import com.qiumingjie.dao.InfoRepository;
import com.qiumingjie.entities.Info;
import com.qiumingjie.handler.JsonHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author QiuMingJie
 * @date 2020-02-26 13:49
 * @description
 */
@RestController
@RequestMapping("/invoke")
public class InvokeController {

    @Autowired
    private InfoRepository infoRepository;

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public JsonHandler invokeForm(Info info) {
        return new JsonHandler("200", "http://122.51.171.14:8080/formweb/#/Index?info=" + infoRepository.save(info).getId().toString(), info);
    }

    @RequestMapping(value = "/getInfo", method = RequestMethod.GET)
    public JsonHandler getInfo(String id) {
        return JsonHandler.succeed(infoRepository.findById(id).get());
    }

}
