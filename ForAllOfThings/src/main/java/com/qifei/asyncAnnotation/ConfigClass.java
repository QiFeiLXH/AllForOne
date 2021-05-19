package com.qifei.asyncAnnotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @Author Xuhui Lin
 * @Date 2020/8/5 14:47
 * @Description
 */
@EnableAsync
@Configuration
@ComponentScan("com.qifei.asyncAnnotation")
public class ConfigClass {
}
