package com.qiumingjie.handler;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.extern.slf4j.Slf4j;

/**
 * @author QiuMingJie
 * @date 2020-01-20 21:14
 * @Description
 */
@Slf4j
public class JsonHandler implements java.io.Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public static final String ERROR = "系统异常， 请联系管理员";
    public static final String CD0[] = {"200", "操作成功"};
    public static final String CD1[] = {"300", "操作失败"};
    public static final String CD2[] = {"301", "会话超时,请重新登录"};
    public static final String CD3[] = {"400", "请重新获取"};

    public JsonHandler() {
    }

    public JsonHandler(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public JsonHandler(String code, String desc, Object data) {
        this.code = code;
        this.desc = desc;
        this.data = data;
    }

    public static JsonHandler succeed() {
        return new JsonHandler(JsonHandler.CD0[0], JsonHandler.CD0[1]);
    }

    public static JsonHandler succeed(Object data) {
        return new JsonHandler(JsonHandler.CD0[0], JsonHandler.CD0[1], data);
    }
    public static JsonHandler succeed(String desc,Object data) {
        return new JsonHandler(JsonHandler.CD0[0], desc, data);
    }

    public static JsonHandler fail() {
        return new JsonHandler(JsonHandler.CD1[0], JsonHandler.CD1[1]);
    }

    public static JsonHandler fail(String desc) {
        log.error("操作失败，失败信息："+desc);
        return new JsonHandler(JsonHandler.CD1[0], desc);
    }

    public static JsonHandler fail(Object data) {
        return new JsonHandler(JsonHandler.CD1[0], JsonHandler.CD1[1], data);
    }

    public static JsonHandler fail(String desc, Object data) {
        return new JsonHandler(JsonHandler.CD1[0], desc, data);
    }

    public static JsonHandler timeout() {
        return new JsonHandler(JsonHandler.CD2[0], JsonHandler.CD2[1]);
    }

    public static JsonHandler timeout(String desc) {
        return new JsonHandler(JsonHandler.CD2[0], desc);
    }

    public static JsonHandler retry() {
        return new JsonHandler(JsonHandler.CD3[0], JsonHandler.CD3[1]);
    }

    public static JsonHandler retry(String desc) {
        return new JsonHandler(JsonHandler.CD3[0], desc);
    }

    private String code;
    private String desc;
    private Object data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @JsonIgnore
    public boolean isFail() {
        return JsonHandler.CD1[0].equals(this.code);
    }
}
