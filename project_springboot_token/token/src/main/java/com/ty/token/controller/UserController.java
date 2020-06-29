package com.ty.token.controller;

import com.ty.token.config.annotation.NotRepeatSubmit;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tangyu
 * @date 2020-06-29 14:26
 */
@RestController
@RequestMapping("/user/api")
public class UserController {

    @NotRepeatSubmit(1000000)
    @GetMapping("word")
    public String word() {
        return "word";
    }
}
