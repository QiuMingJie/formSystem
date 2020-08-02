package com.qiumingjie.dto;

import com.qiumingjie.entities.formSystem.Sign;
import lombok.Data;

import java.util.List;

/**
 * @author QiuMingJie
 * @date 2020-08-02 15:42
 * @description
 */
@Data
public class ValueToSignDto {
    List<Sign> signList;
}
