package org.qifei.bone;

import org.qifei.bone.pattern.strategy.PermissionService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

import java.sql.SQLException;

/**
 * @Author Xuhui Lin
 * @Date 2021/1/27 10:15
 * @Description
 */
@SpringBootApplication
public class StrategyApplicationStarter {
    public static void main(String[] args) {
        SpringApplication.run(StrategyApplicationStarter.class,args);
    }

    @EventListener
    public void contextEvent(ContextRefreshedEvent contextEvent) throws InterruptedException, SQLException {
        ApplicationContext context = contextEvent.getApplicationContext();
        PermissionService bean = context.getBean(PermissionService.class);
    }
}
