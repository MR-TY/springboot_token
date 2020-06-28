package com.ty.token.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author tangyu
 * @date 2020/6/28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResult {

    /**
     * 代码
     */
    private String code;

    /**
     * 结果
     */
    private String msg;
}