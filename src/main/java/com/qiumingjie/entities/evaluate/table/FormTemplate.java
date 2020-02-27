package com.qiumingjie.entities.evaluate.table;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * @author QiuMingJie
 * @date 2020-01-21 17:44
 * @description 表格模板表，
 */
@MappedSuperclass
public class FormTemplate extends BaseEntity implements Serializable {


    /**
     * 护士签名部分
     */
    private String nurseName1;

    private String nurseName2;

    private String nurseName3;

    private String signFlag;

    private String sign3DateTime;

    private String sign1DateTime;

    private String sign2DateTime;



    public String getNurseName1() {
        return nurseName1;
    }

    public void setNurseName1(String nurseName1) {
        this.nurseName1 = nurseName1;
    }

    public String getNurseName2() {
        return nurseName2;
    }

    public void setNurseName2(String nurseName2) {
        this.nurseName2 = nurseName2;
    }

    public String getNurseName3() {
        return nurseName3;
    }

    public void setNurseName3(String nurseName3) {
        this.nurseName3 = nurseName3;
    }


    public String getSignFlag() {
        return signFlag;
    }

    public void setSignFlag(String signFlag) {
        this.signFlag = signFlag;
    }

    public String getSign3DateTime() {
        return sign3DateTime;
    }

    public void setSign3DateTime(String sign3DateTime) {
        this.sign3DateTime = sign3DateTime;
    }

    public String getSign1DateTime() {
        return sign1DateTime;
    }

    public void setSign1DateTime(String sign1DateTime) {
        this.sign1DateTime = sign1DateTime;
    }

    public String getSign2DateTime() {
        return sign2DateTime;
    }

    public void setSign2DateTime(String sign2DateTime) {
        this.sign2DateTime = sign2DateTime;
    }
}
