package com.ypmai.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description: springboot正常启动但访问404
 * Created by MaiYuPing on 2018/12/24
 *
 * 一: spring boot的启动类不能直接放在main(src.java.main)这个包下面，把它放在有包的里面就可以了。
 *
 * 二: 正常启动了，但是我写了一个controller ，用的 @RestController 注解去配置的 controller，然后路径也搭好了，但是浏览器一直报404.
 *  最后原因是，spring boot只会扫描启动类当前包和以下的包。如果将 spring boot 放在 包  com.dai.controller 里面的话 ，
 *  它会扫描 com.dai.controller 和 com.dai.controller.* 里面的所有的； 
 *  还有一种解决方案是 在启动类的上面添加 @ComponentScan(basePackages = {"com.dai.*"})
 * 来源：CSDN
 * 原文：https://blog.csdn.net/weixin_37304575/article/details/79495129
 *
 * 三：除了上面的方式：将每一个包置于与启动类同一个包下
 *
 */


@SpringBootApplication
// @ComponentScan(basePackages = {"com.ypmai.*"})// 已经将每个包置于与启动类同一个包下
public class BlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class, args);
    }

}

