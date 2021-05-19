package org.qifei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @BelongsProject: AllForOne
 * @BelongsPackage: org.qifei
 * @Author: QiFei
 * @CreateTime: 2020-03-26 17:37
 * @Description:
 */
@EnableCaching
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
