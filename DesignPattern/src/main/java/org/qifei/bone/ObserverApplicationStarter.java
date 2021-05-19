package org.qifei.bone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.retry.annotation.EnableRetry;


/**
 * @Author Xuhui Lin
 * @Date 2021/1/26 16:04
 * @Description
 */
@SpringBootApplication
@ComponentScan("org.qifei.bone.**")
@EnableRetry
public class ObserverApplicationStarter {

    public static void main(String[] args) {
        SpringApplication.run(ObserverApplicationStarter.class,args);
    }

    /*@EventListener
    public void contextEvent(ContextRefreshedEvent contextEvent) throws InterruptedException, SQLException {
        ApplicationContext context = contextEvent.getApplicationContext();
        UserService userService = context.getBean(UserService.class);
        userService.register("9755");
    }*/
}
