package com.ty.token;

import lombok.extern.slf4j.Slf4j;
import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.util.text.BasicTextEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author yangq
 * Create time in 2020-06-28 09:59
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class JasyptEncryptorTest {

    @Autowired
    private StringEncryptor stringEncryptor;


    @Test
    public void contextLoads() {
        String qwerty1234 = stringEncryptor.encrypt("122.51.212.111");
        System.out.println(qwerty1234);
        String orignalPassWord = stringEncryptor.decrypt("pDHZfsqmMVcKE/nhFgVTbwbhf6NnAIlAFd632yO6khM=");
        System.out.printf(orignalPassWord);
        System.out.printf("------------");
        String password = stringEncryptor.encrypt("mnbzxc1234");
        System.out.printf(password);
    }

    @Test
    public void setPassWord(){
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        //加密所需的salt(盐)
        textEncryptor.setPassword("G0CvDz7oJn6");
        //要加密的数据（数据库的用户名或密码）
        String username = textEncryptor.encrypt("122.51.212.111");
        System.out.println("username:"+username);

    }
}
