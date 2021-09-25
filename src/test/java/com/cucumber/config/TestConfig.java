package com.cucumber.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@ComponentScan(basePackages = "com.cucumber")
@PropertySource("classpath:/application-${environment:dev}.properties")
public class TestConfig {
}
