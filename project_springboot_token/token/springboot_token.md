#### springboot_token
- 第三方调用接口生成token(api-token)

1.实现过程:当一个请求过来后，服务器就去缓存服务器中查询这个Token是否存在，存在则调用接口，不存在返回接口错误，一般通过拦截器或者过滤器来实现

2.作用：防止dos攻击

3.实现步骤：

    <1:调用接口，生成appId与key
 
    <2:通过appId+key+timestamp(时间搓)加密之后成sign，与传过来的sign进行对比，匹配成功，生成token为key存储在redis，下次调用这个接口的时候先看redis是否有对应的key过期时间两小时，而不是每次调用都去进行token生成
 
    <3:客户端调用的第三方接口，利用拦截器，判断是否匹配token，可以用自定义注解做拦截器，这样就能明确指定拦截地址下哪些接口需要利用token进行拦截匹配
 
 - 用户token(user-token)
 1. 实现步骤
 
    <1:调用接口，生成appId与key
    
    <2:输入用户名和密码，验证数据库是否有此用户，通过密码验证
    
    <3:保存一个uuid为key的，关联token信息的redis
    
    <4:通过加密算法计算出sign，返回给前端token与sign还有appid的值
    
    <5:通过传入参数匹配sign看是否通过匹配