package com.ty.token.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * @author tangyu
 * @date 2020/6/28
 */
@Data
@AllArgsConstructor
public class AccessToken {

    /**
     * token
     */
    private String token;

    /**
     * 失效时间
     */
    private Date expireTime;
}
