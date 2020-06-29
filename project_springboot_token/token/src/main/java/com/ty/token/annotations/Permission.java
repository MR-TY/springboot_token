package com.ty.token.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author tangyu
 * @date 2020-06-29 11:15
 */
@Documented
@Retention(RUNTIME)
@Target({TYPE, METHOD})
public @interface Permission {

}
