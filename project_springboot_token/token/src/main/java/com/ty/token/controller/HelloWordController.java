package com.ty.token.controller;

import com.ty.token.annotations.Permission;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tangyu
 * @date 2020-06-29 10:09
 * api提供给第三方的访问接口token
 */
@RestController
@RequestMapping("/hello")
public class HelloWordController {
    /**
     * 注解后需要拦截判断
     * @return
     */
    @GetMapping("hello")
    @Permission
    public String hello() {
        return "hello world";
    }

    /**
     * 不需要拦截判断
     * @return
     */
    @GetMapping("word")
    public String word() {
        return "word";
    }
}
