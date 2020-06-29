package com.ty.token.interceptor;

import com.ty.token.annotations.Permission;
import com.ty.token.entity.TokenInfo;
import com.ty.token.exception.IllegalRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

import static java.util.Objects.isNull;

/**
 * @author tangyu
 * @date 2020-06-29 10:10
 */
@Component
public class ApiInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        if (apiRequired(handlerMethod.getMethod())){
            String token = request.getHeader("token");
            if (StringUtils.isEmpty(token)) {
                throw new IllegalRequestException("不合法的请求头！！！");
            }
            ValueOperations<String, TokenInfo> tokenRedis = redisTemplate.opsForValue();
            TokenInfo tokenInfo = tokenRedis.get(token);
            if (isNull(tokenInfo)) {
                throw new IllegalRequestException("token已过期，或者是一个错误token!!!");
            }
            return true;
        }
        return true;
    }

    public static boolean apiRequired(Method method) {
        //注解在方法上
        if (method.isAnnotationPresent(Permission.class) || method.isAnnotationPresent(Permission.class)) {
            return true;
        }
        //注解在类上
        Class<?> declaringClass = method.getDeclaringClass();
        if (declaringClass.isAnnotationPresent(Permission.class) || method.isAnnotationPresent(Permission.class)) {
            return true;
        }
        return false;
    }

}
